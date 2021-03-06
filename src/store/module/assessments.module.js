import { AssessmentService } from "../../common/api.service";
import { FETCH_ASSESSMENTS } from "../actions.type";
import {
    FETCH_START,
    FETCH_END
} from "../mutations.type";

const state = {
    assessments: [],
    isLoading: true,
    assessmentsCount: 0
};

const getters = {
    assessmentsCount(state) {
        return state.assessmentsCount;
    },
    assessments(state) {
        return state.assessments;
    },
    isLoading(state) {
        return state.isLoading;
    },
};

const actions = {
    [FETCH_ASSESSMENTS](state, params) {
        state.commit(FETCH_START);
        return AssessmentService.query() //params.filters
            .then(({ data }) => {
                state.commit(FETCH_END, data);
            })
            .catch(error => {
                throw new Error(error);
            });
    }
};

const mutations = {
    [FETCH_START](state){
        state.isLoading = true
    },
    [FETCH_END](state, { assessments, assessmentsCount }) {
        state.isLoading = false;
        state.assessments = assessments;
        state.assessmentsCount = assessmentsCount;

    }
};

export default {
    state,
    getters,
    actions,
    mutations
};
