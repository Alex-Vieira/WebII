<template>
  <div id="divGeral">


    <div id="containLogin" class="containLogin">
      <div>
        <b-alert class="alertErro" v-if="naoCadastrado" show variant="danger">Usuário não cadastrado!</b-alert>
        <b-alert class="alertErro" v-if="incorreto" show variant="danger">Usuário ou senha incorretos!</b-alert>

        <b-form @submit="login" class="formLogin">

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
            <b-button class="btnLogin" type="submit" variant="success">Login</b-button>
            <router-link to="/cadastro">
              <b-button class="btnSignUp" variant="primary"> Sign Up</b-button>
            </router-link>

          </div>


        </b-form>

      </div>
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
        logado: false,
        naoCadastrado: false,
        incorreto: false
      }
    },
    created() {

    },
    methods: {
      login: function (evt) {
        this.incorreto = false
        this.naoCadastrado = false
        this.$http.get('http://localhost:3000/usuario').then(response => {
          var user = response.body;

          for (var i in user) {
            if ((this.usuario.nome === user[i].nome &&this.usuario.senha === user[i].senha)) {
                window.location.href = "#/home"
                this.logado = true
              } else {
                document.getElementById("containLogin").style.animationName = "pulseError";
                window.location.href = "#/"
              }
            }

        });
      }
    }
  }
</script>

<style lang="scss">
  @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

  #divGeral {
    background-image: url("../assets/cinema.jpg");
    background-size: cover;
    position: absolute;

    width: 100%;
    height: 100%;
    padding-top: 8%;
  }

  .containLogin {

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

  @keyframes pulse {
    0% {
      box-shadow: rgba(255, 255, 255, 0.6) 0 0 10px 10px;

    }
    25% {
      box-shadow: rgba(255, 255, 255, 0.7) 0 0 12px 12px;
    }
    50% {
      box-shadow: rgba(255, 255, 255, 0.8) 0 0 14px 14px;
    }
    75% {
      box-shadow: rgba(255, 255, 255, 0.7) 0 0 16px 16px;
    }
    100% {
      box-shadow: rgba(255, 255, 255, 0.6) 0 0 18px 18px;
    }
  }

  @keyframes pulseError {
    0% {
      box-shadow: rgba(220, 20, 60, 0.6) 0 0 10px 10px;
    }
    25% {
      box-shadow: rgba(220, 20, 60, 0.7) 0 0 12px 12px;
    }
    50% {
      box-shadow: rgba(220, 20, 60, 0.8) 0 0 14px 14px;
    }
    75% {
      box-shadow: rgba(220, 20, 60, 0.7) 0 0 16px 16px;
    }
    100% {
      box-shadow: rgba(220, 20, 60, 0.6) 0 0 18px 18px;
    }
  }

  .containLogin form {
    transform: rotate(45deg);

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

  .formButton {
    margin: auto;
    text-align: center;
  }

</style>
