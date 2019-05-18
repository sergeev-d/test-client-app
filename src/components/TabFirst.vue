<template>
    <!--<div class="wrapper">-->
        <form :model="model" :rules="rules" ref="form">
            <div>
                <label type="text">Название</label>
                <input v-model="model.assessmentName"/>
            </div>
            <div>
                <label type="text">Описание</label>
                <textarea v-model="model.description"></textarea>
            </div>
            <div>
                <label type="text">Отрасль</label>
                <select v-model="model.selectedIndustry">
                    <option v-for="industry in industryList" :value="industry.name" :key="industry.id">
                        {{ industry.name }}
                    </option>
                </select>
            </div>
            <div>
                <label type="text">Страна</label>
                <select v-model="model.selectedCountry">
                    <option v-for="country in countryList" :value="country" :key="country.id">
                        {{ country }}
                    </option>
                </select>
            </div>
        </form>
    <!--</div>-->
</template>

<script>

    export default {
        name: "TabFirst.vue",
        data(){
            return {
                industryList: [],
                countryList:[],
                model: {
                    assessmentName: '',
                    description: '',
                    selectedIndustry:'',
                    selectedCountry:''
                },
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
                return new Promise((resolve, reject) => {
                    var valid = true;
                    this.$emit('on-validate', valid, this.model);
                    resolve(valid);
                });
            }
        },
        created() {
            this.industryList = [{"id":1, "name":"Computer Science"},{"id":2,"name":"Physics"}];
            this.countryList = ['Россия', 'Англия', 'Франция'];
        }
    }
</script>

<style scoped>

</style>
