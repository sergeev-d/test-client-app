<template>
    <div class="wrapper">
        <div class="row">
            <account-menu></account-menu>
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
    import AccountMenu from "@/components/AccountMenu.vue"

    export default {
        components: {
            AccountMenu
        }
    }
</script>

