package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wzh
 * @time: 2020/8/17 17:21
 * @description:
 */
public class provider {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        //创建一个套接字指定到某个端口
        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();

        DataInputStream dis  = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        do {
            double length = dis.readDouble();
            System.out.println("服务器端收到的数据是："+length);
            double result = length*length;
            dos.writeDouble(result);
            dos.flush();
        }while (dis.readInt()!=0);

        socket.close();
        serverSocket.close();
    }
}
