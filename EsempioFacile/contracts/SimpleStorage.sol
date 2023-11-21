pragma solidity >=0.4.16 <0.9.0;

contract SimpleStorage {
    uint storedData;
	
	//funzione fallback per ricevere ether da fonti esterne
	receive() external payable {}
			
	function depositTransfer(address payable _to, uint256 _amount) public{
			_to.transfer(_amount);
	}
	
    function set(uint x) public {
        storedData = x;
    }

    function get() public view returns (uint) {
        return storedData;
    }
}