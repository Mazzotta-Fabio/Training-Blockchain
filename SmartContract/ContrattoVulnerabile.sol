pragma solidity ^0.8.12;

contract ContrattoVulnerabile {

    mapping(address => uint) public balances;

    //Chiamata rientrante
    function withdraw(uint _amount)public {
        require(balances[msg.sender]>=_amount);
        msg.sender.call{value: _amount}("");
        balances[msg.sender]-=_amount;
    }
    
    //integer overflow
    function batchTransfer(address[] calldata _receivers,uint256 _value) public returns (bool){
        uint cnt=_receivers.length;
        uint256 amount=uint256(cnt)* _value; //OVERFLOW
        require(cnt>0 && cnt <=20);
        require(_value>0 && balances[msg.sender]>=amount);
        balances[msg.sender]=balances[msg.sender]-amount;
        for(uint i=0; i<cnt;i++){
            balances[_receivers[i]]=balances[_receivers[i]]+_value;
        }
        return true;
    }

    function addValue(address addr, uint256 value)public {
        balances[addr]=value;
    }

    /*
     storage - variable is a state variable (store on blockchain)
        memory - variable is in memory and it exists while a function is being called
        calldata - special data location that contains function arguments, only available for external functions
    */
    function getValue(address addr) public view returns (uint256 ){
        return balances[addr];
    }
}