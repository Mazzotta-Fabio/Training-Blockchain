package definergas;

import java.math.BigInteger;

import org.web3j.tx.gas.ContractGasProvider;

//classe che viene usata per definire il gas. Deve implementare l'interfaccia ContractGasProvider
//se non si vuole usare una classe propria si può usare - new DefaultGasProvider - se questa classe da problemi la si deve creare
public class DefinerGas implements ContractGasProvider {
	
	private BigInteger gasLimit;
	private BigInteger gasPrice;
	
	public DefinerGas() {
		gasLimit=BigInteger.valueOf(6721975);
		gasPrice=BigInteger.valueOf(2000000);
	}
	@Override
	public BigInteger getGasPrice(String contractFunc) {
		// TODO Auto-generated method stub
		return gasPrice;
	}

	@Override
	public BigInteger getGasPrice() {
		// TODO Auto-generated method stub
		return gasPrice;
	}

	@Override
	public BigInteger getGasLimit(String contractFunc) {
		// TODO Auto-generated method stub
		return gasLimit;
	}

	@Override
	public BigInteger getGasLimit() {
		return gasLimit;
	}

}
