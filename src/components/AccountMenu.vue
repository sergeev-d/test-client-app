<template>
    <div class="col-md-3" style="border: 1px black solid;height:1200px">
        <ul v-if="currentUser.type === this.accountType">
            <li>
                <router-link
                        active-class="active"
                        :to="{ name:'dashboard' }"
                        exact
                >
                    <a>Dashboard</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'client-info' }"
                >
                    <a>Профиль</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'results' }"
                >
                <a>Результаты</a>
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
                    <a>Профиль</a>
                </router-link>
            </li>
            <li>
                <router-link
                        active-class="active"
                        :to="{ name:'results'}"
                        exact >
                    <a>Оценки</a>
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
</style>
