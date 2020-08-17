package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wzh
 * @time: 2020/8/17 17:34
 * @description:
 */
public class ServerMore {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        int clientNo = 1;
        ServerSocket serverSocket = new ServerSocket(port);

        ExecutorService exec = Executors.newCachedThreadPool();

        try {
            while (true){
                Socket socket = serverSocket.accept();
                exec.execute(new SingleServer(socket, clientNo++));
            }
        }finally {
            serverSocket.close();
        }

    }

}
class SingleServer implements Runnable{
    private Socket socket;
    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {
        try {
            //
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do {
                double length = dataInputStream.readDouble();
                System.out.println("从客户端 "+clientNo+" 收到的数据是："+length);
                double result = length*length;
                dataOutputStream.writeDouble(result);
                dataOutputStream.flush();
            }while (dataInputStream.readInt()!=0);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("与客户端 "+clientNo+" 通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}