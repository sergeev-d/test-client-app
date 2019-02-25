<template>
    <div class="container">
        <h1>Car {{ id }}</h1>
    </div>
</template>
<script>
export default {
    data () {
        return {
            id: this.$router.currentRoute.params['id']
        }
    },
    watch: { // механим отслеживает изменение объектов
        $route (toR, fromR) {
            this.id = toR.params['id']
        }
    }
}
</script>
<style scoped>

</style>
