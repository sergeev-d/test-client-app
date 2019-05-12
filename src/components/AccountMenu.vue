<template>
    <div class="col-md-3 sidebar">
        <ul v-if="currentUser.type === this.accountType">
            <!--            <li>-->
            <!--                <router-link-->
            <!--                        active-class="active"-->
            <!--                        :to="{ name:'dashboard' }"-->
            <!--                        exact-->
            <!--                >-->
            <!--                    <a>Dashboard</a>-->
            <!--                </router-link>-->
            <!--            </li>-->
            <li>
                <router-link
                        :to="{ name:'client-info' }"
                >
                    <a><i class="fas fa-user-edit"></i> Профиль</a>
                </router-link>
            </li>
            <!--            <li>-->
            <!--                <router-link-->
            <!--                        :to="{ name:'client-info' }"-->
            <!--                >-->
            <!--                    <a><i class="fas fa-book"></i> Оценки</a>-->
            <!--                </router-link>-->
            <!--            </li>-->
            <li>
                <router-link
                        :to="{ name:'results' }"
                >
                    <a><i class="fas fa-flag-checkered"></i> Результаты</a>
                </router-link>
            </li>
        </ul>
        <ul v-else>
            <li>
                <router-link
                        active-class="active"
                        :to="{ name:'dashboard' }"
                        exact >
                    <a>Dashboard</a>
                </router-link>
            </li>
            <li>
                <router-link
                        active-class="active"
                        :to="{ name:'client-info' }"
                        exact >
                    <a><i class="fas fa-user-edit"></i> Профиль</a>
                </router-link>
            </li>
            <li>
                <router-link
                        active-class="active"
                        :to="{ name:'results'}"
                        exact >
                    <a><i class="fas fa-book"></i> Оценки</a>
                </router-link>
            </li>
        </ul>

        <!--<ul>-->
        <!--<li v-for="item in children" :key="item.path">-->
        <!--<router-link :to="item.path">{{ item.name.split('.').pop() }}</router-link>-->
        <!--</li>-->
        <!--</ul>-->
    </div>
</template>
<script>
    import { mapGetters } from "vuex";

    export default {
        name : "AccountMenu",
        data() {
            return {
                children: [],
                accountType:"CUSTOMER"
            }
        },
        watch: {},
        computed: {
            ...mapGetters(["currentUser"]),
        }
    }
</script>
<style scoped>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
