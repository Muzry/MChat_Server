package serverBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
				public void run() {
					createMessage();
					}
				}).start();
			OutputStream output = socket.getOutputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			new Thread(new Runnable() {
				public void run() {
					try{
						String buffer;
						while(true)
						{
							BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
							buffer = strin.readLine();
							output.write(buffer.getBytes("utf-8"));
						}
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
			}).start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
