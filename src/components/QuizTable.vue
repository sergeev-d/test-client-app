<template>
    <div>
            <!--<v-app>-->
            <!--<tr>-->
                <!--<th/>-->
                <!--<th>Полностью несогласен</th>-->
                <!--<th>Несогласен</th>-->
                <!--<th>Нейтрально</th>-->
                <!--<th>Согласен</th>-->
                <!--<th>Полностью согласен</th>-->
            <!--</tr>-->
            <!--<tr v-for="(q, index) in questions"-->
                <!--:key="q.id"-->
                <!--:name="`${blockId}-${index}`">-->
                <!--<td>{{ q.value }}</td>-->
                <!--<td v-for="choiceValue in choiceCnt" v-model="responses[blockId][index]">-->
                    <!--<input type="radio"-->
                           <!--:name="`${blockId}-${index}`"-->
                           <!--:id="`${blockId}-${index}`"-->
                           <!--:key="`${blockId}-${index}`"-->
                    <!--/>-->
                    <!--&lt;!&ndash;:checked=false&ndash;&gt;-->
                    <!--&lt;!&ndash;@input="setValue(blockId, index, choiceValue)"&ndash;&gt;-->

                <!--</td>-->
            <!--</tr>-->
                <div v-for="(q, index) in questions" :key="q.id">
                    <v-input :value="q.value"
                             :readonly=true
                    >
                        {{q.value}}
                    </v-input>
                    <v-radio-group
                        row
                        :name="`${blockId}-${q.id}`"
                        v-model="responses[blockId][index]"
                    >
                        <v-radio v-for="choiceValue in choiceCnt"
                                 :key="choiceValue.point"
                                 :value="choiceValue.point"
                                 :label="choiceValue.value"
                        ></v-radio>
                        <!--* 25/(questions.length*5)-->
                    </v-radio-group>
                </div>

            <!--</v-app>-->
    </div>
</template>

<script>
    export default {
        name: "QuizTable.vue",
        props: {
            blockId: {
                type: Number,
                default(){
                    return 0
                }
            },
            questions: {
                type: Array,
                default(){
                    return []
                }
            },
            responses: {
                type: Array
            }

        },
        data () {
            return {
                choiceCnt : [
                    {"point":1, value:"Полностью несогласен"},
                    {"point":2, value:"Несогласен"},
                    {"point":3, value:"Нейтрально"},
                    {"point":4, value:"Согласен"},
                    {"point":5, value:"Полностью согласен"}
                ]
                // choiceCnt: 5
            }
        }
    }
</script>

<style scoped>

</style>
