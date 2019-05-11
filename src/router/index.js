import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    routes: [
        {
            name: "home",
            path: "/", //localhost:8080
            component: () => import("@/views/Home")
        },
        {
            name: "assessments",
            path: "/assessments",
            component: () => import("@/views/Assessments")
        },
        {
            name: "assessment",
            path: "/assessment/:id",
            component: () => import("@/views/Assessment"),
            props: true
        },
        {
            name: "signin",
            path: "/signin",
            component: () => import("@/views/SignIn")
        },
        {
            name: "signup",
            path: "/signup",
            component: () => import("@/views/SignUp")
        },
        {
            name: "profile",
            path: "/profile",
            props: true,
            component: () => import("@/views/Profile"),
            children: [
                {
                    path: "info",
                    name: "info",
                    component: () => import("@/views/Profile")
                },
                {
                    name: "results",
                    path: "results",
                    component: () => import("@/views/Profile")
                }
            ]
        },
        {
            name: "*",
            path: "/*",
            component: () => import("@/views/NotFound"),
            props: true
        },
    ],
    mode: 'history'
})
