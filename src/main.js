import Vue from 'vue'
import Vuelidate from 'vuelidate'
import router from './router'
import store from "./store";
import App from './App.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

import ApiService from "./common/api.service";
import {CHECK_AUTH} from "./store/actions.type";

Vue.config.productionTip = false;
Vue.use(Vuelidate);
Vue.use(Vuetify);

ApiService.init();

router.beforeEach((to, from, next) =>
    Promise.all([store.dispatch(CHECK_AUTH)]).then(next)
);

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');

