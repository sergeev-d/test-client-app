<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div class="col-md-10 main-content">
        <v-app>
            <v-toolbar flat color="white">
                <v-spacer></v-spacer>
            </v-toolbar>
            <v-data-table
                    :headers="headers"
                    :items="results"
                    class="elevation-1"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.name }}</td>
                    <td class="text-xs-left">{{ props.item.createdDate }}</td>
                    <td class="text-xs-left">{{ props.item.status }}</td>
                    <td class="text-xs-left"><v-btn v-if="props.item.link.length > 0" @click="downloadFile(props.item.link.length)" >Результат</v-btn></td>
                </template>
                <template v-slot:no-data>
                    <v-btn color="primary" @click="fetchData">Reset</v-btn>
                </template>
            </v-data-table>
        </v-app>
    </div>
</template>


<script>
    import { mapGetters } from "vuex"
    import {
        FETCH_USER_ASSESSMENTS_RESULT,
        DOWNLOAD_FILE
    } from "../store/actions.type"

    export default {
        name: "ClientAssessmentResult",
        data () {
            return {
                headers: [
                    {
                        text: 'Название оценки',
                        align: 'left',
                        sortable: true,
                        value: 'name'
                    },
                    {
                        text: 'Дата создания',
                        align: 'left',
                        value: 'createdDate'
                    },
                    {
                        text: 'Статус',
                        value: 'status',
                        align: 'left',
                    },
                    {
                        text: 'Результат',
                        value: 'link',
                        align: 'left',
                    }
                ],
                results:[
                    {"id":1, "name":"assessment1", "createdDate":"1412743274", "status":"in_progress", "link":""},
                    {"id":2, "name":"assessment2", "createdDate":"1412743274", "status":"completed", "link":""},
                    {"id":3, "name":"assessment3", "createdDate":"1412743274", "status":"completed", "link":"HCsqqeRy5lo.jpg"}
                ]
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
