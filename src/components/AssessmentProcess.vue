<template>
    <v-app class="col-md-9 sidebar">
        <div>
            <v-stepper v-model="el">
                <v-stepper-header>

                    <!--<template v-for="n in getSteps()">-->
                        <!--<v-stepper-step-->
                                        <!--:key="n"-->
                                        <!--:complete="step >= n"-->
                                        <!--:step="n"-->
                                        <!--editable-->
                        <!--&gt;-->
                            <!--{{ "Шаг " + n  }}-->
                        <!--</v-stepper-step>-->

                        <!--<v-divider-->
                                <!--v-if="n !== getSteps()"-->
                        <!--&gt;</v-divider>-->

                    <!--</template>-->
                    <template>
                        <v-text-field :value="currentAssessment.description" :readonly=true required></v-text-field>
                    </template>
                </v-stepper-header>

                <v-stepper-items>
                    <v-stepper-content vertical :step="step">
                        <div>
                            <v-text-field label="Блок" :value="getBlock(step).name" :readonly=true required></v-text-field>
                        </div>
                        <!--<form action="">-->
                            <quiz-table :questions="getBlock(step).questions" :blockId="step" :responses="userResponses"></quiz-table>
                        <!--</form>-->
                    </v-stepper-content>

                </v-stepper-items>
                <v-layout v-if="step === 1">
                    <v-btn color="primary" flat @click="next()">Продолжить</v-btn>
                </v-layout>
                <v-layout v-else-if="step > 1 & step < getSteps()">
                    <v-btn color="primary" flat @click="next()">Продолжить</v-btn>
                    <v-btn color="primary" flat @click="prev()">Вернуться</v-btn>
                </v-layout>
                <v-layout v-else>
                    <v-btn color="primary" flat @click="prev()">Вернуться</v-btn>
                    <v-btn color="primary" @click="finish()">Закончить</v-btn>
                </v-layout>
            </v-stepper>

        </div>
    </v-app>
</template>

<script>
    import { mapGetters } from "vuex"
    import QuizTable from "@/components/QuizTable"
    export default {
        name: "AssessmentProcess.vue",
        data () {
            return {
                el: 1,
                step: 1,
                userResponses: []
            }
        },
        components:{
            QuizTable
        },
        computed: {
            ...mapGetters(["currentAssessment"]),

        },
        methods: {
            getSteps(){
                return this.currentAssessment.questionBlocks.length
            },
            next () {
                this.step++;

            },
            prev () {
                this.step--
            },
            finish () {
                console.info(this.userResponses);


                this.$router.push( { name:"client-assessments" })
            },
            getBlock(id){
                if (id >= 1){
                    let arrId = id - 1;
                    return this.currentAssessment.questionBlocks[arrId].block
                } else if (id === 0){
                    return this.currentAssessment.questionBlocks[id].block.name
                } else {
                    alert("incorrect index")
                }
            },
            createEmptyQuiz(){
                let empty = [];
                for (let i in this.currentAssessment.questionBlocks){
                    console.info(i)
                    // for (let j in this.currentAssessment.questionBlocks[i].block.questions.length){
                    //     empty[i-1][j-1] = 0
                    // }
                }

                return empty;
            }
        },
        // ,
        mounted() {
            if (!this.currentAssessment.name) {
                this.$router.push( { name:"client-assessments" } )
            }
        }
    }
</script>

<style scoped>

</style>
