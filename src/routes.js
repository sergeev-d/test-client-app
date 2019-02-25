import VueRouter from 'vue-router'
import Home from './components/Home.vue'
import Cars from './components/Cars.vue'
import Car from './components/Car.vue'
import AuthForm from './components/AuthForm.vue'

export default new VueRouter({
    routes: [
        {
            path: '', //localhost:8080
            component: Home
        },
        {
            path: '/cars', //localhost:8080/cars
            component: Cars
        },
        {
            path: '/auth',
            component: AuthForm
        },
        {
            path: '/car/:id',
            component: Car
        }
    ],
    mode: 'history'
})
