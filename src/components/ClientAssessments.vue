<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div class="col-md-10 main-content">
        <v-app>
            <v-toolbar flat color="white">
                <v-spacer></v-spacer>
            </v-toolbar>
            <v-data-table
                    :headers="headers"
                    :items="assessments"
                    class="elevation-1"
                    rows-per-page-text="строк на страницу"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.name }}</td>
                    <td class="text-xs-left">{{ props.item.description }}</td>
                    <!--<td class="text-xs-left">{{ props.item.companyTypeId }}</td>-->
                    <td class="text-xs-left">{{ "Некомерческая" }}</td>
                    <!--<td class="text-xs-left">{{ props.item.industryId }}</td>-->
                    <td class="text-xs-left">{{ "Любая" }}</td>
                    <!--<td class="text-xs-left">{{ props.item.createdDate }}</td>-->
                    <td class="text-xs">{{ "10.06.2019" }}</td>
                    <td class="justify-center layout px-2">
                        <v-icon
                                small
                                class="mr-2"
                                @click="executeAssessment(props.item)"
                        >
                            Перейти
                        </v-icon>
                    </td>
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
        FETCH_ASSESSMENTS,
        UPDATE_CURRENT_ASSESSMENT
    } from "../store/actions.type"
    export default {
        name: "ClientAssessments.vue",
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
                        text: 'Описание',
                        align: 'left',
                        value: 'description'
                    },
                    {
                        text: 'Тип компании',
                        align: 'left',
                        value: 'companyTypeId'
                    },
                    {
                        text: 'Отрасль',
                        align: 'left',
                        value: 'industryId'
                    },
                    {
                        text: 'Дата создания',
                        align: 'left',
                        value: 'createdDate'
                    }
                ],
                results:[

                ]
            }
        },
        filters: {
            // capitalize: function (str) {
            //     return str.charAt(0).toUpperCase() + str.slice(1)
            // }
        },
        computed: {
            ...mapGetters(["assessments"])
        },
        methods: {
            fetchData(){
                this.$store.dispatch(FETCH_ASSESSMENTS);
            },
            executeAssessment(selectedAssessment){
                this.$store.dispatch(UPDATE_CURRENT_ASSESSMENT, selectedAssessment)
                    .then(() => {
                        this.$router.push({name: "perform-assessment"})
                    })
            }
        },
        mounted() {
            this.fetchData();
        }
    }
</script>

<style scoped>

</style>
