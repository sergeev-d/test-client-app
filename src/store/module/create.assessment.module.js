
import {CHANGE_MODEL, CLEAR_MODEL } from "../mutations.type";
import { UPDATE_MODEL } from "../actions.type"

const state = {
    model: {
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
    }
};

const getters = {
    currentModel(state){
        return state.model;
    }
};

const actions = {
    [UPDATE_MODEL](context, model) {
        context.commit(CHANGE_MODEL, model);
    }
};

const mutations = {
    [ CHANGE_MODEL ](state, model){
        state.model = { ...state.model, ...model };
    },
    [ CLEAR_MODEL ](state){
        state.model = {}
    }
};

export default {
    state,
    getters,
    actions,
    mutations
};
