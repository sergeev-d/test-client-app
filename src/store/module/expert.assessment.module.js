import ApiService from "@/common/api.service";
import {
    CHANGE_CURRENT_ASSESSMENT,
    CLEAR_CURRENT_ASSESSMENT,
    SET_ERROR,
    FETCH_ASSESSMENTS
} from "../mutations.type";
import {
    UPDATE_CURRENT_ASSESSMENT,
    ADD_ASSESSMENT,
    DELETE_ASSESSMENT,
    CHANGE_ASSESSMENT,
    FETCH_EXPERT_ASSESSMENTS
} from "../actions.type"

const state = {
    templateAssessment:{
        name: '',
        description: '',
        status: '',
        comment: '',
        companyTypeId: '',
        industryId: '',
        userId: '',
        strategy: '',
        questionBlocks: [
            {
                block :
                    {
                        name:'',
                        questions: [],
                        recommendations: [
                            {
                                minValue:'',
                                maxValue:'',
                                description:''
                            }
                        ]
                    },
            }
        ],
        global_recommendations: [
            {
                minValue:'',
                maxValue:'',
                description:''
            }
        ]
    },
    currentAssessment: {},
    userAssessments: []
};

const getters = {
    currentAssessment(state){
        return state.currentAssessment;
    },
    userAssessments(state){
        return state.userAssessments;
    },
    templateAssessment(state){
        return state.templateAssessment;
    }
};

const actions = {
    [UPDATE_CURRENT_ASSESSMENT](state, assessment) {
        state.commit(CHANGE_CURRENT_ASSESSMENT, assessment);
    },
    [ADD_ASSESSMENT](state, assessment){
        return new Promise(resolve => {
            ApiService.post("/assessments", assessment)
                .then(({ data }) => {
                    assessment.id = data.id;
                    //state.commit(CHANGE_CURRENT_ASSESSMENT, assessment);
                    // add new assessment to state
                    state.commit(CLEAR_CURRENT_ASSESSMENT);
                    resolve(data)
                })
                .catch(({ response }) => {
                    state.commit(SET_ERROR, response)
                })
        })
    },
    [CHANGE_ASSESSMENT](state, assessment){
        ApiService.update("/assessments", assessment)
            .then(({ data }) => {
                state.commit(CLEAR_CURRENT_ASSESSMENT);
                resolve(data)
            })
            .catch(({ response }) => {
                state.commit(SET_ERROR, response)
            })
    },
    [DELETE_ASSESSMENT](state, assessmentId){
        return new Promise(resolve => {
            ApiService.delete("/assessments", assessmentId)
                .then(({ data }) => {
                    //state.commit(FETCH_ASSESSMENTS, data.assessments);
                    resolve(data)
                })
                .catch(({ response }) => {
                    state.commit(SET_ERROR, response.data.error)
                })
        })
    },
    [FETCH_EXPERT_ASSESSMENTS](state){
        return new Promise(resolve => {
            ApiService.query("/user_assessments")
                .then(({ data }) => {
                    state.commit(FETCH_ASSESSMENTS, data.assessments); // add id
                    resolve(data)
                })
                .catch(({ response }) => {
                    state.commit(SET_ERROR, response.data.error)
                })
        })
    }
};

const mutations = {
    [ CHANGE_CURRENT_ASSESSMENT ](state, assessment){
        state.currentAssessment = assessment;
    },
    [ CLEAR_CURRENT_ASSESSMENT ](state){
        state.currentAssessment = {}
    },
    [ FETCH_ASSESSMENTS ](state, userAssessments){
        state.userAssessments = userAssessments
    }
};

export default {
    state,
    getters,
    actions,
    mutations
};
