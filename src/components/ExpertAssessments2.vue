<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div class="col-md-10 main-content">
        <v-app>
            <v-toolbar flat color="white">
                <v-spacer></v-spacer>
                <v-btn color="primary" dark @click="createNewAssessment">Создать оценку</v-btn>
            </v-toolbar>
            <v-data-table
                    :headers="headers"
                    :items="userAssessments"
                    class="elevation-1"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.name }}</td>
                    <td class="text-xs-right">{{ props.item.createdDate }}</td>
                    <td class="text-xs-right">{{ props.item.status }}</td>
                    <td class="text-xs-right">{{ props.item.comment }}</td>
                    <td class="text-xs-right">{{ props.item.execCnt }}</td>
                    <td class="justify-center layout px-0">
                        <v-icon
                                small
                                class="mr-2"
                                @click="changeAssessment(props.item)"
                        >
                            edit
                        </v-icon>
                        <v-icon
                                small
                                @click="deleteAssessment(props.item)"
                        >
                            delete
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
        FETCH_EXPERT_ASSESSMENTS,
        UPDATE_CURRENT_ASSESSMENT,
        DELETE_ASSESSMENT
    } from "../store/actions.type"

    export default {
        name: "ExpertAssessments2.vue",
        data: () => ({
            headers: [
                {
                    text: 'Название оценки',
                    align: 'left',
                    sortable: true,
                    value: 'name'
                },
                { text: 'Дата изменения', value: 'createdDate' },
                { text: 'Статус', value: 'status' },
                { text: 'Комментарий', value: 'comment' },
                { text: 'Количество', value: 'execCnt', sortable: false }
            ]
        }),
        computed: {
            ...mapGetters(["userAssessments", "currentUser", "templateAssessment"])
        },
        mounted () {
            this.fetchData()
        },

        methods: {
            fetchData(){
                this.$store.dispatch(FETCH_EXPERT_ASSESSMENTS)
            },
            deleteAssessment(selectedAssessment){
                if (selectedAssessment){
                    this.$store.dispatch(DELETE_ASSESSMENT, selectedAssessment.id);
                    this.$router.go(this.$router.currentRoute);
                    //this.$router.  push({name: 'expert-'})
                } else {
                    alert("Please select assessment")
                }
            },
            applyAssessment(selectedAssessment){
                if (selectedAssessment){
                    this.currentAssessment = selectedAssessment;
                    //change status  by action
                } else {
                    alert("Please select assessment")
                }
            },
            createNewAssessment(){
                this.$store.dispatch(UPDATE_CURRENT_ASSESSMENT, this.templateAssessment);
                this.$router.push({name: 'create-assessment'})
            },
            changeAssessment(selectedAssessment){
                if (selectedAssessment){
                    this.$store.dispatch(UPDATE_CURRENT_ASSESSMENT, selectedAssessment);
                    this.$router.push({name: 'change-assessment'})
                } else {
                    alert("Please select assessment")
                }
            },
            selectDate(createDate, updateDate){
                if (updateDate){
                    this.unixTimeToDate(updateDate)
                } else {
                    this.unixTimeToDate(createDate)
                }
            },
            unixTimeToDate(unixTime){
                let t = new Date( unixTime );
                return t;
            }
        }
    }
</script>

<style scoped>

</style>
