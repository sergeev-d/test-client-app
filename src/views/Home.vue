<template>
    <div class="logo-page">
        <img class="logo-img" :src="imageLogo" alt="Image">
    </div>

</template>
<script>
    export default {
        data () {
            return {
                imageLogo: '@/assets/about_project.png'
            }
        }
    };
</script>
<style scoped>
    /*.logo-img {*/
        /*position: absolute;*/
        /*left: 0px;*/
        /*top: 0px;*/
        /*width: 1315px;*/
        /*height: 221px;*/
    /*}*/
    .logo-page {
        flex-basis: auto;
        height: 600px;
        background: aliceblue;
        font-family: 'Arial Обычный', 'Arial';
        font-weight: 400;
        font-style: normal;
        font-size: 13px;
        color: #333333;
        text-align: center;
        line-height: normal;

    }

</style>
