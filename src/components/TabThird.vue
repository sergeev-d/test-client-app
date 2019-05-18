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
            <div v-for="(qb, index) in currentModel.questionBlocks" :value=qb.block :key="index">
                <label type="text">{{qb.block.name}}</label>
                <block-result :recommendations="qb.block.recommendations"></block-result>
            </div>
            <div>
                <label type="text">{{"Глобальная рекомендация"}}</label>
                <block-result :recommendations="currentModel.global_recommendations"></block-result>
            </div>
        </div>
    </div>
</template>

<script>
    import BlockResult from "../components/BlockResult"
    import { UPDATE_MODEL } from "../store/actions.type"
    import { mapGetters } from "vuex"

    export default {
        name: "TabThird.vue",
        components: {
            BlockResult
        },
        data () {
            return {
                // model: {
                //     questionBlocks: []
                // }
            }
        },
        methods:{
            validate() {
                return new Promise((resolve, reject) => {
                    var valid = true;
                    //this.$emit('on-validate', valid, this.model);
                    this.$emit('on-validate', valid, this.currentModel);
                    resolve(valid);
                });
            }
        },
        computed:{
            ...mapGetters(["currentModel"])
        }
    }
</script>

<style scoped>

</style>
