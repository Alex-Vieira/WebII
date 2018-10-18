import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(VueRouter);
Vue.use(VueResource);
Vue.use(BootstrapVue);

import Home from './paginas/Home.vue'
import Login from './componentes/Login'
import Cadastro from './componentes/Cadastro'



const routes = [
  {path: '/', component: Login},
  {path: '/home', component: Home},
  {path: '/cadastro', component: Cadastro},


];

const router = new VueRouter({
  routes
});

const app = new Vue({
  router
}).$mount('#app');
