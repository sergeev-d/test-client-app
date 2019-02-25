<template>
    <div class="container">
        <h1>Cars page</h1>

        <ul>

            <router-link
                    tag="li"
                    v-for="car in 5"
                    :to="'/car/' + car"
                    :key="car"
            >
                <a>Car {{ car }}</a>
            </router-link>

        </ul>
    </div>
</template>
<script>

</script>
<style scoped>

</style>
