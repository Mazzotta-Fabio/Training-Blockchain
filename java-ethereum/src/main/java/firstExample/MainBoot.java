package firstExample;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import org.web3j.contracts.token.ERC20Interface;
import org.web3j.crypto.Bip32ECKeyPair;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

import it.fabio.HelloWorld_sol_HelloWorld;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

public class MainBoot {

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
		    /*
		    
		    // qui restituiamo il prezzo del gas
		    EthGasPrice gasPrice = web3.ethGasPrice().send();
		    
		    
		    //qui otteniamo gli ether disponibili 
		    EthGetBalance balanceWei = web3.ethGetBalance("0xfD0674C50fBb0f829C7C2c6Bd8c8a37151a1dA5A", DefaultBlockParameterName.LATEST).send();
		    BigDecimal balanceRealWei=Convert.toWei(balanceWei.getBalance().toString(), Unit.WEI);
		    //bilancio in ether
		    BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Unit.ETHER);
		    
		    
		    //otteniamo il numero di transazioni fatte da un account (nonce)
		    EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount("0x558068aa0e07784e42a31645c699CD2B617Bd7fC", DefaultBlockParameterName.LATEST).send();
		    BigInteger nonce =  ethGetTransactionCount.getTransactionCount();
		    
		    
		    //carichiamo un wallet tramite mnemonic phrase (che sarebbe una forma per descrivere la chiave privata)
		    String password=null;//possiamo opzionalmente cifrare con una password
		    String mnemonic="toss ridge mimic turkey game autumn image where earth bench fade adapt";
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
		    
		    //qui usiamo la chiave privata per caricare l'account
		    String key="0x5be021305e6621853a1712136b57307d30ec88b3167d86f5e88e73a021a60937";
		    Credentials cred3=Credentials.create(key);
		    
		    
		    //creaiamo un nuovo wallet(Wallet Utils: da un JSON per le chiavi)
		    String walletPass="secr3t";
		    String walletDirectory="wallet/walletPersonal";
		    String walletName=WalletUtils.generateLightNewWalletFile(walletPass, new File(walletDirectory));
		    Credentials cred2=WalletUtils.loadCredentials(walletPass, walletDirectory+"/"+walletName);
		    
		    
		    //mandiamo dei fondi dall'account su ganache ad un account creato
		    //definiamo gasLimite
		    BigInteger gasLimit = BigInteger.valueOf(6721975);
		    //definiamo valore
		    BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();
		    //prepariamo la transazione
		    RawTransaction rawTransaction=RawTransaction.createEtherTransaction(nonce,gasPrice.getGasPrice(),gasLimit,cred2.getAddress(),value);
		    //firmiamo la transazione
		    byte [] signedMessage=TransactionEncoder.signMessage(rawTransaction, cred3);
		    //convertiamo la firma con in esadecimale in maniera tale da essere spedita al nodo
		    String hexValue=Numeric.toHexString(signedMessage);
		    /*mandiamo la transazione firmata al nodo in maniera tale che possa essere verificata da tutti i nodi.
		     * In caso di successo ci restituisce l'hash della transazione
		     */
			/*
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
		    
		    */
			
		    //deploy su blockchain di uno smart contract da java
		    //1.carichiamo l'account dove deployarlo
		    Credentials cred4=Credentials.create("54589c347f07f5d186bb9f83f00b09d93b648d95196e97a4c987b4316d39d333");
		    //2. deployiamo sull'account definito
		    //HelloWorld_sol_HelloWorld contract=HelloWorld_sol_HelloWorld.deploy(web3, cred4,new DefaultGasProvider()).send();
		    //System.out.println("Indirizzo associato allo smart contract: "+contract.getContractAddress());
		    //System.out.println("E' valido: "+contract.isValid());
			//3.dopo abbiamo contract che è strettamente collegato con il contratto deployato (defaultGasProvider usa il prezzo del gas definito nel codice).
		    //interagiamo con lo smart contract
		    //1.carichiamo lo smart contract deployato sulla rete
		    HelloWorld_sol_HelloWorld contract2=HelloWorld_sol_HelloWorld.load(cred4.getAddress(), web3, cred4, new DefaultGasProvider());
		    //invochiamo i metodi: quelo che modifica la blockchain fa una transazione mentre quello view restituisce RemoteCall
		    TransactionReceipt tranRec=contract2.updateMessage("CIAO FABIO!!!!").send();
		    
		    System.out.println("HASH TRANSAZIONE:" +tranRec.getTransactionHash());
		    System.out.println("HASH BLOCCO:" +tranRec.getBlockHash());
		    String tranRec2=contract2.sayHello().send();
		    System.out.println(tranRec2);
		    /*
		    // Print result
		    System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
		    System.out.println("Block number: " + blockNumber.getBlockNumber());
		    System.out.println("Gas price: " + gasPrice.getGasPrice());
		    System.out.println("balance in wei: " + balanceRealWei);
		    System.out.println("balance in ether: " + balanceInEther);
		    System.out.println("Nonce: "+nonce);
		    System.out.println("Indirizzo:"+credentials.getAddress());
		    System.out.println("Indirizzo generato: "+cred.getAddress());
		    System.out.println("Indirizzo del wallet creato: "+cred2.getAddress());
		    System.out.println("walletName: "+walletName);
		    System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
		    System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(cred2.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));
		    */
		    
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
