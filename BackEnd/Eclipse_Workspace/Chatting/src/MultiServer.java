import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer{       
       
    /*
     * 문) Vector를 주어진 코드의 전후 문맥을 고려하여 제네릭스(Generics)화 하고 Enumeration을 
     * Iterator로 교체하여 프로그램을 교정합니다. 	
     */
    ServerSocket		sc;
    Vector				clients; // 문-1) 
    ClientThread		client;
    Enumeration			clientsEn; // 문-2)


    // 메인 메소드
    public static void main(String args[]){ 
     
		 MultiServer ms=null;

		 try {
			    ms=new MultiServer();
				ms.welcomeclients();

		 } catch(Exception e){
				 System.out.println("main:"+e);
		 }
    }

    public MultiServer() throws Exception{

	   sc=new ServerSocket(7777);
       clients=new Vector(); // 문-1)
    }

    public void welcomeclients() throws Exception{

	   while(true) {
			Socket socket=sc.accept();
			client=new ClientThread(socket, this);

			addClient(client);
			client.setDaemon(true);
			client.start();               
       }
    }

    // 채팅 클라이언트 추가
    // 문-3) 문-1,2)에 따라서 아래 메서드의 인자를 다른 클래스로 변경할 수 있습니다. 
    // Hint) 문-1 의 Vector의 요소와 관련이 있습니다.
    public synchronized void addClient(Thread clientThread){

	   clients.add(clientThread); // 
       System.out.println("current clients : "+clients.size());
    }

    // 메시지 전송(멀티 에코) 
    // 문-4) 문-2) 에서 Enumeration를 Iterator로 반복자를 변경하게 되면
    // 아래의 코드도 변경해야 됩니다. Iterator에 맞게 구문을 변경하십시오. 
    public synchronized void broadCast(String message){

       // TODO
       clientsEn=clients.elements();
      
	   while(clientsEn.hasMoreElements()){
    
		  ((ClientThread)clientsEn.nextElement()).sendMessage(message);
      
	   }
    }
	
    // 메시지 전송(멀티 에코) 호출 
	public void broadClientList(){
	
	    String re="";
	
	    for(int i=0; i<clients.size(); i++)
		   re+=((ClientThread)clients.get(i)).nickName+"|";
	    
	    re=re.substring(0,re.length()-1);
 
		broadCast("001"+re);
	
	 }
		   
	 // 클라이언트 퇴장 처리
	 public synchronized void deleteFromServer(ClientThread clientThread){
	
		 clients.remove(clientThread);
		 System.out.println(clients.size()+" left in server");
	}
	 
}