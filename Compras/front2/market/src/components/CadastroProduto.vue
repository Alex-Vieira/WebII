<template>
  <div id="divProd">
    <b-form id="cadProduto" @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="formProduto">

        <b-form-input id="inputNome"

                      v-model="produto.nome"
                      required
                      placeholder="Nome">
        </b-form-input>


        <b-form-input id="inputPreco"
                      type="number"
                      min="0"
                      v-model="produto.preco"
                      required
                      placeholder="Preço">
        </b-form-input>


        <b-form-select id="inputCategoria" v-model="produto.categoria" class="mb-3" :options="categorias"></b-form-select>

      </b-form-group>

      <div class="formButton">
        <b-button type="submit" variant="success">Cadastrar</b-button>
        <b-button type="reset" v-on:click="onReset" variant="danger">Limpar</b-button>
      </div>

    </b-form>
  </div>
</template>

<script>
  const categorias = []
  export default {
    name: 'cadProduto',
    data() {
      return {
        categorias: categorias,
        produto: {
          nome: '',
          price: '',
          categoria: []
        },
        show: true,
        selected: null,
      }
    },
    methods: {
      onSubmit(evt) {

        this.$http.post('http://localhost:8081/produtos', this.produto).then(response => {
          alert(JSON.stringify(this.produto.nome + " cadastrado com sucesso!"));
        });

      },
      onReset(evt) {
        evt.preventDefault();
        /* Reset our form values */

        this.produto.nome = '';
        this.produto.preco = '';
        this.produto.categoria = [];

        this.show = false;
        this.$nextTick(() => {
          this.show = true
        });
      },
      carregar(){
        this.$http.get('http://localhost:8081/categorias').then(response => {
          this.categorias =response.body;
        });
      },
    },
    created() {
      this.$http.get('http://localhost:8081/categorias').then(response => {

            this.categorias = response.body;
      });
    }
  }
</script>


<style scss>
  #divProd {
    width: 70%;
    margin: auto;
  }

  #cadProduto {
    background-color: rgba(0, 0, 0, 0.5);
    margin: auto;
    width: 50%;
    padding: 5%;
    border-radius: 2%;

    text-align: center;
  }

  #inputNome, #inputPreco, #inputCategoria {

    margin-bottom: 2%;
    color: black;
    background-color: rgba(255, 255, 255, 0.6);

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
