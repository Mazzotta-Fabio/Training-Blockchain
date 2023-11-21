//1.instanziamo l'oggetto per Web3 (per nodeJs)
const {Web3} = require('web3');


//2. definiamo l'indirizzo dello smart contract
const contractAddress="0x78095695CDde834012bD059377ea0AaAB314Ee90";

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

async function sendEther(){
	
	const result= await web3.eth.sendTransaction({
		from: '0xE9025196A1f31946DDF5C06F365381435FEc0eC6',
		to: contractAddress,
		value: '10000000000000000000'
	});
	console.log("hash transazione semplice:"+result.transactionHash)
	
	const signHash=await web3.eth.accounts.signTransaction({
		from:'0xE8cbE38f7E31D41Fc8776245D1A730CA422F761F',
		to:'0x7fcaE97C8ca82c12c38302FA716B35F5Af6c1700',
		value:'10000000000000000000',
		gas:'22000',
		gasPrice:'20000000000'
	},"0xa790d41fcb12c66f4ce050d144fb806c9d9a19c53da38a09ec005372f627f97d");
	
	console.log("Firma transazione di ether:"+signHash.messageHash);
	
	const transaction=await contract.methods.depositTransfer(contractAddress,4).send({from:			  "0x75291853e9Cd0ab85a66bc9974FDa214dAF77dC6"});
	console.log("hash trasferimento ad altro indirizzo da smartContract:"+transaction.transactionHash);
	
}
testSmartContractSetValue();
setTimeout(testSmartContractGetValue,2000);
setTimeout(sendEther,5000);
