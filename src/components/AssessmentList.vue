<template>
    <div class="a-list-container">
        <div v-if="isLoading" class="assessment-preview">Загрузка доступных оценок</div>
        <div v-else>
            <div v-if="assessments.length === 0" class="assessment-preview">
                Нет доступных оценок
            </div>
            <assessment-preview
                    v-for="(assessment) in assessments"
                    :assessment=assessment
                    :key="assessment.id"
            />
            <assessment-pagination/>
        </div>
    </div>
</template>

<script>
    import AssessmentPreview from "../components/AssessmentPreview"
    import AssessmentPagination from "../components/AssessmentPagination"
    import { FETCH_ASSESSMENTS} from "../store/actions.type";
    import { mapGetters } from "vuex";

    export default {
        name : "MainAssessment",
        props : {
            itemsPerPage : {
                type : Number,
                required : true,
                default : 5
            }
        },
        components : {
            AssessmentPagination,
            AssessmentPreview
        },
        data () {
            return {
                currentPage: 1
            }
        },
        computed: {
            listConfig(){
                const filters = {
                    offset: (this.currentPage - 1) * this.itemsPerPage,
                    limit: this.itemsPerPage
                };
                return filters;
            },
            ...mapGetters(["assessments", "isLoading", "assessmentsCount"])
        },
        mounted() {
            this.fetchArticles();
        },
        methods: {
            fetchArticles() {
                this.$store.dispatch(FETCH_ASSESSMENTS, this.listConfig);
            },
            resetPagination() {
                this.listConfig.offset = 0;
                this.currentPage = 1;
            }
        }
    }
</script>
<style>
    .a-list-container {
        background-color: bisque;
    }
</style>
