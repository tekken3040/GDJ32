import java.io.*;
import java.net.*;
// import java.util.*;

class ClientThread extends Thread
{
	Socket			socket;
	MultiServer		server;
	BufferedReader	reader;
	BufferedWriter	writer;
	String			userMsg;
	String			nickName;

	public ClientThread(Socket user_socket, MultiServer main_server) throws Exception
	{
		socket = user_socket;
		server  = main_server;
             
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer  = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	// Thread run 메소드
	public void run()
	{
		try 
		{
			while((userMsg=reader.readLine()) != null)
			{
				if  (userMsg.startsWith("001"))			// Client List
				{					
					nickName=userMsg.substring(3);
					server.broadCast("002 new Client["+nickName+"]님 입장");
					server.broadClientList();
				} 
				else if(userMsg.startsWith("002"))		// Chatting 
				{    
					server.broadCast("002 "+userMsg.substring(3));
				} 
				else 
				{
				} // if 
			} // while
		} 
		catch(SocketException se)		// Client Connection Exception
		{   
			System.out.println("run:"+se);
		} 
		catch(Exception e)
		{
			System.out.println("run:"+e);
		} // try
					
		closeClient();
    }

	// 메시지 전송
	public void sendMessage(String server_message) 
	{
	   try
	   {
		   System.out.println("sendMsg:"+server_message);
		   writer.write(server_message+"\n");
		   writer.flush();
	   }
	   catch(Exception e) 
	   {
		   System.out.println("sendMessage:"+e);
	   }
	}

	// 자원 반납
	public void closeClient() 
	{
		try 
		{
			server.deleteFromServer(this);
		    writer.close();
		    reader.close();
		    socket.close();
		} 
		catch(Exception e) 
		{
			System.out.println("closeClient:"+e);
		}
	}
}