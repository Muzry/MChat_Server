package serverBase;

import java.util.Date;

public class Message {
	private String messageId;
	private String msg;
	private Date datetime;
	private String type;
	public Message(String msg, String type)
	{
		this.msg = msg;
		this.type = type;
		this.datetime = new Date();
	}
}
