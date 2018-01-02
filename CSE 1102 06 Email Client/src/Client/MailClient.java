package Client;

public class MailClient {
	Contact user;
	AddressBook myAddressBook = new AddressBook();
	MailBox inComing = new MailBox();
	MailBox outGoing = new MailBox();
	
	public MailClient(Contact _userInfo){
		user = _userInfo;
	}
	
	public void addToInBox(Message _message){
		inComing.add(_message);
	}
	
	public void addToOutBox(Message _message){
		outGoing.add(_message);
	}
	
	public MailBox getInBox(){
		return inComing;
	}
	
	public MailBox getOutBox(){
		return outGoing;
	}
	
	public Contact getMyAddress(){
		return user;
	}
	
	public Contact searchForContact(String _nickName){
		return myAddressBook.search(_nickName);
	}
	
	public AddressBook getAddressBook(){
		return myAddressBook;
	}
	
}
