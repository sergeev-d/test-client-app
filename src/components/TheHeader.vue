<template>
    <header>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav">
                        <router-link tag="li" class="nav-item" exact to="/" active-class="active">
                            <a class="nav-link">О проекте</a>
                        </router-link>
                        <router-link tag="li" class="nav-item" to="/assessments" active-class="active">
                            <a class="nav-link">Оценки</a>
                        </router-link>
                        <router-link tag="li" class="nav-item" to="/login" active-class="active">
                            <a class="nav-link">Регистрация</a>
                        </router-link>
                    </ul>
                </div>
            </nav>
            <router-view></router-view>
        </div>
    </header>
</template>
<script>
    export default {

    }
</script>
<style>
</style>
