<template>
    <div class="account-container">
        <div class="row">
            <account-user-info></account-user-info>
            <account-page-info></account-page-info>
        </div>
        <div class="row">
            <account-menu></account-menu>
            <account-main></account-main>
        </div>
    </div>
</template>
<script>
    import AccountUserInfo from "@/components/AccountUserInfo"
    import AccountPageInfo from "@/components/AccountPageInfo.vue"
    import AccountMenu from "@/components/AccountMenu.vue"
    import AccountMain from "@/components/AccountMain"

    export default {
        components: {
            AccountUserInfo,
            AccountPageInfo,
            AccountMenu,
            AccountMain
        }
    }
</script>

