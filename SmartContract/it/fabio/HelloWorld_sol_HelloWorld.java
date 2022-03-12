package it.fabio;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class HelloWorld_sol_HelloWorld extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040518060400160405280600d81526020017f48656c6c6f204d657373616765000000000000000000000000000000000000008152506000908051906020019061005c9291906100a3565b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506101a7565b8280546100af90610175565b90600052602060002090601f0160209004810192826100d15760008555610118565b82601f106100ea57805160ff1916838001178555610118565b82800160010185558215610118579182015b828111156101175782518255916020019190600101906100fc565b5b5090506101259190610129565b5090565b5b8082111561014257600081600090555060010161012a565b5090565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061018d57607f821691505b602082108114156101a1576101a0610146565b5b50919050565b610521806101b66000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631923be241461005157806341c0e1b51461006d5780638da5cb5b14610077578063ef5fb05b14610095575b600080fd5b61006b60048036038101906100669190610326565b6100b3565b005b6100756100c9565b005b61007f61015c565b60405161008c91906103b4565b60405180910390f35b61009d610182565b6040516100aa9190610468565b60405180910390f35b8181600091906100c4929190610214565b505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141561015a57600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b606060008054610191906104b9565b80601f01602080910402602001604051908101604052809291908181526020018280546101bd906104b9565b801561020a5780601f106101df5761010080835404028352916020019161020a565b820191906000526020600020905b8154815290600101906020018083116101ed57829003601f168201915b5050505050905090565b828054610220906104b9565b90600052602060002090601f0160209004810192826102425760008555610289565b82601f1061025b57803560ff1916838001178555610289565b82800160010185558215610289579182015b8281111561028857823582559160200191906001019061026d565b5b509050610296919061029a565b5090565b5b808211156102b357600081600090555060010161029b565b5090565b600080fd5b600080fd5b600080fd5b600080fd5b600080fd5b60008083601f8401126102e6576102e56102c1565b5b8235905067ffffffffffffffff811115610303576103026102c6565b5b60208301915083600182028301111561031f5761031e6102cb565b5b9250929050565b6000806020838503121561033d5761033c6102b7565b5b600083013567ffffffffffffffff81111561035b5761035a6102bc565b5b610367858286016102d0565b92509250509250929050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061039e82610373565b9050919050565b6103ae81610393565b82525050565b60006020820190506103c960008301846103a5565b92915050565b600081519050919050565b600082825260208201905092915050565b60005b838110156104095780820151818401526020810190506103ee565b83811115610418576000848401525b50505050565b6000601f19601f8301169050919050565b600061043a826103cf565b61044481856103da565b93506104548185602086016103eb565b61045d8161041e565b840191505092915050565b60006020820190508181036000830152610482818461042f565b905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806104d157607f821691505b602082108114156104e5576104e461048a565b5b5091905056fea264697066735822122051dd37fd39836dc344fe059dcc49da669a71f1ff9578c3cfe9cd7ae5c9e1e03864736f6c634300080c0033";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SAYHELLO = "sayHello";

    public static final String FUNC_UPDATEMESSAGE = "updateMessage";

    @Deprecated
    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> sayHello() {
        final Function function = new Function(FUNC_SAYHELLO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMessage(String _new_msg) {
        final Function function = new Function(
                FUNC_UPDATEMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_new_msg)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
