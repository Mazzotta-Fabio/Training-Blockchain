//questo file serve a truffle per pubblicare il contratto sulla blockchain

var SimpleStorage=artifacts.require("SimpleStorage.sol");

module.exports=function(deployer){
	deployer.deploy(SimpleStorage);
}