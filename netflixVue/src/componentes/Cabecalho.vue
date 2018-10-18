<template>
  <div class="menuTopo">
    <b-navbar toggleable="md" type="dark" variant="dark">

      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <b-navbar-brand href="#">RibeirinhoFlix</b-navbar-brand>

      <b-collapse is-nav id="nav_collapse">
        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">

          <b-nav-form>
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Search"/>
            <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
          </b-nav-form>

          <b-nav-item right>
            <h2>{{usuario}}</h2>
          </b-nav-item>


          <b-nav-item-dropdown right>
            <!-- Using button-content slot -->
            <b-dropdown-item href="/">Signout</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>

      </b-collapse>
    </b-navbar>

  </div>

</template>

<script>
  export default {
    name: "cabecalho",
    props: ['usuario'],
  }
</script>


<style lang="scss">

  .menuTopo{
    box-shadow: 0 4px 0 0 rgba(255, 255, 255, 0.2);
  }

</style>
