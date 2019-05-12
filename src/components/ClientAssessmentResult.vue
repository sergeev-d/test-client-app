<template>
    <div class="col-md-9 main-content">
        <div class="table">
            <table>
                <thead>
                <tr>
                    <th v-for="column in columns" v-bind:key="column.id">{{ column.name }}</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="entry in results" v-bind:key="entry.id">
                    <td v-for="column in columns" v-bind:key="column.id">
                        <span v-if="column.id === 'create_date'">{{ "test" }}</span>
                        <!--https://codepen.io/nigamshirish/pen/ZMpvRa-->
                        <button v-else-if="column.id === 'link' && entry[column.id].length > 0" @click.prevent="downloadFile(entry[column.id])">Посмотреть</button>
                        <span v-else>{{ entry[column.id]}}</span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>


<script>
    import { mapGetters } from "vuex"
    import { DOWNLOAD_FILE } from "../store/actions.type"

    export default {
        name: "ClientAssessmentResult",
        data () {
            return {
                columns:[
                    {"id":"name", "name":"Название"},
                    {"id":"create_date", "name":"Дата создания"},
                    {"id":"status", "name":"Статус"},
                    {"id":"link", "name":"Результат"}
                ],

                results:[
                    {"id":1, "name":"assessment1", "create_date":"1412743274", "status":"in_progress", "link":""},
                    {"id":2, "name":"assessment2", "create_date":"1412743274", "status":"completed", "link":""},
                    {"id":3, "name":"assessment3", "create_date":"1412743274", "status":"completed", "link":"HCsqqeRy5lo.jpg"}
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
            downloadFile(link){
                this.$store.dispatch(DOWNLOAD_FILE, link)
                    .then((response) => {
                        this.forceFileDownload(response, link)
                    })
                    .catch()

            },
            forceFileDownload(response, fileName){
                const url = window.URL.createObjectURL(new Blob([response.data]));
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
            }
        }

    }
</script>

<style>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
