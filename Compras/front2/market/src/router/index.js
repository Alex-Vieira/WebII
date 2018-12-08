import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Cadastrar from '@/components/Cadastrar'
import ListaCategorias from '@/components/ListaCategorias'
import ListaProdutos from '@/components/ListaProdutos'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: "/cadastrar",
      name: 'Cadastrar',
      component: Cadastrar
    },
    {
      path: '/ListaCategorias',
      name: 'ListaCategorias',
      component: ListaCategorias
    },
    {
      path: '/ListaProdutos',
      name: 'ListaProdutos',
      component: ListaProdutos
    }
  ]
})
