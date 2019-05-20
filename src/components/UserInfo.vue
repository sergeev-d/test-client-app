<template>
    <div class="col-md-10 main">
        <v-app>
            <v-container>
            <v-text-field label="Имя" v-model="userProfile.firstName" :readonly=true required></v-text-field>
            <v-text-field label="Фамилия" v-model="userProfile.secondName" :readonly=true required></v-text-field>
            <v-text-field label="Отчество" v-model="userProfile.middleName" :readonly=true></v-text-field>
            <v-text-field label="Название организации" v-model="userProfile.organizationName" :readonly=true required></v-text-field>
            <v-text-field label="Должность" v-model="userProfile.name" required></v-text-field>
            <v-text-field label="E-mail" v-model="userProfile.email" required :readonly=true></v-text-field>
            <v-text-field label="Телефон" v-model="userProfile.phoneNumber" required :readonly=true></v-text-field>
            </v-container>
        </v-app>
    </div>
</template>

<script>
    import { mapGetters } from "vuex"
    import { FETCH_USER_PROFILE} from "../store/actions.type";

    export default {
        name: "UserInfo.vue",
        computed:{
            ...mapGetters(["userProfile"])
        },
        mounted() {
            this.$store.dispatch(FETCH_USER_PROFILE);
        }
    }
</script>

<style scoped>
    .main {
        box-shadow: 0 0 20px #E4E4E4;
        margin-top: 24px;
        padding-top: 24px;
    }
    .main span {
        font-weight: bold;
    }
    v-input  {
        font-size: 14px;
    }
</style>
