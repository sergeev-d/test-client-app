<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse">
            <router-link class="navbar-brand" :to="{ name: 'home' }">
                Оценка Эффективности
            </router-link>
            <ul v-if="!isAuthenticated" class="navbar-nav">
                <router-link tag="li" class="nav-item" exact to="/" active-class="active">
                    <a class="nav-link">О проекте</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/assessments" active-class="active">
                    <a class="nav-link">Оценки</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/contacts" active-class="active">
                    <a class="nav-link">Контакты</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/signin" active-class="active">
                    <a class="nav-link">Вход</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/signup" active-class="active">
                    <a class="nav-link">Регистрация</a>
                </router-link>
            </ul>
            <ul v-else class="navbar-nav">
                <router-link tag="li" class="nav-item" exact to="/" active-class="active">
                    <a class="nav-link">О проекте</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/assessments" active-class="active">
                    <a class="nav-link">Оценки</a>
                </router-link>
                <router-link tag="li" class="nav-item" to="/contacts" active-class="active">
                    <a class="nav-link">Контакты</a>
                </router-link>
            </ul>
        </div>
    </nav>
</template>
<script>
    export default {
        name: "AppHeader",
        props : {
            isAuthenticated : false
        }
    }
</script>
<style scoped>
    li {
       padding: 10px 15px;
    }
</style>
