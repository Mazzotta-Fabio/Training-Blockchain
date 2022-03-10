pragma solidity ^0.8.12;

contract HelloWorld{

    //struttura (simili a quello del C)
    struct Message{
        uint intero;
        uint nonIntero;
    }

    string helloMessage;
    address payable public owner;

    constructor () {
        helloMessage="Hello Message";
        owner=payable(msg.sender);
    }
    /*
        colui che lo invoca permette al chiamante di cambiare messaggio.
        Ovviamente deve essere approvata.
        Questo pezzo di codice è detto a consenso perchè deve essere approvata da tutta la rete
        memory: usato per salvare valori sulla blockchain
    */
    function updateMessage (string memory _new_msg)  public{
        helloMessage=_new_msg;
    }

    /*
        restituisce un messaggio di benvenuto.
        è un metodo che non cambia lo stato dello smart contract e può essere eseguito senza commissioni
        questo codice è detto a non consenso
        view: usato per definire funzioni che non fanno modifiche
    */
    function sayHello() public view returns (string memory){
        return helloMessage;
    }

    function kill()  public {
        if (msg.sender==owner) selfdestruct(owner);
    }

    /*
    pure: usato per non leggere valori che usano la blockchain
    payable: funzioni che possono ricevere pagamenti. questa funzione richiede automaticamente il consenso.
    può essere richiamata solo tramite una transazione che viene registrata nella blockchaintr

    */
}