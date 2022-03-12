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
    public static final String BINARY = "608060405234801561001057600080fd5b506040518060400160405280600d81526020017f48656c6c6f204d657373616765000000000000000000000000000000000000008152506000908051906020019061005c9291906100a3565b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506101a7565b8280546100af90610175565b90600052602060002090601f0160209004810192826100d15760008555610118565b82601f106100ea57805160ff1916838001178555610118565b82800160010185558215610118579182015b828111156101175782518255916020019190600101906100fc565b5b5090506101259190610129565b5090565b5b8082111561014257600081600090555060010161012a565b5090565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061018d57607f821691505b602082108114156101a1576101a0610146565b5b50919050565b6105fb806101b66000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631923be241461005157806341c0e1b51461006d5780638da5cb5b14610077578063ef5fb05b14610095575b600080fd5b61006b60048036038101906100669190610415565b6100b3565b005b6100756100cd565b005b61007f610160565b60405161008c919061049f565b60405180910390f35b61009d610186565b6040516100aa9190610542565b60405180910390f35b80600090805190602001906100c9929190610218565b5050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141561015e57600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60606000805461019590610593565b80601f01602080910402602001604051908101604052809291908181526020018280546101c190610593565b801561020e5780601f106101e35761010080835404028352916020019161020e565b820191906000526020600020905b8154815290600101906020018083116101f157829003601f168201915b5050505050905090565b82805461022490610593565b90600052602060002090601f016020900481019282610246576000855561028d565b82601f1061025f57805160ff191683800117855561028d565b8280016001018555821561028d579182015b8281111561028c578251825591602001919060010190610271565b5b50905061029a919061029e565b5090565b5b808211156102b757600081600090555060010161029f565b5090565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610322826102d9565b810181811067ffffffffffffffff82111715610341576103406102ea565b5b80604052505050565b60006103546102bb565b90506103608282610319565b919050565b600067ffffffffffffffff8211156103805761037f6102ea565b5b610389826102d9565b9050602081019050919050565b82818337600083830152505050565b60006103b86103b384610365565b61034a565b9050828152602081018484840111156103d4576103d36102d4565b5b6103df848285610396565b509392505050565b600082601f8301126103fc576103fb6102cf565b5b813561040c8482602086016103a5565b91505092915050565b60006020828403121561042b5761042a6102c5565b5b600082013567ffffffffffffffff811115610449576104486102ca565b5b610455848285016103e7565b91505092915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006104898261045e565b9050919050565b6104998161047e565b82525050565b60006020820190506104b46000830184610490565b92915050565b600081519050919050565b600082825260208201905092915050565b60005b838110156104f45780820151818401526020810190506104d9565b83811115610503576000848401525b50505050565b6000610514826104ba565b61051e81856104c5565b935061052e8185602086016104d6565b610537816102d9565b840191505092915050565b6000602082019050818103600083015261055c8184610509565b905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806105ab57607f821691505b602082108114156105bf576105be610564565b5b5091905056fea264697066735822122056263b1de3db0c75d4b970629c91d0de3022e6f7a12a046a8230d18516779df564736f6c634300080c0033";

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
