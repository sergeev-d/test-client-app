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
            name: "assessments",
            path: "/assessments",
            component: () => import("@/views/Assessments")
        },
        {
            name: "login",
            path: "/login",
            component: () => import("@/views/Login")
        },
        {
            name: "assessment",
            path: "/assessment/:id",
            component: () => import("@/views/Assessment"),
            props: true
        },
    ],
    mode: 'history'
})
