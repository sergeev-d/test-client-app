<template>
    <div class="col-md-9 main-content">
        <h4><span>Список оценок</span></h4>
        <hr>
        <div>
            <button @click="">Изменить</button>
            <button @click="deleteAssessment()">Удалить</button>
            <button @click="applyAssessment()">Разместить готовую оценку</button>
            <button @click="createNewAssessment()">Добавить новую</button>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <!--<th>-->
                    <!--<label class="form-checkbox">-->
                        <!--<input type="checkbox" v-model="selectAll" @click="select">-->
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
            <tr v-for="i in items">
                <td>
                    <label class="form-checkbox">
                        <input type="checkbox" :value="i.id" v-model="selected">
                        <i class="form-icon"></i>
                    </label>
                </td>
                <!--<td>{{i.id}}</td>-->
                <td>{{i.name}}</td>
                <td>{{i.create_date}}</td>
                <td>{{i.status}}</td>
                <td>{{i.comment}}</td>
                <td>{{i.execute_cnt}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ExpertAssessments.vue",
        data: () => ({
            items: [
                {
                    id: "1",
                    name: "John Doe",
                    create_date: "1412743274",
                    status: "черновик",
                    comment: false,
                    execute_cnt: 0
                },
                {
                    id: "2",
                    name: "John Doe",
                    create_date: "1412743274",
                    status: "черновик",
                    comment: false,
                    execute_cnt: 0
                }
            ],
            selected: [],
            selectAll: false,
            error: ""
        }),
        methods: {
            select() {
                this.selected = [];
                if (!this.selectAll) {
                    for (let i in this.items) {
                        this.selected.push(this.items[i].id);
                    }
                }
            },
            deleteAssessment(){
                if (this.selected != 0){
                    for (let i in this.selected){

                    }
                }
            },
            applyAssessment(){
                if (this.selected != 0){
                    for (let i in this.selected){

                    }
                }
            },
            createNewAssessment(){
                this.$router.push({name: 'create-assessment'})
            }

        }

    }
</script>

<style>

</style>
