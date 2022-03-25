package boot;

import java.io.File;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.Bip32ECKeyPair;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;
import contract.HelloWorld_sol_HelloWorld;
import definergas.DefinerGas;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

public class InteractingContract {

	public static void main(String[] args) {
		System.out.println("Connecting to Ethereum ...");
		//connessione alla blockchain ethereum (nel mio caso ganache)
		Web3j web3 = Web3j.build(new HttpService("http://localhost:7545"));
		System.out.println("Successfuly connected to Ethereum");
		
		try {	
			// ottiene informazioni sul tipo di client usato
		    Web3ClientVersion clientVersion = web3.web3ClientVersion().send();
		    
		    // qui restituiamo il numero di blocco più recente
		    EthBlockNumber blockNumber = web3.ethBlockNumber().send();
		    
		    // qui restituiamo il prezzo del gas
		    EthGasPrice gasPrice = web3.ethGasPrice().send();
		    
		    //qui otteniamo gli ether disponibili 
		    EthGetBalance balanceWei = web3.ethGetBalance("0xBa7AE7996419Ec6aE9115Eef82E731fb898a57B8", DefaultBlockParameterName.LATEST).send();
		    BigDecimal balanceRealWei=Convert.toWei(balanceWei.getBalance().toString(), Unit.WEI);
		    //bilancio in ether
		    BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Unit.ETHER);
		    
		    //otteniamo il numero di transazioni fatte da un account (nonce)
		    EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount("0xBa7AE7996419Ec6aE9115Eef82E731fb898a57B8", DefaultBlockParameterName.LATEST).send();
		    BigInteger nonce =  ethGetTransactionCount.getTransactionCount();
		    
		    // Print result
		    System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
		    System.out.println("Block number: " + blockNumber.getBlockNumber());
		    System.out.println("Gas price: " + gasPrice.getGasPrice());
		    System.out.println("balance in wei: " + balanceRealWei);
		    System.out.println("balance in ether: " + balanceInEther);
		    System.out.println("Nonce: "+nonce);
		    
		    //carichiamo wallet da blockchain
		    Credentials mitt=caricaWallet();
		    
		    //creiamo wallet
		    Credentials dest=creaWallet();
		    
		    //inviamo ether
		    //inviaEther(nonce,mitt,dest2,web3);
		    //invia fondi 
		    TransactionReceipt receipt=Transfer.sendFunds(web3, mitt, dest.getAddress(), BigDecimal.valueOf(1), Unit.ETHER).send();
		    EthGetBalance balanceWei2 = web3.ethGetBalance(dest.getAddress(), DefaultBlockParameterName.LATEST).send();
		    //bilancio in ether
		    BigDecimal balanceInEther2 = Convert.fromWei(balanceWei2.getBalance().toString(), Unit.ETHER);
		    System.out.println("Address: "+dest.getAddress()+" Balance: "+balanceInEther2);
		    //transazione
		    System.out.println("Hash transazione: "+receipt.getTransactionHash());
		    
		    HelloWorld_sol_HelloWorld contract=deployContract(web3);
		    System.out.println("Indirizzo contratto: "+contract.getContractAddress());
		    
		    chiamaMetodiContratto(contract);
		    
		    callEvent(contract);
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//(si può usare sendFunds() di transfer)
	private static void inviaEther(BigInteger nonce,Credentials mitt, Credentials dest,Web3j web3) throws Exception {
		//mandiamo dei fondi dall'account su ganache ad un account creato
	    //definiamo gasLimite
	    BigInteger gasLimit = BigInteger.valueOf(21000);
	    BigInteger gasPrice=Convert.toWei("1",Unit.GWEI).toBigInteger();
	    //definiamo valore
	    BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();
	    //prepariamo la transazione
	    RawTransaction rawTransaction=RawTransaction.createEtherTransaction(nonce,gasPrice,gasLimit,dest.getAddress(),value);
	    //firmiamo la transazione
	    byte [] signedMessage=TransactionEncoder.signMessage(rawTransaction, mitt);
	    //convertiamo la firma con in esadecimale in maniera tale da essere spedita al nodo
	    String hexValue=Numeric.toHexString(signedMessage);
	    /*mandiamo la transazione firmata al nodo in maniera tale che possa essere verificata da tutti i nodi.
	     * In caso di successo ci restituisce l'hash della transazione
	     */
	    EthSendTransaction ethSendTransaction=web3.ethSendRawTransaction(hexValue).send();
	    //otteniamo l'hash della transazione
	    String transactionHash=ethSendTransaction.getTransactionHash();
	    
	    //vediamo se è stata minata ed accettata dalla rete
	    Optional<TransactionReceipt> transactionReceipt=null;
	    do {
	    	EthGetTransactionReceipt ethGetTransactionReceiptResp=web3.ethGetTransactionReceipt(transactionHash).send();
	    	transactionReceipt=ethGetTransactionReceiptResp.getTransactionReceipt();
	    	//si ferma 3 secondi per l'attesa
	    	Thread.sleep(3000);
	    }while(!transactionReceipt.isPresent());
	    
	    System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
	    System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(dest.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));
	}
	
	//deploy su blockchain di uno smart contract da java
	private static HelloWorld_sol_HelloWorld deployContract(Web3j web3)throws Exception {
	    //1.carichiamo l'account per deployarlo
	    Credentials cred4=Credentials.create("94b1a6cad45134a0d792d8a74151cc9eef4f603af89c9ad8757f93f6a70c148e");
	    //2. deployiamo sull'account definito
	    HelloWorld_sol_HelloWorld contract=HelloWorld_sol_HelloWorld.deploy(web3, cred4,new DefinerGas()).send();
	    System.out.println("Indirizzo associato allo smart contract: "+contract.getContractAddress());
	    System.out.println("E' valido: "+contract.isValid());
		//3.dopo abbiamo contract che è strettamente collegato con il contratto deployato (defaultGasProvider usa il prezzo del gas definito nel codice).
	    //interagiamo con lo smart contract
	    //1.carichiamo lo smart contract deployato sulla rete
	    return HelloWorld_sol_HelloWorld.load(contract.getContractAddress(), web3, cred4, new DefinerGas());
	}
	
	
	private static void chiamaMetodiContratto(HelloWorld_sol_HelloWorld contract) throws Exception {
	    //invochiamo i metodi: quello che modifica la blockchain fa una transazione mentre quello view restituisce RemoteCall
	    TransactionReceipt tranRec=contract.updateMessage("CIAO FABIO!!!!").send();
	    System.out.println("HASH TRANSAZIONE:" +tranRec.getTransactionHash());
	    System.out.println("HASH BLOCCO:" +tranRec.getBlockHash());
	    String tranRec2=contract.sayHello().send();
	    //contract.kill().send();
	    System.out.println(tranRec2);
	}
	
	private static Credentials caricaWallet() {
	    //carichiamo un wallet tramite mnemonic phrase (che sarebbe una forma per descrivere la chiave privata)
	    String password=null;//possiamo opzionalmente cifrare con una password
	    String mnemonic="assault hazard explain column old tired will silk choose clever empower degree";
	    //CREDENTIALS: oggetto usato per firmare e fare transazioni sulla blockchain Ethereum
	    Credentials credentials=WalletUtils.loadBip39Credentials(password, mnemonic);
	    
	    
	    //qui usiamo il derivation path m/44'/60'/0'/0/{account_index}
	    int []deviationPath= {44 |Bip32ECKeyPair.HARDENED_BIT,60|Bip32ECKeyPair.HARDENED_BIT,0|Bip32ECKeyPair.HARDENED_BIT,0,1};
	    //generiamo chiavi da mnemonic
	    Bip32ECKeyPair masterKeyPair = Bip32ECKeyPair.generateKeyPair(MnemonicUtils.generateSeed(mnemonic, password));
	    //deriviamo chiavi usando il derivation path
	    Bip32ECKeyPair derivedKeyPair=Bip32ECKeyPair.deriveKeyPair(masterKeyPair, deviationPath);
	    //carichiamo il wallet per le chiavi derivate
	    Credentials cred=Credentials.create(derivedKeyPair);
	     
	    //da una chiave privata
	    String pk="76367b09e2ea0c33489f19146c6cbdd20a5257ce689bdf61cbfdca967621213f";
	    Credentials cred3=Credentials.create(pk);
	    
	    System.out.println("Indirizzo tramite mnemonic phrase:"+credentials.getAddress());
	    System.out.println("Indirizzo tramite derivation path: "+cred.getAddress());
	    System.out.println("Indirizzo tramite chiave privata: "+cred3.getAddress());
	    
	    return cred3;
	}
	
	private static Credentials creaWallet() throws Exception {
	    //creaiamo un nuovo wallet(Wallet Utils: da un JSON per le chiavi)
	    String walletPass="secr3t";
	    String walletDirectory="wallet/walletPersonal";
	    String walletName=WalletUtils.generateLightNewWalletFile(walletPass, new File(walletDirectory));
	    Credentials cred2=WalletUtils.loadCredentials(walletPass, walletDirectory+"/"+walletName);
	    System.out.println("Indirizzo del wallet creato: "+cred2.getAddress());
	    System.out.println("walletName: "+walletName);
	    return cred2;
	}
	
	//chiamiamo eventi
	private static void callEvent(HelloWorld_sol_HelloWorld contract) {
		/*
		 * gli eventi vengono chiamati con il pattern <event-name>EventFlowable. Questo metodo prende l'inizio e la fine del blocco.
		 * con latest si dice a web3j di continuare glli eventi per i nuovi blocchi.
		 * se si vuole richiedere uno specifico range di blocchi si può usare DefaultBlockParameter.valueOf(BigInteger.valueOf(...))
		 * Restituisce un oggetto flowable che può essere sottoscritto per gestire gli eventi
		 */
		contract.depositEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST).
			subscribe(event->{String user=event.user;
							  String message=event.message;
							  BigInteger difficult=event.difficult;
							  System.out.println("USER EVENT: "+user+" MESSAGE: "+message+" DIFFICOLTA': "+difficult);});
		
		
		//qui facciamo un filtro per ascoltare gli eventi su un determinato indirizzo di contratto
		EthFilter ethFilter=new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST,contract.getContractAddress());
		//questo filtro è definito sempre come keccak hash della firma dell'evento
		ethFilter.addSingleTopic(EventEncoder.encode(contract.DEPOSIT_EVENT));
		//usato per creare il parametro da matchare in maniera tale che sia conforme a come è definito nell'evento. 
		//p.s usiamo type encoder per costruire opportunamente il parametro
		ethFilter.addOptionalTopics("0x"+TypeEncoder.encode(new Address("A20f1c21c5550376eb2515761616c53e7be83be7")));
		contract.depositEventFlowable(ethFilter).
		subscribe(event->{String user=event.user;
						  String message=event.message;
						  BigInteger difficult=event.time;
						  System.out.println("USER EVENT: "+user+" MESSAGE: "+message+" TIME': "+difficult);});
	}
}
