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
                        <a id="download" download="result.png">
                            <v-btn
                                color="primary"
                                flat
                                @click="downloadImg()"
                        >
                            Сохранить
                            </v-btn>
                        </a>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-app>
    </div>
</template>


<script>
    import { mapGetters } from "vuex"
    import {
        FETCH_USER_ASSESSMENTS_RESULT
    } from "../store/actions.type"
    import Chart from 'chart.js';

    export default {
        name: "ClientAssessmentResult",

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

                let chartOptions = {
                    scale: {
                        ticks: {
                            beginAtZero: true,
                            min: 0,
                            max: 30,
                            stepSize: 5
                        },
                        pointLabels: {
                            fontSize: 18
                        }
                    },
                    legend: {
                        position: 'left'
                    }
                };

                let radarChart = new Chart(marksCanvas, {
                    type: 'radar',
                    data: marksData,
                    options: chartOptions
                });

                this.dialog = true;
            },
            downloadImg() {
                let canvas=document.getElementById("marksChart");
                let download=document.getElementById("download");
                let image = canvas.toDataURL("image/jpg");
                download.setAttribute("href", image);
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
