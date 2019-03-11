<template>
  <div id="app">
      <app-header></app-header>
      <router-view></router-view>
      <app-footer></app-footer>
  </div>
</template>
<script>
  import AppHeader from "@/components/TheHeader";
  import AppFooter from "@/components/TheFooter";

  export default {
    components: {
        AppHeader: AppHeader,
        AppFooter: AppFooter

    }
  }
</script>
<style>
</style>
