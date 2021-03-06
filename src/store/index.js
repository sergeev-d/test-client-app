import Vue from "vue";
import Vuex from "vuex";

import assessments from "./module/assessments.module"
import auth from "./module/auth.module"
import profile from "./module/profile.module"
import expert_assessment from "./module/expert.assessment.module"
import client_assessment from "./module/client.assessment.module"

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        assessments,
        auth,
        profile,
        expert_assessment,
        client_assessment
    }
});
