<template>
    <div class="assessment-preview-container">
        <div class="preview-container">
            <h4>{{ this.assessment.name }}</h4>
            <p>{{ this.assessment.description }}</p>
            <ul>
                <li v-for="applicationField of this.assessment.applicationFields">{{ applicationField }}</li>
            </ul>
        </div>
        <div class="btn-container">
            <button class="btn-test-assessment" @click="goToAssessment">Перейти к оценке</button>
            <button class="btn-template-assessment" @click="">Пример отчета</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AssessmentPreview",
        props : {
            assessment: { type: Object, required: true }
        },
        methods: {
            goToAssessment(){
                this.$router.push({name:'assessment', params: {id: this.assessment.id}})

            }
        }
    }
</script>

<style scoped>
    .assessment-preview-container {
        width: 600px;
        height: auto;
        border: 1px black solid;
        background: antiquewhite;
    }
</style>
