package serverBase;

import java.util.Date;

public class Message {

	String msg;
	Date datetime;
	String type;
	public Message(String msg, String type)
	{
		this.msg = msg;
		this.type = type;
		this.datetime = new Date();
	}
}
