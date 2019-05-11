<template>
    <div class="col-md-9" style="border: 1px black solid;height:1200px">
        <p>{{ getRouter}}</p>
    </div>
</template>
<script>
    export default {
        name : "AccountMain",
        computed: {
            getRouter(){
                return this.$router.currentRoute.name;
            }
        }
    }
</script>
<style scoped>

</style>
