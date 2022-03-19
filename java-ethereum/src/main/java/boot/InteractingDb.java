package boot;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.http.HttpService;
public class InteractingDb {

	public static void main(String[] args) {
		System.out.println("Connecting to Ethereum ...");
		//connessione alla blockchain ethereum (nel mio caso ganache)
		Web3j web3 = Web3j.build(new HttpService("http://localhost:7545"));
		System.out.println("Successfuly connected to Ethereum");
		
		try {
			//ottenere ultimo blocco da blockchain e ne leggiamo lo stato
			Block blocco=web3.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send().getBlock();
			System.out.println("NUMERO BLOCCO: "+blocco.getNumber());
			System.out.println("HASH BLOCCO: "+blocco.getHash());
			System.out.println("HASH RADICE STATI: "+blocco.getStateRoot());
			System.out.println("HASH TRANSACTION ROOT: "+blocco.getTransactionsRoot());
			System.out.println("HASH RECEIPT ROOT: "+blocco.getReceiptsRoot());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
