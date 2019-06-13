<template>
    <v-app class="col-md-9 sidebar">
        <div>
            <div v-for="(item, index) in currentAssessment.questionBlocks" :key="index">
                <div v-if=" step === index">
                    <v-text-field label="Блок" :value="item.block.name" :readonly=true required></v-text-field>
                    <quiz-table :questions="item.block.questions"
                                :blockId="step"
                                :responses="responses"
                    >
                    </quiz-table>
                </div>
            </div>
            <v-layout v-if="step === 0">
                <v-btn color="primary" flat @click="next()">Далее</v-btn>
            </v-layout>
            <v-layout v-else-if="step > 0 & step < getSteps()">
                <v-btn color="primary" flat @click="prev()">Назад</v-btn>
                <v-btn color="primary" flat @click="next()">Далее</v-btn>
            </v-layout>
            <v-layout v-else>
                <v-btn color="primary" flat @click="prev()">Назад</v-btn>
                <v-btn color="primary" @click="finish()">Закончить</v-btn>
            </v-layout>
        </div>
    </v-app>
</template>

<script>
    import { mapGetters } from "vuex"
    import QuizTable from "@/components/QuizTable"
    import { SAVE_USER_ASSESSMENT_RESULT} from "../store/actions.type";

    export default {
        name: "AssessmentProcessor2",
        data () {
            return {
                el: 1,
                step: 0,
                responses : []
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
                return this.currentAssessment.questionBlocks.length - 1;
            },
            next() {
                this.step++;

            },
            prev() {
                this.step--;
            },
            finish() {
                let blockValue = 25; // should be accessible from assessment, by default 25
                let choiceStrategy = 5; // strategy from settings or assessment , by default 5 choices
                let labels = [];
                let resultBlockData = [];
                let questionsLength = 0;
                let recommendation = '';
                for (let item in this.currentAssessment.questionBlocks) {
                    questionsLength = this.currentAssessment.questionBlocks[item].block.questions.length;
                    labels.push(this.currentAssessment.questionBlocks[item].block.name);
                    // sumData.push(this.responses[item].reduce(reducer,0))
                    resultBlockData.push(this.responses[item].reduce((accumulator, currentValue) => {
                        return accumulator + currentValue * blockValue/(questionsLength*choiceStrategy)
                    },0))
                }
                for (let rec in this.currentAssessment.global_recommendations){
                    let sumAssessment = resultBlockData.reduce((accumulator, currentValue) => {
                        return accumulator + currentValue
                    },0);
                    let currRec = this.currentAssessment.global_recommendations[rec];
                    if (sumAssessment > currRec.minValue && sumAssessment <= currRec.maxValue) {
                        recommendation = currRec.description;
                    }
                }

                let assessmentResult = {
                    "assessmentName": this.currentAssessment.name,
                    "blocks" : labels,
                    "resultBlockData": resultBlockData,
                    "recommendation": recommendation,
                    "createDate": "",

                };
                this.$store.dispatch(SAVE_USER_ASSESSMENT_RESULT, assessmentResult)
                    .then(() => {
                        this.$router.push( { name:"client-assessments" });
                    })
                    .catch(() => {
                        alert("Что-то пошло не так...")
                    })

            },
            createEmptyQuiz(){
                let empty = [];
                let i = 0;
                let j = 0;
                let nested = [];
                let currentBlocks = this.currentAssessment.questionBlocks;
                for (i in currentBlocks) {
                    let currentBlock = this.currentAssessment.questionBlocks[i].block;
                    for (j in currentBlock.questions){
                        nested.push(3)
                    }
                    empty.push(nested);
                    nested = [];
                    j=0;
                }
                return empty;
            }
        },
        // ,
        mounted() {
            if (!this.currentAssessment.name) {
                this.$router.push( { name:"client-assessments" } )
            }
        },
        created() {
            this.responses = this.createEmptyQuiz()
        }
    }
</script>

<style scoped>

</style>
