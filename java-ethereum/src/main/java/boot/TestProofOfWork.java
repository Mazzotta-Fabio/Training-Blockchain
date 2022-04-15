package boot;

import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.DatatypeConverter;


public class TestProofOfWork {

	public static void main(String[] args) throws Exception {
		MessageDigest sha256=MessageDigest.getInstance("SHA-256");
		int nonce=0;
		long secondsBefore=System.currentTimeMillis();
		while(! (DatatypeConverter.printHexBinary(sha256.digest(("buonasera a tutti, allievi OCP!!"+nonce).getBytes())).startsWith("0000000")) ) {
			nonce++;
		}
		long secondsAfter=System.currentTimeMillis();
		long durata=secondsAfter-secondsBefore;
		
		long minutes=(durata/1000)/60;
		long seconds=TimeUnit.SECONDS.toSeconds(durata);
		System.out.println("Nonce: "+nonce+"\nTempo Impiegato in secondi: "+seconds+"\nTempo in minuti: "+minutes);
	}
}
