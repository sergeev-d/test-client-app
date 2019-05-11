<template>
    <div>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <router-link class="navbar-brand" :to="{ name: 'home' }">
                    Оценка Эффективности
                </router-link>
                <div class="collapse navbar-collapse">
                    <ul v-if="!isAuthenticated" class="navbar-nav">
                        <hr/>
                        <router-link tag="li" class="nav-item" to="/signin" active-class="active">
                            <a class="nav-link">Вход</a>
                        </router-link>
                        <router-link tag="li" class="nav-item" to="/signup" active-class="active">
                            <a class="nav-link">Регистрация</a>
                        </router-link>
                    </ul>
                    <ul v-else class="navbar-nav">
                        <hr/>
                        <button @click="logout" class="btn btn-success">
                            Выход
                        </button>
                        <div>
                            <i>{{ currentUser.name}}</i>
                            <p v-if=isCustomer(currentUser.type)>{{ "Клиент" }}</p>
                            <span v-else>{{ "Эксперт" }}</span>
                            <span>{{ currentUser.email}}</span>
                        </div>
                    </ul>
                </div>
            </nav>
        </div>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse">
                    <ul v-if="!isAuthenticated" class="navbar-nav">
                        <router-link tag="li" class="nav-item" to="/assessments" active-class="active">
                            <a class="nav-link">Оценки</a>
                        </router-link>
                    </ul>
                    <ul v-else class="navbar-nav">
                        <router-link tag="li" class="nav-item" to="/assessments" active-class="active">
                            <a class="nav-link">Оценки</a>
                        </router-link>
                        <router-link tag="li" class="nav-item" to="/profile" active-class="active">
                            <a class="nav-link">Профиль</a>
                        </router-link>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</template>
<script>
    import { LOGOUT } from "../store/actions.type"
    import { mapGetters } from "vuex"
    export default {
        name: "AppHeader",
        computed: {
            ...mapGetters(["isAuthenticated", "currentUser"])
        },
        methods: {
            logout(){
                this.$store.dispatch(LOGOUT,{})
                    .then(() => this.$router.push({ name: "home" }))
            },
            isCustomer(type) {
                return type === 'CUSTOMER'

            }
        }
    }
</script>
<style scoped>
    li {
       padding: 10px 15px;
    }
</style>
