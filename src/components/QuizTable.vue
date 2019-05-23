<template>
    <div>
            <tr>
                <th/>
                <th>Полностью несогласен</th>
                <th>Несогласен</th>
                <th>Нейтрально</th>
                <th>Согласен</th>
                <th>Полностью согласен</th>
            </tr>
            <tr v-for="(q, index) in questions"
                :key="q.id"
                :name="`${blockId}-${index}`">
                <td>{{ q.value }}</td>
                <td v-for="choiceValue in choiceCnt">
                    <input type="radio"
                           :checked=false
                           :name="`${blockId}-${index}`"
                           @input="setValue(blockId-1, index, choiceValue)"
                           :id="`${blockId}-${index}`"
                           :key="`${blockId}-${index}`"
                    />
                           <!--v-model="responses[blockId-1][index]"-->
                    <!--:name="`${blockId}-${index}`"-->

                </td>
            </tr>
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
            },
            realValue:{
                type: Number,
                default(){
                    return 1
                }
            },
            value:{
                type: Number,
                default(){
                    return 2
                }
            }

        },
        data () {
            return {
                choiceCnt : 5
            }
        },
        methods:{
            setValue(blockId, questionId, value){
                this.responses[blockId][questionId] = value
            }

        }

    }
</script>

<style scoped>

</style>
