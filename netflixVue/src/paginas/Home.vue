<template>
  <div class="main">
    <div class="menu">
      <cabecalho v-bind:usuario="usuario"></cabecalho>
    </div>

    <div class="contain">


      <categoria v-for="categoria in categorias" :key="categoria.id" v-bind:titulo="categoria.titulo"
                 v-bind:filmes="categoria.filmes"></categoria>


    </div>
  </div>
</template>

<script>
  import Categoria from '../componentes/Categoria'
  import cabecalho from "../componentes/Cabecalho";

  export default {
    name: 'app',
    components: {
      cabecalho,
      Categoria,

    },
    data() {
      return {
        categorias: [],
        login: []
      }
    },
    created() {
      this.$http.get('http://localhost:3000/categorias').then(response => {
        this.categorias = response.body;
      });
      this.$http.get('http://localhost:3000/login').then(response => {
        this.login = response.body;
      });
    }
  }
</script>

<style lang="scss">
  @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

  body,
  html {
    margin: 0;

    color: #ecf0f1;
    font-family: 'Open Sans', sans-serif;
    min-height: 100vh;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    -ms-flex-direction: row;
    flex-direction: row;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    width: 100%;
    height: 100%;
    /* Center the image */
    background-image: url("https://cdn.fstatic.com/media/groups/2016/05/06/cinema-1214189817jpg");
    background-size: cover;
  }

  .menu {
    align-items: center;
  }

  #app {
    width: 100%;
    height: 100%;
  }

</style>
