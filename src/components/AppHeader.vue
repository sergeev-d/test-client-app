<template>
    <div>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <router-link class="navbar-brand" :to="{ name: 'home' }">
                    Оценка Эффективности
                </router-link>
                <ul v-if="!isAuthenticated" class="navbar-nav">
                    <li>
                        <router-link tag="li"
                                     class="nav-item"
                                     :to="{ name: 'signup' }"
                                     active-class="active"
                        >
                            <a class="nav-link">Регистрация</a>
                        </router-link>
                    </li>
                    <li>
                        <router-link
                                     class="nav-item"
                                     :to="{ name: 'signin' }"
                                     active-class="active"
                        >
                            <a class="nav-link">Вход</a>
                        </router-link>
                    </li>

                </ul>
                <ul v-else class="navbar-nav">
                    <li>
                        <router-link
                                class="nav-item"
                                active-class="active"
                                :to="{ name: 'home'}"
                                exact>
                            <button @click="logout()" class="btn btn-success">
                                Выход
                            </button>
                        </router-link>
                    </li>
                    <li v-if="currentUser.name && currentUser.type === 'CUSTOMER'">
                        <router-link
                                     class="nav-item"
                                     active-class="active"
                                     :to="{ name: 'dashboard'}"

                        >

                            <a class="nav-link">{{ currentUser.name }}</a>
                        </router-link>
                    </li>
                    <li v-else-if="currentUser.name && currentUser.type === 'EXPERT'">
                        <router-link
                                class="nav-item"
                                active-class="active"
                                exact
                                :to="{ name: 'expert-profile'}"
                        >

                            <a class="nav-link">{{ currentUser.name }}</a>
                        </router-link>
                    </li>
                </ul>
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
            logout() {
                this.$store.dispatch(LOGOUT)
                    .then(() => this.$router.push({name: "home"}))
            }
        }
    }
</script>
<style>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
