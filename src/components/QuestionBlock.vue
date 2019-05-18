<template>
    <div>
        <div v-for="(q, index) in questions" :value="q.description" :key="index">
            <div>
                <v-textarea label="Вопрос/Утверждение" v-model="q.value" required></v-textarea>
            </div>
            <div>
                <button @click="deleteQuestionArea(index)">Удалить вопрос</button>
            </div>
        </div>
        <button @click="addQuestionArea()">Добавить вопрос</button>
    </div>
</template>

<script>
    export default {
        name: "QuestionBlock",
        props: {
            questions: {
                required: true,
                type: Array,
                default: []
            }
        },
        methods: {
            addQuestionArea(){
                let nextId = this.$props.questions.length + 1;
                this.$props.questions.push({id : nextId, value:""})
            },
            deleteQuestionArea(index){
                this.$props.questions.splice(index, 1)
            }
        }
    }
</script>

<style scoped>

</style>
