<template>
    <div class="topic-container">
        <img src="../assets/about_project.png">
        <!--<h3>{{ this.topicName }}</h3>-->
    </div>
</template>
<script>
export default {
        name: "TopicImage",
        props: {
            topicName: {
                type: String,
                required: true
            }
        }
}
</script>
<style scoped>
    .topic-container {
        width: auto;
        height: 250px;
        border: 1px black solid;
        background-color: cornflowerblue;
    }
</style>
