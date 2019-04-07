<template>
    <div class="col-md-3" style="border: 1px black solid;height:100px">
        <p>{{ currentUser.name}}</p>
        <p v-if=isCustomer(currentUser.type)>{{ "Клиент" }}</p>
        <p v-else>{{ "Эксперт" }}</p>
        <p>{{ currentUser.email}}</p>
    </div>
</template>
<script>
    import { mapGetters } from "vuex";
    export default {
        name : "AccountUserInfo",
        computed : {
            ...mapGetters(["currentUser"])
        },
        methods : {
            isCustomer(type) {
                return type === 'CUSTOMER'
            }
        }
    }
</script>
<style scoped>

</style>
