<template>
    <div class="col-md-9 sidebar">
        <form-wizard
                title="Создание новой оценки"
                subtitle=""
                nextButtonText="Далее"
                backButtonText="Назад"
                finishButtonText="Завершить"
                stepSize="xs"
                color="#354F5A"
                shape="tab"
                validate-on-back
                ref="wizard"
                :start-index.sync="activeTabIndex"
                @on-complete="onComplete">
            <tab-content title="Шаг 1" :before-change="() => validate('tab-first')">
                <tab-first ref="tab-first" @on-validate="onStepValidate"></tab-first>
            </tab-content>
            <tab-content title="Шаг 2" :before-change="() => validate('tab-second')">
                <tab-second ref="tab-second" @on-validate="onStepValidate"></tab-second>
            </tab-content>
            <tab-content title="Шаг 3" :before-change="() => validate('tab-third')">
                <tab-third ref="tab-third" @on-validate="onStepValidate"></tab-third>
            </tab-content>
        </form-wizard>
    </div>
</template>

<script>
    // https://binarcode.github.io/vue-form-wizard/#/?id=direct-script-include
    import {FormWizard, TabContent} from 'vue-form-wizard'
    import 'vue-form-wizard/dist/vue-form-wizard.min.css'
    import TabFirst from '../components/TabFirst'
    import TabSecond from '../components/TabSecond'
    import TabThird from '../components/TabThird'

    export default {
        name: "AssessmentWizard.vue",
        components: {
            FormWizard,
            TabContent,
            TabFirst,
            TabSecond,
            TabThird
        },
        data() {
            return {
                //finalModel: {},
                activeTabIndex: 0
            };
        },
        methods: {
            onComplete() {
                alert("Yay. Done!");
            },
            validate(ref) {
                return this.$refs[ref].validate();
            },
            onStepValidate(validated, model) {
                // if (validated) {
                //     this.finalModel = { ...this.finalModel, ...model };
                // }
            }

        }
    }

</script>

<style scoped>

</style>
