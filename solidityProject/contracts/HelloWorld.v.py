#variabili di stato
helloMessage:public(bytes32)
owner:public(address)

@public
def __init__(_message: bytes32):
    self.helloMessage=_message
    self.owner=msg.sender

@public
def updateMessage(newMsg:bytes32):
    self.helloMessage=newMsg

@public
@constant
def sayHello() -> bytes32:
    return self.helloMessage

@public
def kill():
    if msg.sender == self.owner:
        selfdestruct(self.owner)