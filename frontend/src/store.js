import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const state = {
    authenticated: false,
    username: '',
    jwt: ''
}
export default new Vuex.Store({
  state
})