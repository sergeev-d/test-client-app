
import {CHANGE_MODEL, CLEAR_MODEL } from "../mutations.type";
import { UPDATE_MODEL } from "../actions.type"

const state = {
    finalModel: {}
};

const getters = {
    model(state){
        return state.finalModel;
    }
};

const actions = {
    [UPDATE_MODEL](context, model) {
        context.commit(CHANGE_MODEL, model);
    }
};

const mutations = {
    [ CHANGE_MODEL ](state, model){
        state.finalModel = { ...state.finalModel, ...model };
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
