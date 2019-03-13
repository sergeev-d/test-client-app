<template>
    <div class="assessments-container">
        <topic-image
                :topicName=this.topicName
        ></topic-image>
        <assessment-list :itemsPerPage="5"/>
    </div>
</template>
<script>
    import TopicImage from "@/components/TopicImage"
    import AssessmentList from "@/components/AssessmentList"
    export default {
        data () {
            return {
                topicName: 'Оценки'
            }
        },
        components: {
            TopicImage,
            AssessmentList
        }
    };
</script>
<style scoped>
</style>
