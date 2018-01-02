package Client;

public class Contact {
	String address, fullName, nickName;
	
	public Contact(String _address, String _fullName, String _nickName){
		address = _address;
		fullName = _fullName;
		nickName = _nickName;
	}
	public Contact(String _address){
		_address = address;
	}
	public String toString(){
		return (fullName + " (" + nickName + ") <" + address + ">");
	}
}
