<template>
    <div>
        <div>
            <nav сlass="topnav">
                <div class="wrapper">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="logo-container">
                                <router-link class="logo-name" :to="{ name: 'home' }">
                                    <span><span>оценка</span> эффективности бизнеса.ru</span>
                                </router-link>
                            </div>
                        </div>
                        <nav class="col-md-7">
                            <div class="topnav-item">
                                <div v-if="!isAuthenticated" class="navbar-nav">
                                    <router-link tag="div" class="nav-item" to="/signin" active-class="active">
                                        <a class="nav-link">Вход</a>
                                    </router-link>
                                    <router-link tag="div" class="nav-item" to="/signup" active-class="active">
                                        <a class="nav-link">Регистрация</a>
                                    </router-link>
                                </div>
                                <div v-else class="navbar-nav">
                                    <router-link
                                            tag="div"
                                            class="nav-item"
                                            active-class="active"
                                            :to="{ name: 'home'}"
                                            exact>
                                        <button @click="logout()" class="btn-simple">
                                            Выход <i class="fas fa-sign-out-alt"></i>
                                        </button>
                                    </router-link>
                                    <div v-if="currentUser.username && isCustomer(currentUser.type)">
                                        <router-link
                                                tag="div"
                                                class="nav-item"
                                                active-class="active"
                                                :to="{ name: 'client-results'}"

                                        >
                                            <a class="nav-link">{{ currentUser.username }}</a>
                                        </router-link>
                                    </div>
                                    <div v-else-if="currentUser.username && isExpert(currentUser.type)">
                                        <router-link
                                                tag="div"
                                                class="nav-item"
                                                active-class="active"
                                                exact
                                                :to="{ name: 'expert-assessments'}"
                                        >

                                            <a class="nav-link">{{ currentUser.username }}</a>
                                        </router-link>
                                    </div>
                                </div>
                            </div>

                        </nav> <!-- col-md-7 -->
                    </div> <!-- row -->
                </div> <!-- wrapper -->
            </nav>

        </div>
    </div>
</template>
<script>
    import { LOGOUT } from "../store/actions.type"
    import { mapGetters } from "vuex"
    import { profileType } from "../mixins/utils.js"


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
        },
        mixins:[profileType]
    }
</script>
<style>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
