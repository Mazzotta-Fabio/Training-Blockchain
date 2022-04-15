package contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class ContrattoVulnerabile_sol_ContrattoVulnerabile extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610957806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806327e235e31461005c5780632e1a7d4d1461008c5780633ccc0522146100a857806383f12fec146100d8578063ca0b187814610108575b600080fd5b6100766004803603810190610071919061055b565b610124565b60405161008391906105a1565b60405180910390f35b6100a660048036038101906100a191906105e8565b61013c565b005b6100c260048036038101906100bd919061055b565b610248565b6040516100cf91906105a1565b60405180910390f35b6100f260048036038101906100ed919061067a565b610290565b6040516100ff91906106f5565b60405180910390f35b610122600480360381019061011d9190610710565b6104ac565b005b60006020528060005260406000206000915090505481565b806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101561018757600080fd5b3373ffffffffffffffffffffffffffffffffffffffff16816040516101ab90610781565b60006040518083038185875af1925050503d80600081146101e8576040519150601f19603f3d011682016040523d82523d6000602084013e6101ed565b606091505b505050806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825461023e91906107c5565b9250508190555050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600080848490509050600083826102a791906107f9565b90506000821180156102ba575060148211155b6102c357600080fd5b6000841180156103115750806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410155b61031a57600080fd5b806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461036491906107c5565b6000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555060005b8281101561049e57846000808989858181106103c8576103c7610853565b5b90506020020160208101906103dd919061055b565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546104229190610882565b60008089898581811061043857610437610853565b5b905060200201602081019061044d919061055b565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508080610496906108d8565b9150506103a9565b506001925050509392505050565b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505050565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610528826104fd565b9050919050565b6105388161051d565b811461054357600080fd5b50565b6000813590506105558161052f565b92915050565b600060208284031215610571576105706104f3565b5b600061057f84828501610546565b91505092915050565b6000819050919050565b61059b81610588565b82525050565b60006020820190506105b66000830184610592565b92915050565b6105c581610588565b81146105d057600080fd5b50565b6000813590506105e2816105bc565b92915050565b6000602082840312156105fe576105fd6104f3565b5b600061060c848285016105d3565b91505092915050565b600080fd5b600080fd5b600080fd5b60008083601f84011261063a57610639610615565b5b8235905067ffffffffffffffff8111156106575761065661061a565b5b6020830191508360208202830111156106735761067261061f565b5b9250929050565b600080600060408486031215610693576106926104f3565b5b600084013567ffffffffffffffff8111156106b1576106b06104f8565b5b6106bd86828701610624565b935093505060206106d0868287016105d3565b9150509250925092565b60008115159050919050565b6106ef816106da565b82525050565b600060208201905061070a60008301846106e6565b92915050565b60008060408385031215610727576107266104f3565b5b600061073585828601610546565b9250506020610746858286016105d3565b9150509250929050565b600081905092915050565b50565b600061076b600083610750565b91506107768261075b565b600082019050919050565b600061078c8261075e565b9150819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006107d082610588565b91506107db83610588565b9250828210156107ee576107ed610796565b5b828203905092915050565b600061080482610588565b915061080f83610588565b9250817fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff048311821515161561084857610847610796565b5b828202905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b600061088d82610588565b915061089883610588565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff038211156108cd576108cc610796565b5b828201905092915050565b60006108e382610588565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82141561091657610915610796565b5b60018201905091905056fea26469706673582212207d3caa1f4662a939617b484d967755660f3fe2f1a0acb42c79b963d3cd6e9a8564736f6c634300080c0033";

    public static final String FUNC_ADDVALUE = "addValue";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_BATCHTRANSFER = "batchTransfer";

    public static final String FUNC_GETVALUE = "getValue";

    public static final String FUNC_WITHDRAW = "withdraw";

    @Deprecated
    protected ContrattoVulnerabile_sol_ContrattoVulnerabile(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContrattoVulnerabile_sol_ContrattoVulnerabile(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContrattoVulnerabile_sol_ContrattoVulnerabile(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContrattoVulnerabile_sol_ContrattoVulnerabile(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addValue(String addr, BigInteger value) {
        final Function function = new Function(
                FUNC_ADDVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> batchTransfer(List<String> _receivers, BigInteger _value) {
        final Function function = new Function(
                FUNC_BATCHTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_receivers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getValue(String addr) {
        final Function function = new Function(FUNC_GETVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ContrattoVulnerabile_sol_ContrattoVulnerabile load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContrattoVulnerabile_sol_ContrattoVulnerabile(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContrattoVulnerabile_sol_ContrattoVulnerabile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContrattoVulnerabile_sol_ContrattoVulnerabile(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContrattoVulnerabile_sol_ContrattoVulnerabile load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ContrattoVulnerabile_sol_ContrattoVulnerabile(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContrattoVulnerabile_sol_ContrattoVulnerabile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContrattoVulnerabile_sol_ContrattoVulnerabile(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContrattoVulnerabile_sol_ContrattoVulnerabile> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContrattoVulnerabile_sol_ContrattoVulnerabile.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContrattoVulnerabile_sol_ContrattoVulnerabile> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContrattoVulnerabile_sol_ContrattoVulnerabile.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ContrattoVulnerabile_sol_ContrattoVulnerabile> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContrattoVulnerabile_sol_ContrattoVulnerabile.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContrattoVulnerabile_sol_ContrattoVulnerabile> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContrattoVulnerabile_sol_ContrattoVulnerabile.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
