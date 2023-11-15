//1.instanziamo l'oggetto per Web3
const {Web3} = require('web3');

//2. definiamo l'indirizzo dello smart contract
const contractAddress="0x2DeD24bC24AB1556d62eFefF48Be103B589f510C";

//3. importiamo l'abi
const contractAbi=require('./build/contracts/SimpleStorage.json');
//4. creaimo la connessione alla rete blockchain
const web3 = new Web3("http://127.0.0.1:7545");

//5. creiamo l'istanza per usare il contratto 
const contract= new web3.eth.Contract(contractAbi.abi,contractAddress);
//console.log(contract);

var value=2;
const transaction=contract.methods.set(value).send({from: "0x75291853e9Cd0ab85a66bc9974FDa214dAF77dC6"});
console.log("transazione n°"+`${transaction}`);

const valore=contract.methods.get().call();//send({from: "0x75291853e9Cd0ab85a66bc9974FDa214dAF77dC6"});
console.log("Valore presente nel contratto: "+`${value}`);

/*
$(document).ready(function(){
	$("#s").click(function(){
		
		var str=$("#fname").val();
		var value=Number(str);
		const transaction=contract.methods.set(value).send({from: "0x75291853e9Cd0ab85a66bc9974FDa214dAF77dC6"});
		alert("valore settato correttamente: "+transaction);
	});
	$("#g").click(function(){
		const valore=contract.methods.get().call();
		$("#visualizzatoDato").text(valore);
	});
});
*/


