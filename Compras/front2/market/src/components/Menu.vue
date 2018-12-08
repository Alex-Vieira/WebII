<template>

  <b-navbar toggleable="md" type="dark" variant="dark">

    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <b-navbar-brand id="navHome" to="/">
      <i class="fa fa-home" aria-hidden="true"></i>
    </b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">

      <b-navbar-nav>
        <b-nav-item to="/Cadastrar">Cadastrar</b-nav-item>
        <b-nav-item to="/ListaCategorias">Categorias</b-nav-item>
        <b-nav-item to="/ListaProdutos">Produtos</b-nav-item>
        <b-nav-item href="#" disabled>Disabled</b-nav-item>

      </b-navbar-nav>


    </b-collapse>
  </b-navbar>
</template>

<script>
  export default {
    name: "Menu",
  }
</script>

<style scoped>
  @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

  #navHome {
    width: 2%;
    height: 2%;
  }

</style>
