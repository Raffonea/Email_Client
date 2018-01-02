package Client;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Message{
	Contact to, from;
	String subject, body;
	Date time = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	String DateToStr = format.format(time);
	
	public Message(Contact _to, Contact _from, String _subject, String _body){
		to = _to;
		from = _from;
		subject = _subject;
		body = _body;
	}
	
	public void show(){
		System.out.println("Date: " + DateToStr);
		System.out.println("From: " + from);
		System.out.println("Subj: " + subject);
		System.out.println(body);
	}
	
	public String toString(){
		return ("From: " + from + ", " + "To: " + to + ", " + "Subj: " + subject + " Date: " + DateToStr);
	}
}
