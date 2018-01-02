package Client;

import java.util.Scanner;

public class CmdLoop {
	MailClient EmailService;
	Scanner a = new Scanner(System.in);
	Scanner b = new Scanner(System.in);
	Scanner c = new Scanner(System.in);
	Scanner d = new Scanner(System.in);

	public CmdLoop(MailClient _mailClient){
		EmailService = _mailClient;
	}

	public void run(){
		System.out.print("Enter Command(h for help):");
		String cmd = a.next();
		while (cmd!="q"){
			if (cmd.equals("q")){
				System.out.println("QUITTER");
				break;
			}
			else if (cmd.equals("h")){
				helpMenu();
			}
			else if (cmd.equals("la")){
				listaddressbook();
			}
			else if (cmd.equals("li")){
				listInbox();
			}
			else if (cmd.equals("lo")){
				listOutBox();
			}
			else if (cmd.equals("aa")){
				addAddressBook();
			}
			else if (cmd.equals("da")){
				deleteAddressBook();
			}
			else if (cmd.equals("cm")){
				composeMessage();
			}
			else if (cmd.equals("ro")){
				readOutboxMessage();
			}
			else if (cmd.equals("do")){
				deleteFromOutbox();
			}
			else if (cmd.equals("sr")){
				sendReceive();
			}
			else if (cmd.equals("ri")){
				readInboxMessage();
			}
			else if (cmd.equals("di")){
				deleteFromInbox();
			}
			else if (cmd.equals("")){
				System.out.println("");
			}
			else{
				System.out.println("Not Understood, type h for help");
			}
			System.out.print("Enter Command(h for help):");
			cmd = a.next();
		}
	}

	private void helpMenu(){
		System.out.println("Enter One of the following:");
		System.out.println("la: List address book");
		System.out.println("li: List Inbox");
		System.out.println("lo: List Outbox");
		System.out.println("aa: Add to address book");
		System.out.println("da: Delete from address book");
		System.out.println("cm: Compose Message");
		System.out.println("ro: Read from outbox");
		System.out.println("do: Delete from outbox");
		System.out.println("sr: Send Receive");
		System.out.println("ri: Read inbox message");
		System.out.println("di: Delete from inbox");
	}
	private void listaddressbook(){
		AddressBook _myAddressBook = EmailService.getAddressBook();
		_myAddressBook.show();
	}
	private void listInbox(){
		MailBox _myInbox = EmailService.getInBox();
		_myInbox.show();
	}
	private void listOutBox(){
		MailBox _myOutBox = EmailService.getOutBox();
		_myOutBox.show();
	}
	private void addAddressBook(){
		AddressBook _myAddressBook = EmailService.getAddressBook();
		System.out.println("Email Address: ");
		String _address = c.nextLine();
		System.out.println("Full name: ");
		String _fullName = d.nextLine();
		System.out.println("nickName: ");
		String _nickName = b.next();
		Contact _newContact = new Contact(_address, _fullName, _nickName);
		_myAddressBook.add(_newContact);
		System.out.println(_nickName + " has been added to your address book!");
	}
	private void deleteAddressBook(){
		System.out.println("What nick name do you want to delete?: ");
		String _nickName = b.next();
		AddressBook _myAddressBook = EmailService.getAddressBook();
		Contact c = _myAddressBook.search(_nickName);
		if (c == null){
			System.out.println("nick name cannot be found");
		}
		else{
			System.out.println(_nickName + " was deleted from AddressBook");
			_myAddressBook.remove(_nickName);
		}

	}
	private void composeMessage(){
		System.out.print("Enter email address OR nick name: ");
		String recipient = b.next();

		Contact to, from = EmailService.getMyAddress();
		Message m;
		AddressBook _myAddressBook = EmailService.getAddressBook();

		if(recipient.contains("@"))
		{
			System.out.print("Subject: ");
			String subj = c.nextLine();

			System.out.print("Message: ");
			String body = d.nextLine();

			to = new Contact(recipient);
			m = new Message(to, from, subj, body);
			EmailService.addToOutBox(m);
			System.out.println("Message Sent!");
		}
		else if(_myAddressBook.search(recipient) != null)
		{
			System.out.print("Subject: ");
			String subj = c.nextLine();

			System.out.print("Message: ");
			String body = d.nextLine();

			to = _myAddressBook.search(recipient);
			m = new Message(to, from, subj, body);
			EmailService.addToOutBox(m);
			System.out.println("Message Sent!");
		}
		else
			System.out.println("Could not find recipient in addressbook.");

	}
	private void readOutboxMessage(){
		MailBox _outbox = EmailService.getOutBox();
		if (_outbox.count() > 0){
			System.out.println("Enter a message number");
			int _message = a.nextInt();
			if (_message <= _outbox.count()){
				_message --;
				Message m = _outbox.getMessage(_message);
				m.show();
			}
			else if(_message > _outbox.count()){
				System.out.println("Message number " + _message + " Cannot be found");
			}
		}
		else{
			System.out.println("Outbox empty.");
		}
	}
	private void deleteFromOutbox(){
		MailBox _outbox = EmailService.getOutBox();
		if (_outbox.count() > 0){
			System.out.println("Enter a message number");
			int _message = a.nextInt();
			if (_message <= _outbox.count()){
				System.out.println("Message number " + _message + " has been deleted");
				_message --;
				_outbox.remove(_message);
			}
			else if (_message > _outbox.count()){
				System.out.println("Message number " + _message + " Cannot be found");
			}
		}
		else{
			System.out.println("Outbox empty.");
		}
	}
	private void sendReceive(){
		MailBox _outbox = EmailService.getOutBox();
		MailBox _inbox = EmailService. getInBox();
		if (_outbox.count() >= 1){
		for (int i=0; i<= _outbox.count(); i++){
			_inbox.add(_outbox.getMessage(i));
			_outbox.remove(i);
		} 
		System.out.println("All messages have been moved from the outbox to the inbox!");
		}
		else
			System.out.println("No messages to move");
	}
	private void readInboxMessage(){
		MailBox _inbox = EmailService.getInBox();
		if (_inbox.count() > 0){
			System.out.println("Enter a message number");
			int _message = a.nextInt();
			if (_message <= _inbox.count()){
				_message --;
				Message m = _inbox.getMessage(_message);
				m.show();
			}
			else if(_message > _inbox.count()){
				_message --;
				System.out.println("Message number " + _message + " Cannot be found");
			}
		}
		else{
			System.out.println("Inbox empty.");
		}
	}
	private void deleteFromInbox(){
		MailBox _inbox = EmailService.getInBox();
		if (_inbox.count() > 0){
			System.out.println("Enter a message number");
			int _message = a.nextInt();
			if (_message <= _inbox.count()){
				System.out.println("Message number " + _message + " has been deleted");
				_message --;
				_inbox.remove(_message);
			}
			else if (_message > _inbox.count()){
				System.out.println("Message number " + _message + " Cannot be found");
			}
		}
		else{
			System.out.println("Inbox empty.");
		}
	}
}
