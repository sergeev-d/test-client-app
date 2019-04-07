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
            name: "about",
            path: "/about",
            component: () => import("@/views/Home")
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
            name: "assessment",
            path: "/assessment/:id",
            component: () => import("@/views/Assessment"),
            props: true
        },
        {
            name: "user-account",
            path: "/user-account",
            component: () => import("@/views/UserAccount"),
            props: true,
            children: [
                {
                    path: "",
                    name: "dashboard",
                    component: () => import("@/views/UserAccount")
                },
                {
                    path: "profile",
                    name: "profile",
                    component: () => import("@/views/UserAccount")
                },
                {
                    path: "results",
                    name: "results",
                    component: () => import("@/views/UserAccount")
                }
                // },
                // {
                //     path: "organizations",
                //     name: "organizations",
                //     component: () => import("@/views/HomeTag")
                // }
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
