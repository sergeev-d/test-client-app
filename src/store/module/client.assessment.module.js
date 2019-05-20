import ApiService from "@/common/api.service";
import { DownloadService } from "../../common/api.service";

import {
    DOWNLOAD_FILE,
    FETCH_USER_ASSESSMENTS_RESULT
} from "../actions.type";

import {
    SET_ERROR,
    SET_USER_ASSESSMENTS_RESULT
} from "../mutations.type";

const state = {
    errors: null,
    assessmentsResult:{}
};

const getters = {
    assessmentsResult(state){
        return state.assessmentsResult;
    }
};

const actions = {
    [FETCH_USER_ASSESSMENTS_RESULT](context){
        return new Promise(resolve => {
            ApiService.query("assessments-result")
                .then(({ data }) => {
                    context.commit(SET_USER_ASSESSMENTS_RESULT, data.assessmentsResult);
                    resolve(data);
                })
                .catch(({ response }) => {
                    context.commit(SET_ERROR, response.data.errors);
                });
        });
    },
    [DOWNLOAD_FILE](context, link){
        return new Promise(resolve => {
            DownloadService.get(link)
                .then(({data}) => {
                    resolve(data);
                });
        });
    },
};

const mutations = {
    [SET_ERROR](state, error) {
        state.errors = error;
    },
    [SET_USER_ASSESSMENTS_RESULT](state, assessmentsResult) {
        state.assessmentsResult = assessmentsResult;
    }
};

export default {
    state,
    actions,
    mutations,
    getters
};
