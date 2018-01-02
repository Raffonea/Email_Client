import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Client.AddressBook;
import Client.CmdLoop;
import Client.Contact;
import Client.MailClient;

public class Main {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		System.out.println("Enter User Information:");
		System.out.println("Email Address(must contain '@'): ");
		String _address = a.nextLine();
		System.out.println("Your full name: ");
		String _fullName = a.nextLine();
		System.out.println("Your nick name: ");
		String _nickName = a.nextLine();
		Contact c1 = new Contact(_address, _fullName, _nickName);
		System.out.println(c1);
		MailClient mc1 = new MailClient(c1);
		CmdLoop cmd1 = new CmdLoop(mc1);
		cmd1.run();
	}
}
