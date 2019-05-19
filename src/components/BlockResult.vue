<template>
    <v-container>
        <div v-for="(r, index) in recommendations" :value="r.description" :key="index">
        <!--<div v-for="(r, index) in currentAssessment.questionBlocks[blockId].recommendations" :value="r.description" :key="index">-->
            <div>
                <input placeholder="нижняя граница" v-model="r.minValue"/>
                <input placeholder="верхняя граница" v-model="r.maxValue"/>
                <input placeholder="рекомендация" v-model="r.description"/>
            </div>
            <div>
                <button @click="deleteRecommendation(index)">Удалить диапазон</button>
            </div>
        </div>
        <button @click="addRecommendation()">Добавить диапазон</button>
    </v-container>
</template>

<script>
    import { mapGetters } from "vuex"

    export default {
        name: "BlockResult.vue",
        props: {
            recommendations:{
                required: true,
                type: Array,
                default: []
            }
        },
        methods: {
            addRecommendation(){
                let nextId = this.$props.recommendations.length + 1;
                this.$props.recommendations.push({minValue:'', maxValue:'',description:''})
            },
            deleteRecommendation(index){
                this.$props.recommendations.splice(index, 1)
            }
        },
        computed: {
            ...mapGetters(["currentAssessment"])
        },
    }
</script>

<style scoped>

</style>
