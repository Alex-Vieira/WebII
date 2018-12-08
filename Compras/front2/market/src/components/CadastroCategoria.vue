<template>
    <div id="divProd">
        <b-form id="cadProduto" @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group id="formProduto">

                <b-form-input id="inputNome"
                              v-model="categoria.nome"
                              required
                              placeholder="Nome">
                </b-form-input>

            </b-form-group>

            <div class="formButton">
                <b-button type="submit" variant="success">Cadastrar</b-button>
                <router-link to="/">
                    <b-button type="reset" variant="danger">Limpar</b-button>
                </router-link>
            </div>

        </b-form>
    </div>
</template>

<script>
    export default {
        name: 'cadCategoria',
        data() {
            return {
                categoria: {
                    nome: '',

                },
                show: true,
                selected: null,
            }
        },
        methods: {
            onSubmit(evt) {
              this.$http.post('http://localhost:8081/categorias', this.categoria).then(response => {
                window.alert("cadastrada!");
              });
            },
            onReset(evt) {
                evt.preventDefault();
                /* Reset our form values */

                this.categoria.name = '';
                /* Trick to reset/clear native browser form validation state */
                this.show = false;
                this.$nextTick(() => {
                    this.show = true
                });
            }
        }
    }
</script>


<style scss>

    #cadProduto {
        background-color: rgba(0,0,0,0.5);
        margin: auto;
        width: 50%;
        margin-top: 10%;
        padding: 5%;

      border-radius: 2%;

    }

    #inputNome {
      margin-bottom: 2%;
      color: black;
      background-color: rgba(255, 255, 255, 0.6);
    }



</style>
