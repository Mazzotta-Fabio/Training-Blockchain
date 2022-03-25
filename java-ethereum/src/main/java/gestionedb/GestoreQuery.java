package gestionedb;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class GestoreQuery {
	
	private Logger log;
	private Connection connection;
	
	public GestoreQuery() throws SQLException {
		log=Logger.getLogger("gestore");
		connection=DriverConnection.getConnection();
	}
	
	public boolean scriviBlocco(String numeroBlocco,String transactionRoot,String stateRoot,String receiptRoot,BigInteger gasPrice,BigInteger gasLimit,BigInteger timestamp,BigInteger difficolta,BigInteger nonce) throws SQLException {
		log.info("Sto scrivendo il blocco nel DB");
		String queryControllo="select * from blocco where numero_blocco="+numeroBlocco;
		String queryInsert="insert into blocco (Numero_blocco,Transaction_root,state_root,Receipt_root,Gas_price,Gas_limit,Timestamp,Difficolta,Nonce) values ('"+numeroBlocco+"','"+transactionRoot+"','"+stateRoot+"','"+receiptRoot+"','"+gasPrice+"','"+gasLimit+"','"+timestamp+"','"+difficolta+"','"+nonce+"')";
		String queryUpdate="update blocco set Transaction_root='"+transactionRoot+"',state_root='"+stateRoot+"',Receipt_root='"+receiptRoot+"',Gas_price='"+gasPrice+"',Gas_limit='"+gasLimit+"',Timestamp='"+timestamp+"',Difficolta='"+difficolta+"',Nonce='"+nonce+"' where Numero_blocco="+numeroBlocco;
		return faiQuery(queryControllo, queryInsert, queryUpdate);
	}

	public boolean scriviContratto(String indirizzo, String metodoInvocato, String nomeContratto) throws SQLException {
		log.info("Sto scrivendo il contratto nel DB");
		String queryControllo="select * from contratto where Indirizzo='"+indirizzo+"'";
		String queryUpdate="update contratto set Nome='"+nomeContratto+"' , Metodo_invocato='"+metodoInvocato+"' where Indirizzo='"+indirizzo+"'";
		String queryInsert="insert into contratto (Nome,Metodo_invocato,Indirizzo) values ('"+nomeContratto+"','"+metodoInvocato+"','"+indirizzo+"')";
		return faiQuery(queryControllo, queryInsert, queryUpdate);
	}
	
	public boolean scriviUtente(String nome,String indirizzo,String transazioniEffettuate) throws SQLException {
		log.info("Sto scrivendo l'utente nel DB");
		String queryControllo="select * from utente where Indirizzo='"+indirizzo+"'";
		String queryInsert="insert into utente (Nome,Transazione_Effettuate,Indirizzo) values ('"+nome+"','"+transazioniEffettuate+"','"+indirizzo+"')";
		String queryUpdate="update utente set Nome='"+nome+"',Transazione_effettuate="+transazioniEffettuate+" where Indirizzo='"+indirizzo+"'";
		return faiQuery(queryControllo, queryInsert, queryUpdate);
	}
	
	private boolean faiQuery(String queryControllo, String queryInsert,String queryUpdate) throws SQLException {
		log.info("sto eseguendo la query "+queryControllo);
		Statement stat=connection.createStatement();
		if(stat.execute(queryControllo)) {
			log.info(queryUpdate);
			return stat.execute(queryUpdate);
		}
		else {
			log.info(queryInsert);
			return stat.execute(queryInsert);
		}
	}
	public void chiudiConnessione() throws SQLException {
		DriverConnection.releaseConnection(connection);
	}
}
