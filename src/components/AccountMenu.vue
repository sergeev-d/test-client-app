<template>
    <div class="col-md-3 sidebar">
        <ul v-if="isCustomer(currentUser.type)">
            <!--            <li>-->
            <!--                <router-link-->
            <!--                        active-class="active"-->
            <!--                        :to="{ name:'client-main' }"-->
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
                        :to="{ name:'expert-main' }"
                >
                    <a>Главная</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'expert-info' }"
                >
                    <a><i class="fas fa-user-edit"></i> Профиль</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'expert-assessments'}"
                >
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
    import { profileType } from "../mixins/utils.js"

    export default {
        name : "AccountMenu",
        data() {
            return {
                children: []
            }
        },
        watch: {},
        computed: {
            ...mapGetters(["currentUser"]),
        },
        // methods:{
        //     isCustomer(profileType){
        //         return profileType.toLowerCase() === 'customer'
        //     }
        // }
        mixins:[profileType]
    }
</script>
<style scoped>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';
</style>
