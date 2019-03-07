import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: "/", //localhost:8080
            component: () => import("@/views/Home")
        },
        {
            name: "assessment",
            path: "/assessments",
            component: () => import("@/views/Assessments")
        },
        {
            name: "login",
            path: "/login",
            component: () => import("@/views/Login")
        }
    ],
    mode: 'history'
})
