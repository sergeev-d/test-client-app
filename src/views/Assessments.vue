<template>
    <topic-image
            :imgSrc=this.imageLogo
            :topicName=this.topicName
    ></topic-image>
</template>
<script>
    import TopicImage from "@/components/TopicImage"
    export default {
        data () {
            return {
                imageLogo: '@./assets/about_project.png',
                topicName: 'Оценки'
            }
        },
        components: {
            TopicImage
        }
    };
</script>
<style scoped>

</style>
