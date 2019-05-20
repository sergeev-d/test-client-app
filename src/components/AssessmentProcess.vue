<template>
    <v-app class="col-md-9 sidebar">
        <div>
            <v-stepper v-model="e1">
                <!--<v-stepper-header>-->
                    <!--<template v-for="n in currentAssessment.questionBlocks">-->
                        <!--<v-stepper-step-->
                                <!--:key="`${n}-step`"-->
                                <!--:complete="e1 > n"-->
                                <!--:step="n"-->
                                <!--editable-->
                        <!--&gt;-->
                            <!--{{currentAssessment.questionBlocks}}-->
                        <!--</v-stepper-step>-->

                        <!--<v-divider-->
                                <!--v-if="n !== currentAssessment.questionBlocks"-->
                                <!--:key="n"-->
                        <!--&gt;</v-divider>-->
                    <!--</template>-->
                <!--</v-stepper-header>-->

                <!--<v-stepper-items>-->
                    <!--<v-stepper-content-->
                            <!--v-for="n in currentAssessment.questionBlocks"-->
                            <!--:key="`${n}-content`"-->
                            <!--:step="n"-->
                    <!--&gt;-->
                        <!--<v-card-->
                                <!--class="mb-5"-->
                                <!--color="grey lighten-1"-->
                                <!--height="200px"-->
                        <!--&gt;</v-card>-->

                        <!--<v-btn-->
                                <!--color="primary"-->
                                <!--@click="nextStep(n)"-->
                        <!--&gt;-->
                            <!--Continue-->
                        <!--</v-btn>-->

                        <!--<v-btn flat>Cancel</v-btn>-->
                    <!--</v-stepper-content>-->
                <!--</v-stepper-items>-->
            </v-stepper>
        </div>
    </v-app>
</template>

<script>
    import { mapGetters } from "vuex"
    export default {
        name: "AssessmentProcess.vue",
        data () {
            return {
                e1: 1
            }
        },
        computed: {
            ...mapGetters(["currentAssessment"])
        },
        nextStep (n) {
            if (n === this.steps) {
                this.e1 = 1
            } else {
                this.e1 = n + 1
            }
        },
    }
</script>

<style scoped>

</style>
