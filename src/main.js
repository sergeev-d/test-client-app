import Vue from 'vue'
import Vuelidate from 'vuelidate'
import router from './router'
import App from './App.vue'

Vue.config.productionTip = false;
Vue.use(Vuelidate)

new Vue({
  router,
  render: h => h(App),

}).$mount('#app')

