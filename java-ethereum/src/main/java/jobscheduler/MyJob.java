package jobscheduler;

import java.sql.SQLException;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.http.HttpService;
import contract.HelloWorld_sol_HelloWorld;
import definergas.DefinerGas;
import gestionedb.GestoreQuery;

public class MyJob implements Job{
	
	private Logger log=Logger.getLogger("MyJob");
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("MyJob start: " + context.getFireTime());
	    JobDetail jobDetail = context.getJobDetail();
	    log.info("Example name is: " + jobDetail.getJobDataMap().getString("example"));       
	    log.info("MyJob end: " + context.getJobRunTime() + ", key: " + jobDetail.getKey());
	    log.info("MyJob next scheduled time: " + context.getNextFireTime());
	    Web3j webj=Web3j.build(new HttpService("http://localhost:7545"));
	    GestoreQuery gestore = null;
		try {
			gestore=new GestoreQuery();
			//dati utente
			Credentials credentials=Credentials.create("472bf714ed5567331687e46a7e8dc1af145f34a61f1bae4263b4b94575ce4915");
			gestore.scriviUtente("MARIO", credentials.getAddress(), webj.ethGetTransactionCount(credentials.getAddress(),DefaultBlockParameterName.LATEST).send().getTransactionCount().toString());
			//dati blocco
			Block block=webj.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send().getBlock();
			gestore.scriviBlocco(block.getNumber().toString(), block.getTransactionsRoot(), block.getStateRoot(), block.getReceiptsRoot(), block.getGasUsed(), block.getGasLimit(), block.getTimestamp(), block.getDifficulty(),block.getNonce());
			//dati contratto
			HelloWorld_sol_HelloWorld contract=HelloWorld_sol_HelloWorld.load("0x2b4F9bd6dfD5fc6b484491cf5aC19b958bb3F50E", webj, credentials, new DefinerGas());
			gestore.scriviContratto(contract.getContractAddress(), HelloWorld_sol_HelloWorld.FUNC_DEPLOY,contract.getTransactionReceipt().toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				gestore.chiudiConnessione();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
