package serverBase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Server {
	
	private static ServerSocket serverSocket;
	
	public Gson gson = new Gson();
	
	public void initServer()
	{
		try{
			serverSocket = new ServerSocket(SocketUrls.PORT);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void createMessage()
	{
		try
		{
			System.out.println("等待用户接入: ");
			Socket socket = serverSocket.accept();
			
			System.out.println("用户接入: " + socket.getPort());
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					createMessage();
					}
				}).start();;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
