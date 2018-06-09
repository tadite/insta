// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vueResource from 'vue-resource'
import store from './store'
import Snotify from 'vue-snotify';
import 'vue-snotify/styles/material.css';

Vue.config.productionTip = false

/* eslint-disable no-new */
Vue.use(vueResource);
Vue.use(Snotify);

new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
})

