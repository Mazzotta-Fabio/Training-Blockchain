package firstExample;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
public class MainBoot {

	public static void main(String[] args) {
		System.out.println("Connecting to Ethereum ...");
		//connessione alla blockchain ethereum (nel mio caso ganache)
		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
		System.out.println("Successfuly connected to Ethereum");
		
		try {
			// ottiene informazioni sul tipo di client usato
		    Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

		    // qui restituiamo il numero di blocco più recente
		    EthBlockNumber blockNumber = web3.ethBlockNumber().send();

		    // qui restituiamo il prezzo del gas
		    EthGasPrice gasPrice = web3.ethGasPrice().send();

		    // Print result
		    System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
		      System.out.println("Block number: " + blockNumber.getBlockNumber());
		      System.out.println("Gas price: " + gasPrice.getGasPrice());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
