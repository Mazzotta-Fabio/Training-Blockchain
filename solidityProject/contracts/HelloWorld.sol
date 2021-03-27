pragma solidity >=0.4.22 <0.9.0;

contract HelloWorld{
    
    string  public helloMessage;
    address public owner;
    
    constructor () public{
        helloMessage = "Hello World!";
        owner=msg.sender;
    }
    
    function updateMessage(string  memory _new_msg) public{
        helloMessage=_new_msg;
    }
    
    function sayHello () public view returns (string memory){
        return helloMessage;
    }
    /*
    function kill()public {
        if (msg.sender==owner)selfdestruct(owner);
    }
	*/
}