import Vue from 'vue'
import Vuelidate from 'vuelidate'
import router from './router'
import store from "./store";
import App from './App.vue'

import ApiService from "./common/api.service";

Vue.config.productionTip = false;
Vue.use(Vuelidate);

ApiService.init();

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');

