<template>
    <v-app class="col-md-9 sidebar">
    <v-content>

        <v-container>
            <v-stepper v-model="step" vertical>
                <v-stepper-header>
                    <v-stepper-step step="1" :complete="step > 1">Шаг 1</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step step="2" :complete="step > 2">Шаг 2</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step step="3">Шаг 3</v-stepper-step>
                </v-stepper-header>
                <v-stepper-items>
                    <v-stepper-content step="1">
                        <v-text-field label="Название оценки" v-model="currentAssessment.assessmentName" required></v-text-field>
                        <v-textarea label="Описание" v-model="currentAssessment.description" required></v-textarea>
                        <v-select label="Тип компании"
                                  v-model="currentAssessment.companyType"
                                  item-text="name"
                                  item-value="id"
                                  :items="companyTypes"
                                  single-line
                                  required
                        ></v-select>
                        <v-select label="Отрасль"
                                  v-model="currentAssessment.industry"
                                  :items="industries"
                                  item-text="name"
                                  item-value="id"
                                  single-line
                                  required
                        ></v-select>

                        <v-btn color="primary" @click.native="step = 2">Продолжить</v-btn>
                    </v-stepper-content>

                    <v-stepper-content step="2">
                        <div>
                            <label type="text">Редактор блоков вопросов / утверждений</label>
                        </div>
                        <div>
                            <v-select label="Варианты ответов для блоков"
                                      v-model="currentAssessment.strategy"
                                      :items="strategies"
                                      item-text="name"
                                      item-value="id"
                                      single-line
                                      required
                            ></v-select>
                        </div>
                        <div v-for="(qb, index) in currentAssessment.questionBlocks" :value=qb.block :key="index" style="border: 1px black solid">
                            <v-text-field label="Название блока" v-model="qb.block.name" required></v-text-field>
                            <question-block :questions="qb.block.questions"></question-block>
                            <button @click="deleteBlock(index)">Удалить блок</button>
                        </div>
                        <div class="wrapper">
                            <button @click="addBlock()">Добавить блок</button>
                        </div>

                        <v-btn flat @click.native="step = 1">Назад</v-btn>
                        <v-btn color="primary" @click.native="step = 3">Продолжить</v-btn>
                    </v-stepper-content>

                    <v-stepper-content step="3">
                        <div>
                            <label type="text"><span>Редактор оценки и рекомендаций</span></label>
                        </div>
                        <div>
                            <label type="text"><span>Информация про баллы</span></label>
                            <table>
                                <tr>
                                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                                </tr>
                                <tr>
                                    <td><span>{{1}}</span></td>
                                    <td><span>{{2}}</span></td>
                                </tr>
                                <tr>
                                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                                </tr>
                                <tr>
                                    <td><span>{{3}}</span></td>
                                    <td><span>{{4}}</span></td>
                                </tr>
                            </table>
                        </div>
                        <div>
                            <div v-for="(qb, index) in currentAssessment.questionBlocks" :value=qb.block :key="index">
                                <label type="text">{{qb.block.name}}</label>
                                <block-result :recommendations="qb.block.recommendations"></block-result>
                            </div>
                            <div>
                                <label type="text">{{"Глобальная рекомендация"}}</label>
                                <block-result :recommendations="currentAssessment.global_recommendations"></block-result>
                            </div>
                        </div>

                        <v-btn flat @click.native="step = 2">Назад</v-btn>
                        <v-btn color="primary" @click.prevent="submit">Сохранить</v-btn>

                    </v-stepper-content>
                </v-stepper-items>
            </v-stepper>

        </v-container>

    </v-content>
    </v-app>
</template>

<script>
    import { mapGetters } from "vuex"
    import QuestionBlock from '../components/QuestionBlock'
    import BlockResult from '../components/BlockResult'

    export default {
        name: "AssessmentWizard2",
        computed: {
            ...mapGetters(["currentAssessment"])
        },
        data: () => ({
            step:1,
            //industries: [],
            industries: [],
            companyTypes: [],
            strategies: []
        }),
        methods:{
            submit() {
                alert('This is the post. Blah');
            },
            addBlock(){
                this.currentAssessment.questionBlocks.push(
                    {
                        block: {
                            name:"",
                            questions:[],
                            recommendations:[]
                        },
                        global_recommendations:[]
                    }
                )
            },
            deleteBlock(index){
                if (this.currentAssessment.questionBlocks.length !== 1){
                    this.currentAssessment.questionBlocks.splice(index,1)
                }
            }
        },
        mounted() {
            this.industries = [
                { id: '1', name: 'Norm' },
                { id: '2', name: 'Ne norm' }
            ];
            this.companyTypes = [
                { id: '1', name: 'Computer Science' },
                { id: '2', name: 'Physics' }
            ];
            this.strategies = [
                {id: "1", name: "да/нет/не знаю"},
                {id: "2", name: "да/нет/не знаю2"}
            ];
        },
        components:{
            QuestionBlock,
            BlockResult
        }
    }
</script>

<style scoped>

</style>
