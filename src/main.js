import Vue from 'vue'
import Vuelidate from 'vuelidate'
import VueRouter from 'vue-router'
import App from './App.vue'
import router from './routes'

Vue.use(Vuelidate)
Vue.use(VueRouter)

new Vue({
  render: h => h(App),
  router
}).$mount('#app')

