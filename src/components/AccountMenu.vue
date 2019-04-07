<template>
    <div class="col-md-3" style="border: 1px black solid;height:1200px">
        <ul>
            <router-link tag="li" to="/user-account/profile" active-class="active">
                <a>Профиль</a>
            </router-link>
            <router-link tag="li" to="/user-account/results" active-class="active">
                <a>Результаты</a>
            </router-link>
            <router-link tag="li" to="/user-account/" active-class="active">
                <a>Dashboard</a>
            </router-link>
        </ul>
    </div>
</template>
<script>
    export default {
        name : "AccountMenu"
    }
</script>
<style scoped>
</style>
