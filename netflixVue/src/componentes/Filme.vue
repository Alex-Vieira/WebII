<template>
  <div class="gui-card">

    <b-card overlay class="card" bg-variant="dark"
            v-bind:header="nome"
            text-variant="white">

      <div class="player">
        <img v-on:mouseover="showVideo" v-if="!condicao" v-bind:src="imagem" height="220" width="100%">
        <iframe class="frameVideo" v-on:mouseout="showVideo" v-if="condicao" width="320" height="220" v-bind:src="vid"
                frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
      </div>
    </b-card>

  </div>

</template>
<script>
  export default {
    name: "filme",
    props: ['nome', 'vid', 'imagem', 'sinopse'],
    components: {},
    data() {
      return {
        condicao: false
      }
    },
    methods: {
      showVideo: function () {
        this.condicao = !this.condicao;
      },
    }
  }
</script>

<style lang="scss">

  .card {
    box-shadow: 5px 5px 10px 0 rgba(0, 0, 0, 0.7);
    width: 90%;
    height: 90%;
    text-align: center;
  }

  .player {
    margin-top: 20px;
  }

  .botaoClose {
    width: 10%;
    height: 10%;
    text-align: center;
    float: right;
    padding: 2px;
    margin-top: -1.8%;
    margin-bottom: 2%;
  }

  .gui-card {
    position: relative;
    display: inline-block;
    width: 400px;
    height: 300px;
    margin-right: 10px;
    font-size: 20px;
    cursor: pointer;
    -webkit-transition: 450ms all;
    transition: 450ms all;
    -webkit-transform-origin: center;
    transform-origin: center;
  }

  .gui-card__details {
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    top: 0;
    font-size: 10px;
    opacity: 0;
    background: -webkit-linear-gradient(bottom, rgba(0, 0, 0, 0.9) 0%, rgba(0, 0, 0, 0) 100%);
    background: linear-gradient(to top, rgba(0, 0, 0, 0.9) 0%, rgba(0, 0, 0, 0) 100%);
    -webkit-transition: 450ms opacity;
    transition: 450ms opacity;
  }

  .gui-card__details:after,
  .gui-card__details:before {
    content: '';
    position: absolute;
    top: 50%;
    left: 50%;

  }

  .gui-card__details:after {
    margin-top: -25px;
    margin-left: -25px;
    width: 50px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    border-radius: 100%;
    background: rgba(255, 255, 255, 0.5);
    z-index: 1;

  }

  .gui-card:hover .gui-card__details {
    opacity: 1;
  }

  .gui-card__title {
    position: absolute;
    bottom: 0;
    padding: 10px;
    font-family: roboto;
  }

  .gui-card:hover ~ .gui-card {
    -webkit-transform: translate3d(125px, 0, 0);
    transform: translate3d(125px, 0, 0);
  }

</style>
