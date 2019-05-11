<template>
    <div class="home-container">
        <main-home></main-home>
    </div>
</template>
<script>
    import MainHome from "@/components/MainHome"

    export default {
        data () {
            return {
                topicName: 'Проект'
            }
        },
        components: {
            MainHome
        }
    };
</script>
<style scoped>

</style>
