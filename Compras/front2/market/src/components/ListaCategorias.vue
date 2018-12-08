<template xmlns:v-b-scrollspy="http://www.w3.org/1999/XSL/Transform">
  <b-container id="buscar" fluid>
    <!-- User Interface controls -->
    <b-row>
      <b-col md="10" class="my-1">

        <b-form-group horizontal label="Pesquisar" class="mb-0" style="color:white">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Categoria"/>
            <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
          </b-input-group>
        </b-form-group>
      </b-col>
    </b-row>

    <!-- Main table element -->
    <b-table show-empty
             stacked="md"
             :items="items"
             :fields="fields"
             :current-page="currentPage"
             :per-page="perPage"
             :filter="filter"
             dark
             @filtered="onFiltered"
    >
      <template slot="name" slot-scope="row" v-for="item in items">{{row.item.nome}}</template>
      <!--<template slot="name" slot-scope="row">{{row.value.first}} {{row.value.last}}</template>-->

      <template slot="actions" slot-scope="row">
        <!-- We use @click.stop here to prevent a 'row-clicked' event from also happening -->

        <b-button size="sm" @click.stop="row.toggleDetails">
          <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
          {{ row.detailsShowing ? 'Esconder' : 'Listar' }} Produtos
        </b-button>
        <b-button size="sm"><i class="fa fa-pencil" aria-hidden="true"></i></b-button>
        <b-button size="sm" v-on:click="deletar(row.item.id)"><i class="fa fa-trash" aria-hidden="true"></i></b-button>
      </template>

      <template slot="row-details" slot-scope="row">
        <b-card>
          <ul>
            <li v-for="produto in row.item.produtos">{{produto.nome}}  <b-button size="sm" v-on:click="deletarProduto(row.item.id)"><i class="fa fa-trash" aria-hidden="true"></i></b-button></li>
          </ul>
        </b-card>
      </template>
    </b-table>

    <b-row>
      <b-col md="6" class="my-1">
        <b-pagination size="sm" :total-rows="totalRows" :per-page="perPage" v-model="currentPage" class="my-0"/>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
  const items = []

  export default {
    name: 'ListaCategorias',
    data() {
      return {
        categorias: [],
        items: items,
        fields: [
          {key: 'name', label: 'Categoria', sortable: true, sortDirection: 'desc'},
          {key: 'actions', label: 'Actions'}
        ],
        currentPage: 1,
        perPage: 5,
        totalRows: items.length,
        pageOptions: [5, 10, 15],
        sortBy: null,
        sortDesc: false,
        sortDirection: 'asc',
        filter: null,
        modalInfo: {title: '', content: ''}
      }
    },
    created(){
      this.carregar();
    },
    computed: {
      sortOptions() {
        // Create an options list from our fields
        return this.fields
          .filter(f => f.sortable)
          .map(f => {
            return {text: f.label, value: f.key}
          })
      }
    },

    methods: {
      carregar(){
        this.$http.get('http://localhost:8081/categorias').then(response => {
          this.items =response.body;
        });
      },
      deletar (evt) {
        this.$http.delete('http://localhost:8081/categorias/'+ evt).then(response => {
          this.carregar();
        });
       // window.alert("Categoria com produtos relacionados! Não é possível excluir...");
      },
      deletarProduto(evt) {
        this.$http.delete('http://localhost:8081/produtos/' + evt).then(response => {
          this.carregar();
        });

      },
      onFiltered(filteredItems) {
        // Trigger pagination to update the number of buttons/pages due to filtering
        this.totalRows = filteredItems.length
        this.currentPage = 1
      }
    }
  }
</script>


<style>


  body {
    background-image: url("../assets/home.jpg");
    background-size: cover;
    position: relative;

    width: 100%;
    height: 100%;
  }

  #buscar {
    margin-top: 2%;
    height: 100%;
    width: 50%;
    padding: 1%;
    border-radius: 2%;
    background-color: rgba(0, 0, 0, 0.6);

    animation: pulse 0.8s infinite;
    animation-direction: alternate;
    -webkit-animation-name: pulse;
    animation-name: pulse;
  }

  .table .card {
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
