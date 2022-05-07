pragma solidity ^0.4.25;
/*

	pure: usato per definire dati di calcolo
	view: usato per definire variabili legate allo smart contract
	storage: usato per definire le variabili memorizzare in maniera permanente sulla blockchain
	memory: sono temporanee e vengono cancellate tra le chiamate di funzioni esterne al contratto. 
	internal equivale a private, tranne che è anche accessibile ai contratti che ereditano da questo contratto.
	external è simile a public, tranne che queste funzioni possono essere chiamate SOLO al di fuori del contratto — non possono essere chiamate da altre funzioni all'interno di quel contratto
*/
contract ZombieFactory {

    event NewZombie(uint zombieId, string name, uint dna);

    uint dnaDigits = 16;
    uint dnaModulus = 10 ** dnaDigits;

    struct Zombie {
        string name;
        uint dna;
    }

    Zombie[] public zombies;

    mapping (uint => address) public zombieToOwner;
    mapping (address => uint) ownerZombieCount;

    function _createZombie(string _name, uint _dna) internal {
        uint id = zombies.push(Zombie(_name, _dna)) - 1;
        zombieToOwner[id] = msg.sender;
        ownerZombieCount[msg.sender]++;
        emit NewZombie(id, _name, _dna);
    }

    function _generateRandomDna(string _str) private view returns (uint) {
        uint rand = uint(keccak256(abi.encodePacked(_str)));
        return rand % dnaModulus;
    }

    function createRandomZombie(string _name) public {
        require(ownerZombieCount[msg.sender] == 0);
        uint randDna = _generateRandomDna(_name);
        _createZombie(_name, randDna);
    }

}

