<template>
  <div id="divGlobal">


  <div id="central">
    <div id="divLogo">
      <div id="logo">
        D Market
      </div>
    </div>
  </div>
  </div>
</template>

<script>
  const items = [
    { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
    { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
    { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson' },
    { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
  ]

  export default {
    name:'Hello',
    data () {
      return {
        items: items
      }
    }
  }
</script>
<style>
 #divGlobal{
    background-image: url("../assets/home.jpg");
    background-size: cover;
    position: fixed;

    width: 100%;
    height: 100%;
    padding-top: 2%;

  }
  #central{
    background-color: rgba(255,255,255,0.5);
    width: 70%;
    height: 60%;
    margin:auto;
    margin-top: 5%;
  }
  #logo{
    background-image: url("../assets/bag.png");
    background-repeat: no-repeat;
    position:  absolute;
    padding-top: 5%;
    width: 50%;
    height: 50%;


  }

  #divLogo{
    padding-top: 5%;
    font-family: CoronetPS;
    font-size: 120px;
    width: 50%;
    height: 50%;
    margin: auto;
    color: black;

  }

 #divLogo font{
   animation: pulse 0.8s infinite;
   animation-direction: alternate;
   -webkit-animation-name: pulse;
   animation-name: pulse;
 }
 @keyframes pulse {
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
</style>
<!-- table-basic-1.vue -->

