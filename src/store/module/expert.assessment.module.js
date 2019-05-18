import ApiService from "@/common/api.service";
import {
    CHANGE_CURRENT_ASSESSMENT,
    CLEAR_CURRENT_ASSESSMENT,
    SET_ERROR,
    FETCH_ASESSMENTS
} from "../mutations.type";
import {
    UPDATE_CURRENT_ASSESSMENT,
    ADD_ASSESSMENT,
    DELETE_ASSESSMENT,
    CHANGE_ASSESSMENT,
    FETCH_EXPERT_ASSESSMENTS
} from "../actions.type"

const state = {
    currentAssessment: {
        id: '',
        assessmentName: '',
        description: '',
        industry:'',
        strategy: '',
        status: '',
        companyType: '',
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
    userAssessments: []
};

const getters = {
    currentAssessment(state){
        return state.currentAssessment;
    },
    getUserAssessment(state){
        return state.userAssessments;
    }
};

const actions = {
    [UPDATE_CURRENT_ASSESSMENT](state, currentAssessment) {
        state.commit(CHANGE_CURRENT_ASSESSMENT, currentAssessment);
    },
    [ADD_ASSESSMENT](state, {userId, assessment}){
        return new Promise(resolve => {
            ApiService.post("/assessments",{ userId, assessment})
                .then(({ data }) => {
                    state.commit(); // add id
                    state.commit(CLEAR_CURRENT_ASSESSMENT);
                    resolve(data)
                })
                .catch(({ response }) => {
                    state.commit(SET_ERROR, response.data.error)
                })
        })
    },
    [CHANGE_ASSESSMENT](state, {userId, assessment}){

    },
    [DELETE_ASSESSMENT](state, {userId, assessmentId}){

    },
    [FETCH_EXPERT_ASSESSMENTS](state){
        return new Promise(resolve => {
            ApiService.query("/assessments")
                .then(({ data }) => {
                    state.commit(FETCH_ASESSMENTS, data); // add id
                    resolve(data)
                })
                .catch(({ response }) => {
                    state.commit(SET_ERROR, response.data.error)
                })
        })
    }
};

const mutations = {
    [ CHANGE_CURRENT_ASSESSMENT ](state, currentAssessment){
        state.currentAssessment = { ...state.currentAssessment, ...currentAssessment };
    },
    [ CLEAR_CURRENT_ASSESSMENT ](state){
        state.currentAssessment = {}
    },
    [ FETCH_ASESSMENTS ](state, {userAssessments}){
        state.userAssessments = userAssessments
    }

};

export default {
    state,
    getters,
    actions,
    mutations
};
