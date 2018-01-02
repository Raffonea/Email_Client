package Client;
import java.util.ArrayList;


public class AddressBook {
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	public void add(Contact _contact){
		contactList.add(_contact);
	}
	public void remove(String _nickName){
		contactList.remove(search(_nickName));
	}
	public Contact search(String _nickName){
		Contact c = null;
		for(Contact i: contactList){
			if (i.toString().contains(_nickName)){
				c = i;
				break;
			}
		}
		return c;
	}
	public void show(){
		int count=1;
		for(Contact i: contactList){
		System.out.println(count + ". " + i);
		count++;
		}
		if (count == 1)
			System.out.println("Your Address Book is empty!");
	}
}
