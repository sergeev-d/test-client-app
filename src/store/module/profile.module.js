import ApiService from "@/common/api.service";

import {
    FETCH_USER_PROFILE
} from "../actions.type";

import { SET_ERROR,
    SET_PROFILE
} from "../mutations.type";

const state = {
    errors: null,
    userProfile: {}
};

const getters = {
    userProfile(state){
        return state.userProfile;
    }
};

const actions = {
    [FETCH_USER_PROFILE](context){
        return new Promise(resolve => {
            ApiService.query("profiles")
                .then(({ data }) => {
                    context.commit(SET_PROFILE, data.profile);
                    resolve(data);
                })
                .catch(({ response }) => {
                    context.commit(SET_ERROR, response.data.errors);
                });
        });
    }
};

const mutations = {
    [SET_ERROR](state, error) {
        state.errors = error;
    },
    [SET_PROFILE](state, profile) {
        state.userProfile = profile;
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
