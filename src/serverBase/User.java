package serverBase;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private String userId;
	private String userName;
	private String nickName;
	private String userIcon;
	private String sex;
	private ArrayList<User> friends;
	private HashMap<String, ArrayList<Message>> messageMap;
	
	public User(String userName, String nickName, String sex)
	{
		this.userName = userName;
		this.nickName = nickName;
		this.sex = sex;
		this.friends = new ArrayList<User>();
	}
	
	private void setMessageMap(String userName, Message message)
	{
		ArrayList<Message> msgList = this.messageMap.get(userName);
		if ( msgList == null )
		{
			msgList = new ArrayList<Message>();
		}
		msgList.add(message);
		this.messageMap.put(userName, msgList);
	}
	
	public HashMap<String,ArrayList<Message>> getMessageMap()
	{
		if (this.messageMap == null)
		{
			this.messageMap = new HashMap<String, ArrayList<Message>>();
		}
		return this.messageMap;
	}
	
	public void sendMessage(String userName, Message message)
	{
		this.setMessageMap(userName, message);
	}
}
