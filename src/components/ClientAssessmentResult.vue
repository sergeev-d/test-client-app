<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div class="col-md-10 main-content">
        <v-app>
            <v-toolbar flat color="white">
                <v-spacer></v-spacer>
            </v-toolbar>
            <v-data-table
                    :headers="headers"
                    :items="assessmentsResult"
                    class="elevation-1"
                    rows-per-page-text="строк на страницу"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.assessmentName }}</td>
                    <!--<td class="text-xs-left">{{ props.item.createDate }}</td>-->
                    <td class="text-xs-left">{{ "10.06.2019" }}</td>
                    <td class="text-xs-left"><v-btn @click="showResult(props.item)" >Результат</v-btn></td>
                </template>
                <template v-slot:no-data>
                    <v-btn color="primary" @click="fetchData">Reset</v-btn>
                </template>
            </v-data-table>
            <v-dialog
                    v-model="dialog"
                    width="1200"

            >
                <v-card>
                    <v-card-title
                            class="headline grey lighten-2"
                            primary-title
                    >
                        Результаты оценки
                    </v-card-title>
                    <v-card-text width="600" height="400">
                        <canvas id="marksChart" width="600" height="400"></canvas>
                    </v-card-text>
                    <!--<v-divider></v-divider>-->
                    <v-spacer></v-spacer>
                    <v-card-text>
                        <h5>Рекомендация:</h5>
                        <v-spacer></v-spacer>
                        {{ item.recommendation }}
                    </v-card-text>
                    <!--<v-divider></v-divider>-->
                    <v-spacer></v-spacer>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                                color="primary"
                                flat
                                @click="dialog = false"
                        >
                            Закрыть
                        </v-btn>
                        <v-btn
                                color="primary"
                                flat
                        >
                            Сохранить
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-app>
    </div>
</template>


<script>
    import { mapGetters } from "vuex"
    import {
        FETCH_USER_ASSESSMENTS_RESULT,
        DOWNLOAD_FILE
    } from "../store/actions.type"
    import Chart from 'chart.js';
    import ResultWithRecommendation from "@/components/ResultWithRecommendation"

    export default {
        name: "ClientAssessmentResult",
        components: {
            ResultWithRecommendation
        },
        data () {
            return {
                dialog: false,
                headers: [
                    {
                        text: 'Название оценки',
                        align: 'left',
                        sortable: true,
                        value: 'name'
                    },
                    {
                        text: 'Дата прохождения',
                        align: 'left',
                        value: 'createdDate'
                    },
                    {
                        text: 'Результат',
                        value: 'link',
                        align: 'left',
                    }
                ],
                item:{}
            }
        },
        filters: {
            capitalize: function (str) {
                return str.charAt(0).toUpperCase() + str.slice(1)
            }
        },
        computed: {
            ...mapGetters(["assessmentsResult"])
        },
        methods: {
            fetchData(){
                this.$store.dispatch(FETCH_USER_ASSESSMENTS_RESULT)
            },
            showResult(assessmentResult){
                this.item = assessmentResult;
                let marksCanvas = document.getElementById("marksChart");

                let marksData = {
                    labels: assessmentResult.blocks,
                    datasets: [
                        {
                            label: "Распределение",
                            backgroundColor: "rgba(200,0,0,0.2)",
                            data: assessmentResult.resultBlockData
                        }
                    ]
                };


                let radarChart = new Chart(marksCanvas, {
                    type: 'radar',
                    data: marksData
                });

                this.dialog = true;
            },
            downloadFile(link){
                this.$store.dispatch(DOWNLOAD_FILE, link)
                    .then((response) => {
                        this.forceFileDownload(response, link)
                    })
                    .catch()

            },
            forceFileDownload(response, fileName){
                const url = window.URL.createObjectURL(new Blob([response]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', fileName) ;//or any other extension
                document.body.appendChild(link);
                link.click()

                // let blob = new Blob([response.blob()], {type: response.headers['content-type']}),
                //     filename = (response.headers['Content-Disposition'] || '').split('filename=')[1];
                // result = document.createElement('a');
                // result.href = window.URL.createObjectURL(blob);
                // result.download = filename;
                // result.click();

                // var blob = new Blob([response]);
                // var blobURL = window.URL.createObjectURL(blob);
                // var tempLink = document.createElement('a');
                // tempLink.style.display = 'none';
                // tempLink.href = blobURL;
                // tempLink.setAttribute('download', fileName);
                //
                // if (typeof tempLink.download === 'undefined') {
                //     tempLink.setAttribute('target', '_blank');
                // }
                //
                // document.body.appendChild(tempLink);
                // tempLink.click();
                // document.body.removeChild(tempLink);
                // window.URL.revokeObjectURL(blobURL);
            }
        },
        mounted() {
            this.fetchData();
        }
    }
</script>

<style>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
