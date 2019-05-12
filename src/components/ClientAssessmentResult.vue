<template>
    <div class="col-md-9" style="border: 1px black solid;height:1200px">
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th v-for="col in columns">{{ col.name }}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="entry in results">
                        <td v-for="col in columns">{{ entry[col.id] }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from "vuex"
    export default {
        name: "ClientAssessmentResult",
        data () {
            return {
                columns:[
                    {"id":"name", "name":"Название"},
                    {"id":"create_date", "name":"Дата создания"},
                    {"id":"result", "name":"Результат"}
                ],

                results:[
                    {"id":1, "name":"test", "create_date":"1412743274", "result":"in process"},
                    {"id":1, "name":"test2", "create_date":"1412743274", "result":"https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Mooncake1.jpg/300px-Mooncake1.jpg"}
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
        }
    }
</script>

<style>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
