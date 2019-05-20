<template>
    <div class="col-md-2 sidebar">
        <ul v-if="isCustomer(currentUser.type)">
            <li>
                <router-link
                        :to="{ name:'client-info' }"
                >
                    <a><i class="fas fa-user-edit"></i> Профиль</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'client-results' }"
                >
                    <a><i class="fas fa-flag-checkered"></i> Результаты</a>
                </router-link>
            </li>
            <li>
                <router-link
                        :to="{ name:'client-assessments' }"
                >
                    <a><i class="fas fa-flag-checkered"></i> Оценки</a>
                </router-link>
            </li>
        </ul>
        <ul v-else>
            <!--<li>-->
                <!--<router-link-->
                        <!--:to="{ name:'expert-main' }"-->
                <!--&gt;-->
                    <!--<a>Главная</a>-->
                <!--</router-link>-->
            <!--</li>-->
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
        mixins:[profileType]
    }
</script>
<style scoped>
    @import '../../public/style.css';
    @import '../../public/media.css';
    @import '../../public/fonts.css';

    .sidebar {
        box-shadow: 0 0 20px #E4E4E4;
        margin-top: 24px;
        padding-top: 24px;
    }

    li {
        list-style: none;
    }

    a {
        display: block;
        color: #999999;
        font-size: 14px;
        margin-bottom: 10px;
    }
</style>
