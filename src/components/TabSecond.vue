<template>
    <div class="wrapper" ref="form">
        <!--<form ref="form">-->
            <div>
                <label type="text"><span>Редактор блоков вопросов / утверждений</span></label>
            </div>
            <div>
                <label type="text">Варианты ответов для блоков</label>
                <select v-model="currentAssessment.strategy">
                    <option v-for="strategy in strategies" :value="strategy.value" :key="strategy.id">
                        {{ strategy.value }}
                    </option>
                </select>
            </div>
            <div class="wrapper">
                <div v-for="(qb, index) in currentAssessment.questionBlocks" :value=qb.block :key="index" style="border: 1px black solid">
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
    import { UPDATE_CURRENT_ASSESSMENT } from "../store/actions.type"
    import { mapGetters } from "vuex"

    export default {
        name: "TabSecond.vue",
        data () {
            return {
                strategies: []
            }
        },
        mounted() {
            this.strategies = [
                {id:"1", value:"да/нет/не знаю"},
                {id:"2", value:"да/нет/не знаю2"}
            ];
        },
        components: {
            QuestionBlock
        },
        methods: {
            addBlock(){
                this.currentAssessment.questionBlocks.push(
                    {
                        block: {
                            name:"",
                            questions:[],
                            recommendations:[]
                        },
                        global_recommendations:[]
                    }
                    )
            },
            deleteBlock(index){
                if (this.currentAssessment.questionBlocks.length !== 1){
                    this.currentAssessment.questionBlocks.splice(index,1)
                }
            },
            validate() {
                this.updateModel();
                return new Promise((resolve, reject) => {
                    var valid = true;
                    //this.$emit('on-validate', valid, this.currentAssessment);
                    this.$emit('on-validate', valid, this.currentAssessment);
                    resolve(valid);
                });
            },
            updateModel(){
                this.$store.dispatch(UPDATE_CURRENT_ASSESSMENT, this.currentAssessment)
            }
        },
        computed:{
            ...mapGetters(["currentAssessment"])
        }
    }
</script>

<style scoped>

</style>
