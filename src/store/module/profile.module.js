import ApiService from "@/common/api.service";
import { DownloadService } from "../../common/api.service";


import {DOWNLOAD_FILE, FETCH_PROFILE, FETCH_PROFILE_ASSESSMENTS_RESULT} from "../actions.type";

import { SET_ERROR, SET_PROFILE, SET_PROFILE_ASSESSMENTS_RESULT } from "../mutations.type";

const state = {
    errors: null,
    profile: {},
    assessmentsResult: {}

};

const getters = {
    getUserProfile(state){
        return state.profile;
    },
    getProfileAssessmentsResult(state){
        return state.assessmentsResult;
    }
};

const actions = {
    [FETCH_PROFILE](context, userId){
        return new Promise(resolve => {
            ApiService.get("profile", { userId })
                .then(({ data }) => {
                    context.commit(SET_PROFILE, data.profile);
                    resolve(data);
                })
                .catch(({ response }) => {
                    context.commit(SET_ERROR, response.data.errors);
                });
        });
    },
    [FETCH_PROFILE_ASSESSMENTS_RESULT](context, userId){
        return new Promise(resolve => {
            ApiService.get("profile_assessments_result", { userId })
                .then(({ data }) => {
                    context.commit(SET_PROFILE_ASSESSMENTS_RESULT, data.assessmentsResult);
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
    }
};

const mutations = {
    [SET_ERROR](state, error) {
        state.errors = error;
    },
    [SET_PROFILE](state, profile) {
        state.profile = profile;
    },
    [SET_PROFILE_ASSESSMENTS_RESULT](state, assessmentsResult) {
        state.assessmentsResult = assessmentsResult;
    }
};

export default {
    state,
    actions,
    mutations,
    getters
};

/*
* getUserProfile +
* saveUserProfile
* getUserAssessments
* getRecommendedAssessments
* getOrganizations
* getOrganization
* addOrganization
* saveOrganization
* */
