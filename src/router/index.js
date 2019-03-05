import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/', //localhost:8080
            component: () => import("@/views/Home")
        }
    ],
    mode: 'history'
})
