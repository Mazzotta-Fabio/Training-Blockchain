package boot;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import contract.ContrattoVulnerabile_sol_ContrattoVulnerabile;
import definergas.DefinerGas;

public class BootVulnerabilita {

	public static void main(String[] args) throws Exception {
		System.out.println("Connecting to Ethereum ...");
		//connessione alla blockchain ethereum (nel mio caso ganache)
		Web3j web3 = Web3j.build(new HttpService("http://localhost:7545"));
		System.out.println("Successfuly connected to Ethereum");
		
		Credentials cred4=Credentials.create("3207bf068415d45c104d494a8c3c7fdfec908299aca1ddf275a1016827dd85fa");
		
		ContrattoVulnerabile_sol_ContrattoVulnerabile contrattoVulnerabile=ContrattoVulnerabile_sol_ContrattoVulnerabile.deploy(web3, cred4, new DefinerGas()).send();
		contrattoVulnerabile.addValue("0xeb971A450aB02aAb3eF9386A1F507FF0DDD0EBd8", BigInteger.valueOf(10000000)).send();
		System.out.println(contrattoVulnerabile.getValue("0xeb971A450aB02aAb3eF9386A1F507FF0DDD0EBd8").send());
		
	}

}
