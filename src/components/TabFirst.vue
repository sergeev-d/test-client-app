<template>
    <!--<div class="wrapper">-->
        <form :model="currentModel" :rules="rules" ref="form">
            <div>
                <label type="text">Название</label>
                <input v-model="currentModel.assessmentName"/>
            </div>
            <div>
                <label type="text">Описание</label>
                <textarea v-model="currentModel.description"></textarea>
            </div>
            <div>
                <label type="text">Отрасль</label>
                <select v-model="currentModel.industry">
                    <option v-for="industry in industries" :value="industry.name" :key="industry.id">
                        {{ industry.name }}
                    </option>
                </select>
            </div>
            <div>
                <label type="text">Страна</label>
                <select v-model="currentModel.companyType">
                    <option v-for="country in companyTypes" :value="country" :key="country.id">
                        {{ country }}
                    </option>
                </select>
            </div>
        </form>
    <!--</div>-->
</template>

<script>
    import { UPDATE_MODEL } from "../store/actions.type"
    import { mapGetters } from "vuex"

    export default {
        name: "TabFirst.vue",
        data(){
            return {
                industries: [],
                companyTypes:[],
                // model: {
                //     assessmentName: '',
                //     description: '',
                //     selectedIndustry:'',
                //     selectedCountry:''
                // },
                rules: {
                    assessmentName: [{
                        required: true,
                        message: 'First name is required',
                        trigger: 'blur'
                    }],
                    description: [{
                        required: true,
                        message: 'Last name is required',
                        trigger: 'blur'
                    }],
                    selectedIndustry: {
                        required: true,
                        message: 'Email is required',
                        trigger: 'blur'
                    },
                    selectedCountry: {
                        required: true,
                        message: 'Email is required',
                        trigger: 'blur'
                    },
                }
            }},
        methods: {
            validate() {
                this.updateModel()
                return new Promise((resolve, reject) => {
                    var valid = true;
                    //this.$emit('on-validate', valid, this.model);
                    this.$emit('on-validate', valid, this.currentModel);
                    resolve(valid);
                });
            },
            updateModel(){
                this.$store.dispatch(UPDATE_MODEL, this.model)
            }
        },
        created() {
            this.industries = [{"id":1, "name":"Computer Science"},{"id":2,"name":"Physics"}];
            this.companyTypes = ['Россия', 'Англия', 'Франция'];
        },
        computed: {
            ...mapGetters(["currentModel"])
        }
    }
</script>

<style scoped>

</style>
