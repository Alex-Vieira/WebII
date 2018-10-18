<template>
  <div id="divGeral2">


    <div class="containCadastro">
      <b-alert show variant="success" v-show="showSucesso">Operação Realizada com sucesso! {{usuarioSalvo}}</b-alert>
      <b-form @submit="salvarUsuario" class="formLogin">

        <b-form-group id="login" label-for="nomeUsuarioInput">

          <b-form-input class="inputLogin" id="nomeUsuarioInput"
                        type="text"
                        v-model="usuario.nome"
                        required
                        placeholder="Username">
          </b-form-input>

          <b-form-input class="inputPassword" id="senhaUsuarioInput"
                        type="password"
                        v-model="usuario.senha"
                        required
                        placeholder="Password">


          </b-form-input>

        </b-form-group>
        <div class="formButton">
          <b-button class="btnSave" type="submit" variant="success">Save</b-button>
          <router-link to="/">
            <b-button class="btnCancel" variant="danger"> Cancel</b-button>
          </router-link>

        </div>


      </b-form>

    </div>

  </div>
</template>

<script>
  export default {
    name: "cadastro",
    data() {
      return {
        usuario: {
          nome: '',
          senha: ''
        },
        usuarioSalvo: null,
        showSucesso: false
      }
    },
    methods: {
      salvarUsuario: function (evt) {
        this.$http.post('http://localhost:3000/usuario', this.usuario).then(response => {
          this.usuarioSalvo = response.body;
          window.location.href = "#/"
        });
      },

    }
  }
</script>

<style lang="scss">
  @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

  #divGeral2 {
    background-image: url("../assets/cinema.jpg");
    background-size: cover;
    position: absolute;

    width: 100%;
    height: 100%;
    padding-top: 8%;
  }

  .containCadastro {

    text-align: center;
    background-color: rgba(0, 0, 0, 0.6);
    height: 400px;
    width: 400px;
    margin: auto;
    padding: 2%;
    text-align: center;

    height: 400px;
    width: 400px;
    transform: rotate(-45deg);
    padding-top: 100px;

    animation: pulse 0.8s infinite;
    animation-direction: alternate;
    -webkit-animation-name: pulse;
    animation-name: pulse;
  }

  .containCadastro form {
    transform: rotate(45deg);

  }

  .containCadastro.inputLogin {
    margin: auto auto 10%;
    max-width: 50%;
    border: 0px;
    border-bottom: 2px solid white;
    background-color: transparent;
    color: white;
  }

  .containCadastro.inputLogin:focus {

    box-shadow: 0 0 0 0;
    border: 0 none;
    outline: 0;
    background-color: transparent;
    border-bottom: 2px solid crimson;
    color: white;
  }

  .containCadastro.inputPassword {
    margin: auto auto 10%;
    max-width: 50%;
    border: 0px;
    border-bottom: 2px solid white;
    background-color: transparent;
    color: white;
  }

  .containCadastro.inputPassword:focus {
    box-shadow: 0 0 0 0;
    border: 0 none;
    outline: 0;
    background-color: transparent;
    border-bottom: 2px solid crimson;
    color: white;
  }

  .containCadastro.formButton {
    margin: auto;
    text-align: center;
  }

  .inputLogin {
    margin: auto auto 10%;
    max-width: 50%;
    border: 0px;
    border-bottom: 2px solid white;
    background-color: transparent;
    color: white;
  }

  .inputLogin:focus {

    box-shadow: 0 0 0 0;
    border: 0 none;
    outline: 0;
    background-color: transparent;
    border-bottom: 2px solid crimson;
    color: white;
  }

  .inputPassword {
    margin: auto auto 10%;
    max-width: 50%;
    border: 0px;
    border-bottom: 2px solid white;
    background-color: transparent;
    color: white;
  }

  .inputPassword:focus {
    box-shadow: 0 0 0 0;
    border: 0 none;
    outline: 0;
    background-color: transparent;
    border-bottom: 2px solid crimson;
    color: white;
  }

</style>
