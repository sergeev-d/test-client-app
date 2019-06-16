<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
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
                        <v-text-field label="Название оценки" v-model="currentAssessment.name" required></v-text-field>
                        <v-textarea label="Описание" v-model="currentAssessment.description" required></v-textarea>
                        <v-select label="Тип компании"
                                  v-model="currentAssessment.companyTypeId"
                                  item-text="name"
                                  item-value="id"
                                  :items="companyTypes"
                                  single-line
                                  required

                        ></v-select>
                        <v-select label="Отрасль"
                                  v-model="currentAssessment.industryId"
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
                        <v-expansion-panel>
                            <v-expansion-panel-content
                                    v-for="(qb, index) in currentAssessment.questionBlocks"
                                    :value=qb.block
                                    :key="index"
                            >
                                <template v-slot:header>
                                    <v-text-field
                                    label="Название блока"
                                    v-model="qb.block.name"
                                    required
                                    style="font-weight: bold; border: none"
                                    >
                                    </v-text-field>
                                </template>
                                <div>
                                    <question-block :questions="qb.block.questions"></question-block>
                                    <v-btn flat color="error" @click="deleteBlock(index)">Удалить блок</v-btn>
                                </div>
                            </v-expansion-panel-content>
                            <div class="wrapper">
                                <v-btn large @click="addBlock()">Добавить блок</v-btn>
                            </div>
                        </v-expansion-panel>

                        <v-btn flat @click.native="step = 1">Назад</v-btn>
                        <v-btn color="primary" @click.native="step = 3">Продолжить</v-btn>
                    </v-stepper-content>

                    <v-stepper-content step="3">
                        <div>
                            <label type="text" style="font-weight: bold"><span>Редактор оценки и рекомендаций</span></label>
                        </div>
                        <div>
                            <label type="text"><span>Информация про баллы</span></label>
                            <table>
                                <tr>
                                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                                </tr>
                                <tr>
                                    <td><span>{{ minBlockValue }}</span></td>
                                    <td><span>{{ maxBlockValue }}</span></td>
                                </tr>
                                <tr>
                                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                                </tr>
                                <tr>
                                    <td><span>{{ calcMinValue() }}</span></td>
                                    <td><span>{{ calcMaxValue() }}</span></td>
                                </tr>
                            </table>
                        </div>
                        <!--<div>-->
                            <!--<div v-for="(qb, index) in currentAssessment.questionBlocks" :value=qb.block :key="index">-->
                                <!--<label type="text">{{qb.block.name}}</label>-->
                                <!--< block-result :recommendations="checkRecommendation(qb.block.recommendations)"></block-result>-->
                            <!--</div>-->
                        <!--</div>-->

                        <h4 type="text">{{"Глобальная рекомендация"}}</h4>
                        <block-result v-if="currentAssessment.global_recommendations.length > 0" :recommendations="currentAssessment.global_recommendations"></block-result>
                        <div>
                            <v-btn @click="addRecommendation()">Добавить диапазон</v-btn>
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
    import { ADD_ASSESSMENT, CHANGE_ASSESSMENT } from "../store/actions.type"
    import QuestionBlock from '../components/QuestionBlock'
    import BlockResult from '../components/BlockResult'

    export default {
        name: "AssessmentWizard2",

        components:{
            QuestionBlock,
            BlockResult
        },
        computed: {
            ...mapGetters(["currentAssessment"])
        },
        data: () => ({
            step:1,
            industries: [],
            companyTypes: [],
            strategies: [],
            minBlockValue: 5,
            maxBlockValue: 25
        }),
        methods:{
            checkRecommendation(currentRecommendation){
                if (currentRecommendation){
                    return currentRecommendation
                } else {
                    return [];
                }
            },
            submit() {
                this.currentAssessment.status = 'Активная';
                if (this.currentAssessment.id){
                    this.$store.dispatch(CHANGE_ASSESSMENT, this.currentAssessment)
                        .then(() =>
                            this.$router.push({name: "expert-assessments"})
                        )
                        .catch(() => alert("Что-то пошло не так"))
                } else {
                    this.$store.dispatch(ADD_ASSESSMENT, this.currentAssessment)
                        .then(() =>
                            this.$router.push({name: "expert-assessments"})
                        )
                        .catch(() => alert("Что-то пошло не так"))
                }

            },
            addBlock(){
                this.currentAssessment.questionBlocks.push(
                    {
                        block: {
                            name:"",
                            questions:[],
                            recommendations:[]
                        }
                    }
                )
            },
            deleteBlock(index){
                if (this.currentAssessment.questionBlocks.length !== 1){
                    this.currentAssessment.questionBlocks.splice(index,1)
                }
            },
            calcMinValue(){
                return this.minBlockValue * this.currentAssessment.questionBlocks.length
            },
            calcMaxValue(){
                return this.maxBlockValue * this.currentAssessment.questionBlocks.length
            },
            addRecommendation(){
                let nextId = this.currentAssessment.global_recommendations.length + 1;
                this.currentAssessment.global_recommendations.push({minValue:'', maxValue:'',description:''})
            },
        },
        mounted() {
            this.industries = [
                { id: 1, name: 'Любая' },
                { id: 2, name: 'Добыча полезных ископаемых' },
                { id: 3, name: 'Обрабатывающие производства' },
                { id: 4, name: 'Обеспечение электрической энергией, газом и паром; кондиционирование воздуха' },
                { id: 5, name: 'Строительство' },
                { id: 6, name: 'Деятельность финансовая и страховая' },
                { id: 7, name: 'Образование' },
                { id: 8, name: 'Государственное управление и обеспечение военной безопасности; социальное обеспечение' },
                { id: 9, name: 'Предоставление прочих видов услуг' }
            ];
            this.companyTypes = [
                { id: 1, name: 'Коммерческая' },
                { id: 2, name: 'Некоммерческая' },
                { id: 3, name: 'Любая' }
            ];
            this.strategies = [
                {id: "1", name: "да/нет/не знаю"},
                {id: "2", name: "согласен/не согласен"}
            ];
        }
    }
</script>

<style scoped>

</style>
