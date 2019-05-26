<template>
    <h4>{{ item.recommendation }}</h4>
</template>

<script>
    export default {
        name: "ResultWithRecommendation.vue",
        props:{
            item: {
                type: Object
            }
        }
    }
</script>

<style scoped>

</style>
