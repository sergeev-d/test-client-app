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
        // {
        //     name: "profile",
        //     path: "/profile/:id",
        //     props: true,
        //     component: () => import("@/views/Profile")
        // },
        {
            name: "client-profile",
            path: "/client-profile/",
            component:() => import("@/views/Profile"),
            props: true,
            children: [
                {
                    path: 'dashboard',
                    name: 'dashboard',
                    component: () => import("@/components/ClientDashboard")
                },
                {
                    path: 'client-info',
                    name: 'client-info',
                    component: () => import("@/components/ClientInfo")
                },
                {
                    name: 'results',
                    path: 'results',
                    component: () => import("@/components/ClientAssessmentResult")
                }
            ]
        },
        {
            name: "expert-profile",
            path: "/expert-profile/:id",
            component: () => import("@/views/Profile"),
            children: [
                {
                    path: "expert-info",
                    name: "expert-info\"",
                    component: () => import("@/views/Profile")
                },
                {
                    name: "expert-assessments",
                    path: "expert-assessments",
                    component: () => import("@/views/Profile")
                }
            ]
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
            name: "*",
            path: "/*",
            component: () => import("@/views/NotFound"),
            props: true
        },
    ],
    mode: 'history'
})
