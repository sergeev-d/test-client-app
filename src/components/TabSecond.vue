<template>
    <div class="wrapper">
        <!--<form ref="form">-->
            <div>
                <label type="text"><span>Редактор блоков вопросов / утверждений</span></label>
            </div>
            <div>
                <label type="text">Варианты ответов для блоков</label>
                <select v-model="model.selectedStrategy">
                    <option v-for="strategy in strategies" :value="strategy.value" :key="strategy.id">
                        {{ strategy.value }}
                    </option>
                </select>
            </div>
            <div class="wrapper">
                <div v-for="(qb, index) in this.model.questionBlocks" :value=qb.block :key="index" style="border: 1px black solid">
                    <label type="text">Название блока</label>
                    <input v-model="qb.block.name"/>
                    <question-block :questions="qb.block.questions"></question-block>
                    <button @click="deleteBlock(index)">Удалить блок</button>
                </div>
            </div>
            <div class="wrapper">
                <button @click="addBlock()">Добавить блок</button>
            </div>
        <!--</form>-->
    </div>
</template>

<script>
    import QuestionBlock from "../components/QuestionBlock"

    export default {
        name: "TabSecond.vue",
        data () {
            return {
                strategies: [],
                model: {
                    selectedStrategy: '',
                    questionBlocks: []
                }
            }
        },
        mounted() {
            this.strategies = [
                {id:"1", value:"да/нет/не знаю"},
                {id:"2", value:"да/нет/не знаю2"}
            ];
            // this.model.questionBlocks.push(
            //     {
            //         block:
            //             {
            //                 //id: 1,
            //                 name:'Тест блок',
            //                 questions: [
            //                     {description: ""}
            //                 ]
            //             }
            //     })
        },
        components: {
            QuestionBlock
        },
        methods: {
            addBlock(){
                this.model.questionBlocks.push({block: {name:"", questions: []}})
            },
            deleteBlock(index){
                if (this.model.questionBlocks.length !== 1){
                    this.model.questionBlocks.splice(index,1)
                }
            },
            validate() {
                return new Promise((resolve, reject) => {
                    var valid = true;
                    this.$emit('on-validate', valid, this.model);
                    resolve(valid);
                });
            }
        }
    }
</script>

<style scoped>

</style>
