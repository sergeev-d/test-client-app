<template>
    <v-app class="col-md-9 sidebar">
        <div>
            <!--<v-stepper v-model="el">-->
                <!--<v-stepper-header>-->
                    <!--<template>-->
                        <!--<v-text-field label="Описание:" :value="currentAssessment.description" :readonly=true required></v-text-field>-->
                    <!--</template>-->
                <!--</v-stepper-header>-->

                <!--<v-stepper-items>-->
                    <!--<v-stepper-content vertical :step="step">-->
                        <!--<div>-->
                            <!--<v-text-field label="Блок" :value="getBlock(step).name" :readonly=true required></v-text-field>-->
                        <!--</div>-->
                        <!--<form action="">-->
                            <!--<quiz-table :questions="getBlock(step).questions" :blockId="step" :responses="userResponses"></quiz-table>-->
                        <!--</form>-->
                    <!--</v-stepper-content>-->
                <!--</v-stepper-items>-->
            <!--</v-stepper>-->
            <!--<v-layout v-if="step === 1">-->
                <!--<v-btn color="primary" flat @click="next()">Next</v-btn>-->
            <!--</v-layout>-->
            <!--<v-layout v-else-if="step > 1 & step < getSteps()">-->
                <!--<v-btn color="primary" flat @click="next()">Next</v-btn>-->
                <!--<v-btn color="primary" flat @click="prev()">Prev</v-btn>-->
            <!--</v-layout>-->
            <!--<v-layout v-else>-->
                <!--<v-btn color="primary" flat @click="prev()">Prev</v-btn>-->
                <!--<v-btn color="primary" @click="finish()">Finish</v-btn>-->
            <!--</v-layout>-->


            <div v-for="(item, index) in currentAssessment.questionBlocks" :key="index">
                <div v-show="index === 1">
                    <quiz-table :questions="getBlock(step).questions" :blockId="step" :responses="userResponses"></quiz-table>
                </div>
            </div>
            <v-layout v-if="step === 1">
            <v-btn color="primary" flat @click="next()">Next</v-btn>
            </v-layout>
            <v-layout v-else-if="step > 1 & step < getSteps()">
            <v-btn color="primary" flat @click="next()">Next</v-btn>
            <v-btn color="primary" flat @click="prev()">Prev</v-btn>
            </v-layout>
            <v-layout v-else>
            <v-btn color="primary" flat @click="prev()">Prev</v-btn>
            <v-btn color="primary" @click="finish()">Finish</v-btn>
            </v-layout>
        </div>
    </v-app>
</template>

<script>
    import { mapGetters } from "vuex"
    import QuizTable from "@/components/QuizTable"
    export default {
        name: "AssessmentProcessor2",
        data () {
            return {
                el: 1,
                step: 1,
                userResponses: [[],[]]
            }
        },
        components:{
            QuizTable
        },
        computed: {
            ...mapGetters(["currentAssessment"])
        },
        methods: {
            getSteps(){
                return this.currentAssessment.questionBlocks.length
            },
            next() {
                this.step++;

            },
            prev() {
                this.step--;
            },
            finish() {
                this.$router.push( { name:"client-assessments" });
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
