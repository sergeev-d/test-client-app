<template>
    <div class="account-container">
        <div class="row">
            <account-menu></account-menu>
            <account-main></account-main>
        </div>
    </div>
</template>
<script>
    import AccountMenu from "@/components/AccountMenu.vue"
    import AccountMain from "@/components/AccountMain"

    export default {
        components: {
            AccountMenu,
            AccountMain
        }
    }
</script>

