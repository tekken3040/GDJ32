import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketServer 
{ 
    public static void main(String args[]) throws IOException
    {
        // 문제-1) TCP 서버 소켓 객체(인스턴스) serverSocket 를 초기화 합니다.
        ServerSocket socket = null;
        // 문제-2) try ~ catch 형태로 IOException 예외처리 클래스로 예외처리를 하고 
        // 에러 로그 메시지는 getMessage메서드를 활용하여 간단히 출력될 수 있도록 조치합니다.
        // 서버 소켓을 8888번 포트로 결합(bind)하여 생성시킵니다.
        try 
        {
            socket = new ServerSocket();
            socket.bind(new InetSocketAddress("localhost", 8888));
        } 
        catch (IOException e) 
        {
            // 문제-3) 여기서 할 수 있으면 리플렉션(reflection)을 활용하여 예외처리 메시징을 할 때 
            // 예외처리가 발생한 메서드를 확인할 수 있도록 메시지의 라벨 출력하는 형태로 조치할 수 있습니다.
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        // 문제-4) 무한 반복문을 활용하여 지속적으로 클라이언트의 요청을 대기하는 
        // 서버 프로그램의 역할을 할 수 있도록 조치합니다.
        while(true)
        {
            Socket sc = null;
            OutputStream out = null;
            DataOutputStream dos = null;
            try 
            {
                System.out.println("서버의 연결 요청 대기");
                // 문제-5) 서버 소켓이 클라이언트의 연결 요청이 들어올 때까지 계속 기다릴 수 있도록 조치합니다.
                // 만약 요청이 들어오면 클라이언트 소켓과 통신할 새로운 소켓을 생성합니다.
                if(socket.getInetAddress() != null)
                {
                    System.out.println(socket.getInetAddress() + " IP로부터 연결요청이 들어왔습니다.");
                    sc = socket.accept();

                    // 문제-6) 소켓의 출력스트림을 OutputStream 클래스를 활용하여 out 객체를 생성합니다.
                    out = sc.getOutputStream();

                    // 문제-7) 위에서 생성된 out 객체를 활용하여 DataOutputStream 클래스의 dos 인스턴스를 생성합니다.
                    dos = new DataOutputStream(out);
                    // 문제-8) 원격 소켓(remote socket)에 데이터를 UTF-8 형식으로 보냅니다.
                    // 메시지 : "서버에서 보내는 메시지입니다."
                    String message = "서버에서 보내는 메시지입니다.";
                    dos.writeUTF(message);
                    dos.flush();
                }
            } 
            catch (IOException e) 
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            finally
            {
                // 문제-9) 위에서 생성한 스트림(dos)과 소켓(socket) 자원을 반납구문을 finally 
                // 구문을 추가하여 finally 블럭으로 옮기도록(이관) 조치합니다.
                dos.close();
                socket.close();
            }
        } // while
    } // main
}