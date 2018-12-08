<template>
    <div id="divCadastrar">
        <b-tabs id="tabCadastro" variant="dark">
            <b-tab title="Produto" active>
                <CadastroProduto> </CadastroProduto>
            </b-tab>
            <b-tab title="Categoria" >
                <CadastroCategoria></CadastroCategoria>
            </b-tab>

        </b-tabs>
    </div>

</template>

<script>

    import CadastroProduto from './CadastroProduto.vue'
   import CadastroCategoria from './CadastroCategoria.vue'
    export default {
        name: "Cadastrar",
        components: {CadastroCategoria, CadastroProduto},
    }
</script>

<style scoped>

  #divCadastrar{
        background-image: url("../assets/home.jpg");
        background-size: cover;
        position: fixed;

        width: 100%;
        height: 100%;

    }
    #tabCadastro{
        background-color: rgba(0,0,0,0.5);
        margin: auto;
        width: 80%;
        margin-top: 5%;
        padding: 5%;
      animation: pulse 0.8s infinite;
      animation-direction: alternate;
      -webkit-animation-name: pulse;
      animation-name: pulse;
      border-radius: 2%;

    }

  @keyframes pulse {
    0% {
      box-shadow: rgba(255, 255, 255, 0.6) 0 0 5px 5px;
    }
    25% {
      box-shadow: rgba(255, 255, 255, 0.7) 0 0 6px 6px;
    }
    50% {
      box-shadow: rgba(255, 255, 255, 0.8) 0 0 7px 7px;
    }
    75% {
      box-shadow: rgba(255, 255, 255, 0.7) 0 0 8px 8px;
    }
    100% {
      box-shadow: rgba(255, 255, 255, 0.6) 0 0 9px 9px;
    }
  }
</style>
