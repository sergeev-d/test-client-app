<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
        <v-expansion-panel>
            <v-expansion-panel-content
                    v-for="(r, index) in recommendations"
                    :value="r.description"
                    :key="index">
                <template v-slot:header>
                    <v-text-field
                            label="Рекомендация по диапазону"
                            required
                            readonly
                            style="font-weight: bold; border: none"
                    >
                    </v-text-field>
                </template>
                <div>
                    <v-text-field type="string" placeholder="нижняя граница" v-model="r.minValue"/>
                    <v-text-field type="string" placeholder="верхняя граница" v-model="r.maxValue"/>
                    <v-textarea placeholder="рекомендация" v-model="r.description" />
                    <!--style="width: auto"-->
                </div>
                <div>
                    <v-btn flat @click="deleteRecommendation(index)">Удалить диапазон</v-btn>
                </div>
            </v-expansion-panel-content>
            <!--<div class="wrapper">-->
                <!--<v-btn @click="addRecommendation()">Добавить диапазон</v-btn>-->
            <!--</div>-->
        </v-expansion-panel>
        <!--<div v-for="(r, index) in recommendations" :value="r.description" :key="r">-->
            <!--<div>-->
                <!--<v-text-field type="string" placeholder="нижняя граница" v-model="r.minValue"/>-->
                <!--<v-text-field type="string" placeholder="верхняя граница" v-model="r.maxValue"/>-->
                <!--<v-textarea placeholder="рекомендация" v-model="r.description" />-->
            <!--</div>-->
            <!--<div>-->
                <!--<v-btn flat @click="deleteRecommendation(index)">Удалить диапазон</v-btn>-->
            <!--</div>-->
        <!--</div>-->
        <!--<v-btn @click="addRecommendation()">Добавить диапазон</v-btn>-->
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
            deleteRecommendation(index){
                this.$props.recommendations.splice(index, 1)
            },
            addRecommendation(){
                let nextId = this.$props.recommendations.length + 1;
                this.$props.recommendations.push({minValue:'', maxValue:'',description:''})
            },
        },
        computed: {
            ...mapGetters(["currentAssessment"])
        },
    }
</script>

<style scoped>

</style>
