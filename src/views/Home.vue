<template>
    <div class="home-container">
        <topic-image
                :topicName=topicName
        ></topic-image>
        <main-home></main-home>
    </div>
</template>
<script>
    import TopicImage from "@/components/TopicImage"
    import MainHome from "@/components/MainHome"
    export default {
        data () {
            return {
                topicName: 'О проекте'
            }
        },
        components: {
            TopicImage,
            MainHome
        }
    };
</script>
<style scoped>

</style>
