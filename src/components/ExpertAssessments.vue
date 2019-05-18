<template>
    <div class="col-md-9 main-content">
        <h4><span>Список оценок</span></h4>
        <hr>
        <div>
            <button @click="changeAssessment(selected[0])">Изменить</button>
            <button @click="deleteAssessment(selected[0])">Удалить</button>
            <button @click="applyAssessment(selected[0])">Разместить готовую оценку</button>
            <button @click="createNewAssessment()">Добавить новую</button>
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
                        <input type="checkbox" :value="ua.id" v-model="selected">
                        <i class="form-icon"></i>
                    </label>
                </td>
                <!--<td>{{i.id}}</td>-->
                <td>{{ua.name}}</td>
                <td>{{ua.create_date}}</td>
                <td>{{ua.status}}</td>
                <td>{{ua.comment}}</td>
                <td>{{ua.execute_cnt}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import { mapGetters } from "vuex"
    import { FETCH_EXPERT_ASSESSMENTS } from "../store/actions.type"

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
                alert(selectedAssessment);
                if (this.selected !== 0){
                    for (let i in this.selected){

                    }
                }
            },
            applyAssessment(selectedAssessment){
                alert(selectedAssessment);
                if (this.selected !== 0){
                    for (let i in this.selected){

                    }
                }
            },
            createNewAssessment(){
                this.$router.push({name: 'create-assessment'})
            },
            changeAssessment(selectedAssessment){
                alert(selectedAssessment);
                this.$router.push({name: 'change-assessment'})
            }

        },
        computed:{
            ...mapGetters(["userAssessments", "currentUser"])
        },
        mounted() {
            this.$store.dispatch(FETCH_EXPERT_ASSESSMENTS)
        }

    }
</script>

<style>

</style>
