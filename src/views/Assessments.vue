<template>
    <div class="assessments-container">
        <assessment-list :itemsPerPage="5"/>
    </div>
</template>
<script>
    import AssessmentList from "@/components/AssessmentList"
    export default {
        data () {
            return {
                topicName: 'Оценки'
            }
        },
        components: {
            AssessmentList
        }
    };
</script>
<style scoped>
</style>
