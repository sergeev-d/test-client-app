<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <div class="col-md-9 main-content">
        <h4><span>Список оценок</span></h4>
        <hr>
        <div>
            <v-btn small @click="changeAssessment(selected[0])">Изменить <i class="far fa-edit"></i></v-btn>
            <v-btn small @click="deleteAssessment(selected[0])">Удалить <i class="far fa-trash-alt"></i></v-btn>
            <v-btn small @click="applyAssessment(selected[0])">Разместить готовую оценку <i class="fas fa-check"></i></v-btn>
            <v-btn small @click="createNewAssessment()">Добавить новую <i class="fas fa-plus"></i></v-btn>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <!--<th>-->
                    <!--<label class="form-checkbox">-->
                        <!--<input type="checkbox" v-currentAssessment="selectAll" @click="select">-->
                        <!--<i class="form-icon"></i>-->
                    <!--</label>-->
                <!--</th>-->
                <th></th>
                <!--<th data-visible="false">Номер</th>-->
                <th>Название оценки</th>
                <th>Дата последнего изменения</th>
                <th>Статус</th>
                <th>Комментарий модератора</th>
                <th>Количество использований</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="ua in userAssessments">
                <td>
                    <label class="form-checkbox">
                        <input type="checkbox" :value="ua" v-model="selected">
                        <i class="form-icon"></i>
                    </label>
                </td>
                <!--<td>{{i.id}}</td>-->
                <td>{{ua.name}}</td>
                <td>{{ua.createdDate}}</td>
                <td>{{ua.status}}</td>
                <td>{{ua.comment}}</td>
                <td>{{0}}</td>
            </tr>
            </tbody>
        </table>

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
        name: "ExpertAssessments.vue",
        data: () => ({
            selected: [],
            selectAll: false,
            error: ""
        }),
        methods: {
            select() {
                this.selected = [];
                if (!this.selectAll) {
                    for (let i in this.userAssessments) {
                        this.selected.push(this.userAssessments[i]);
                    }
                }
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
        },
        computed:{
            ...mapGetters(["userAssessments", "currentUser", "templateAssessment"])
        },
        mounted() {
            this.$store.dispatch(FETCH_EXPERT_ASSESSMENTS)
        }

    }
</script>

<style scoped>
    i {
        margin: 0 5px;
    }
</style>
