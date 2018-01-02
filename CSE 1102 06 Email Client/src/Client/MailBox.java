package Client;

import java.util.ArrayList;

public class MailBox {
	ArrayList<Message> messageList = new ArrayList<Message>();
	
	public void add(Message _message){
		messageList.add(_message);
	}
	
	public int count(){
		return messageList.size();	
	}
	
	public Message getMessage(int _index){
		return messageList.get(_index);
	}
	
	public Message remove(int _index){
		Message removedMessage = getMessage(_index);
		messageList.remove(removedMessage);
		return removedMessage;
	}
	
	public void show(){
		int count=1;
		for(Message i: messageList){
			System.out.println(count + ". " + i);
			count++;
		}
		if (count == 1)	
			System.out.println("This is empty!");
	}
}
