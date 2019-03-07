<template>
    <div class="topic-container">
        <img :src=this.imgSrc>
        <h3 align="center">{{ this.topicName }}</h3>
    </div>
</template>
<script>
export default {
        name: "TopicImage",
        props: {
            imgSrc: {
                type: String,
                required: true
            },
            topicName: {
                type: String,
                required: true
            }
        }
}
</script>
<style scoped>
    .topic-container {
        width: 1078px;
        height: 90px;
        padding: 8px;
        background: aqua;

    }
</style>
