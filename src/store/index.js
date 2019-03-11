import Vue from "vue";
import Vuex from "vuex";

import assessments from "./assessments.module"

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        assessments
    }
});
