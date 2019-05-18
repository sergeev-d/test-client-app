<template>
    <div class="wrapper">
        <form ref="form">
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
        </form>

    </div>
</template>

<script>
    export default {
        name: "TabThird.vue",
        data(){
            return {
                questionBlocks: []
            }
        },
        created() {

        },
        methods:{
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
