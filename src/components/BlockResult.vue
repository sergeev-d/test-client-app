<template>
    <v-app>
    <!--<v-container>-->
        <div v-for="(r, index) in recommendations" :value="r.description" :key="index">
        <!--<div v-for="(r, index) in currentAssessment.questionBlocks[blockId].recommendations" :value="r.description" :key="index">-->
            <div>
                <v-text-field type="number" placeholder="нижняя граница" v-model="r.minValue"/>
                <v-text-field type="number" placeholder="верхняя граница" v-model="r.maxValue"/>
                <v-textarea placeholder="рекомендация" v-model="r.description" style="width: auto"/>
            </div>
            <div>
                <v-btn flat @click="deleteRecommendation(index)">Удалить диапазон</v-btn>
            </div>
        </div>
        <v-btn @click="addRecommendation()">Добавить диапазон</v-btn>
    <!--</v-container>-->
    </v-app>
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
