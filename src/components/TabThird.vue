<template>
    <div class="wrapper" ref="form">
        <div>
            <label type="text"><span>Редактор оценки и рекомендаций</span></label>
        </div>
        <div>
            <label type="text"><span>Информация про баллы</span></label>
            <table>
                <tr>
                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                </tr>
                <tr>
                    <td><span>{{1}}</span></td>
                    <td><span>{{2}}</span></td>
                </tr>
                <tr>
                    <th>{{"Минимально возможное количество баллов общее"}}</th>
                    <th>{{"Минимально возможное количество баллов в блоке"}}</th>
                </tr>
                <tr>
                    <td><span>{{3}}</span></td>
                    <td><span>{{4}}</span></td>
                </tr>
            </table>
        </div>
        <div class="wrapper">
            <div v-for="(qb, index) in currentAssessment.questionBlocks" :value=qb.block :key="index">
                <label type="text">{{qb.block.name}}</label>
                <block-result :recommendations="qb.block.recommendations"></block-result>
            </div>
            <div>
                <label type="text">{{"Глобальная рекомендация"}}</label>
                <block-result :recommendations="currentAssessment.global_recommendations"></block-result>
            </div>
        </div>
    </div>
</template>

<script>
    import BlockResult from "../components/BlockResult"
    import { UPDATE_CURRENT_ASSESSMENT } from "../store/actions.type"
    import { mapGetters } from "vuex"

    export default {
        name: "TabThird.vue",
        components: {
            BlockResult
        },
        methods:{
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
