<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/images.jpeg">
   <h1>Currency Calculator</h1>
  <div class = "container">
    <div class = "container-one">
    <select name = "first-currency" id="first-currency" v-model ="currency_one">
      <option value = "USD">USD</option> 
      <option value = "EUR">EUR</option> 
      <option value = "KRW">KRW</option>
      <option value = "DKK">DKK</option> 
      <option value = "JPY">JPY</option>
      <option value = "GBP">GBP</option>
      <option value = "AUD">AUD</option>
      <option value = "CAD">CAD</option>
      <option value = "CHF">CHF</option>
      <option value = "CNY">CNY</option>
      <option value = "HKD">HKD</option>
    </select>
    <select name = "second-currency" id = "second-currency" v-model = "currency_two">
     <option value = "USD">USD</option> 
      <option value = "EUR">EUR</option> 
      <option value = "KRW">KRW</option>
      <option value = "DKK">DKK</option> 
      <option value = "JPY">JPY</option>
      <option value = "GBP">GBP</option>
      <option value = "AUD">AUD</option>
      <option value = "CAD">CAD</option>
      <option value = "CHF">CHF</option>
      <option value = "CNY">CNY</option>
      <option value = "HKD">HKD</option>
  </select>
    <input type="number" name="input-one" id="input-one"
    v-model ="amountOne" @input="fetchData()"/>
</div>
<div class="container-two">
  <button class ="btn" @click="saveData()">Convert</button>
  <!-- <h4 id="base-value">1 {{currency_one}} = {{rate}} {{currency_two}}</h4>  -->
</div>
<div class="contatiner-three" v-if="showResults">
  <input type="number" name="amount" id="amount" placeholder = "0" disabled v-model="amountTwo"/>
</div>

<div class="container-four">
<h4 id="lastly-updated">Lastly Updated {{data.time_last_update_utc}}</h4>

</div>
  </div>
  </div>
</template>

<script>
import CurrencyService from "./services/CurrencyService";``


export default {
 data(){
   return{
     data:[],
     currency_one:"USD",
     currency_two:"EUR",
     rate:"",
     amountOne:1,
     amountTwo:0,
     showResults:false
   };

 },

 methods:{
fetchData(){
  fetch(`https://v6.exchangerate-api.com/v6/c077a29d13f697b8c3e5eb83/latest/${this.currency_one}`)
  .then(res=>res.json())
  .then(data=>{
    this.data=data;
    this.rate=data.conversion_rates[this.currency_two]; 
    this.amountTwo = this.amountOne * this.rate.toFixed(2);
  })
},
saveData(){
this.currency = {
  startingCurrency: this.currency_one,
  amount: this.amountOne, 
  endingCurrency: this.currency_two,
  exchangeRate: this.rate
}
 CurrencyService.createData(this.currency).then((respons)=> {
   if(respons.status == 200) {
     console.log(respons.data);
     alert("Data Saved!");
     this.showResults = true; 
   }
 }
 )
},
switchValues(){
  const temporaryValue = this.currency_one;
  this.currency_one = this.currency_two;
  this.currency_two = temporaryValue;
  this.fetchData();
}
},

 mounted() { //lifecycle hook 
   this.fetchData();
 } 
}
</script>

<style>
html{
  background: white;
}
#app{
display : flex;
flex-direction: column;
align-items: center;
align-content: center;
width: 100%;
height: 100%;
font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
h1{
  color: #2583ee
  
}

img{
  height: 150px;
}
.container{
  width: 50%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: center;
  text-align: center;
}
.container-two{
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 50%;
  text-align: center
}
.container-two button{
  padding: 5px;
  font-size: 15px;
  background-color:#080beb;
  color: white;
  width: 30%;
  height: 10%;
  border: none;
  outline: none;
}
select{
  padding: 5px;
  margin: 5px;
  border: 1px solid black;
  outline: none;
  text-align: center
}
input {
  padding: 5px;
  margin: 5px;
  border: 1px solid black;
  outline: none;
  font-size: 18px;
  text-align: center
}
</style>
