//1.instanziamo l'oggetto per Web3 (per nodeJs)
const {Web3} = require('web3');


//2. definiamo l'indirizzo dello smart contract
const contractAddress="0x2DeD24bC24AB1556d62eFefF48Be103B589f510C";

//3. importiamo l'abi (per nodeJs)
const contractAbi=require('./build/contracts/SimpleStorage.json');
//import contractAbi from './build/contracts/SimpleStorage.json' assert {type:'json'};

//4. creaimo la connessione alla rete blockchain
const web3 = new Web3("http://127.0.0.1:7545");

//5. creiamo l'istanza per usare il contratto 
const contract= new web3.eth.Contract(contractAbi.abi,contractAddress);
//console.log(contract);


async function testSmartContractSetValue(){
	var value=180;
	/*in questo caso si usa await perchè call è asincrona e restituisce un promise
	  Così per ottenere la risposta attuale, await ferma l'esecuzione fin quando call non restituisce il valore
	*/
	const transaction=await contract.methods.set(value).send({from: "0x75291853e9Cd0ab85a66bc9974FDa214dAF77dC6"});
	console.log("Transazione: "+transaction.transactionHash);
	
}
async function testSmartContractGetValue(){
	const valore=await contract.methods.get().call();
	console.log("Valore sullo smartContract: "+parseInt(valore));
}

testSmartContractSetValue();
setTimeout(testSmartContractGetValue,2000);