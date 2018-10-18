<template>
  <div class="contain">

    <div class="titulo">
      <h3>{{titulo}}</h3>
    </div>

    <div class="slider">
    <span v-on:mouseover="scrollEsquerda()" v-on:mouseout="clearScroll()" class="handle handlePrev active">
        <i class="fa fa-caret-left" aria-hidden="true"></i>
      </span>

      <div ref="scroller" class="row">
        <div class="row__inner">
          <filme v-for="filme in filmes" v-bind:key="filme.id" v-bind:nome="filme.titulo" v-bind:vid="filme.trailer+'?rel=0&autoplay=1'" v-bind:imagem="filme.imagem"
                 v-bind:sinopse="filme.sinopse"></filme>
        </div>
      </div>

      <span v-on:mouseover="scrollDireita()" v-on:mouseout="clearScroll()" class="handle handleNext active">
        <i class="fa fa-caret-right" aria-hidden="true"></i>
      </span>


    </div>

  </div>
</template>

<script>
  import Filme from "./Filme";


  export default {
    name: "categoria",
    props: ['titulo', 'filmes'],
    components: {Filme},
    data() {
      return {
        intervalo: null,

      }
    },
    methods: {

      scrollDireita() {
        this.intervalo = setInterval(() => {
          this.$refs.scroller.scrollLeft += 1
        }, 5);
      },
      scrollEsquerda() {
        this.intervalo = setInterval(() => {
          this.$refs.scroller.scrollLeft -= 1
        }, 5);
      },
      clearScroll() {
        clearInterval(this.intervalo);
      },
      showModal() {
        this.$refs.myModalRef.show()
      },
      hideModal() {
        this.$refs.myModalRef.hide()
      }
    }
  }
</script>

<style lang="scss">

  .contain {
    box-shadow: 5px 5px 10px 0 rgba(0, 0, 0, 0.7);
    padding: 1%;

    background-color: rgba(0, 0, 0, 0.3);
  }

  .slider {

    height: 350px;
    position: relative;
    padding: 0 4%;
    -ms-touch-action: pan-y;
    touch-action: pan-y;

  }

  .titulo h3 {
    text-shadow: 1px 1px 2px rgba(225, 225, 225, 0.5);
    margin: 3%;
    font-size: 30px;
    color: white;
    font-family: Segoe UI;
  }

  .slider .handle.handlePrev {
    left: 0;
    margin-left: 3%;
  }

  .slider .handle.handleNext {
    right: 0;
    margin-right: 3%;
  }

  .slider .handle.active {
    cursor: pointer;
  }

  .slider .handle {
    background: transparent;
    position: absolute;
    height: 351px;
    bottom: 0;
    width: 1%;
    text-align: center;
    -webkit-box-pack: center;
    -webkit-justify-content: center;
    -moz-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    display: -webkit-box;
    display: -webkit-flex;
    display: -moz-box;
    display: -ms-flexbox;
    display: flex;
    color: crimson;
    opacity: 0.9;
  }

  .fa {
    font-size: 46px;
    margin-top: 120px;
  }

  .row {
    overflow: hidden;
    margin: 2%;
  }

  .row__inner {
    -webkit-transition: 450ms -webkit-transform;
    transition: 450ms transform;
    font-size: 0;
    white-space: nowrap;
    margin: 0.5%;
    padding-bottom: 15px;
    padding-top: 15px;
  }

  .row__inner:hover .gui-card {
    opacity: 0.3;
  }

  .row__inner:hover .gui-card:hover {
    -webkit-transform: scale(0.95);
    transform: scale(0.95);
    opacity: 1;
    border-color: #ecf0f1;
  }
</style>
