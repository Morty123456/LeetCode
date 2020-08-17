package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/17 17:21
 * @description:
 */
public class customer {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
//            new socketThread();
            new Thread(new socketThread(i)).start();
        }
        System.out.println("123");
//        int port = 7000;
//        String host = "localhost";
//        //创建一个套接字，将其连接到指定的端口号
//        Socket socket = new Socket(host, port);
//        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//        Scanner sc = new Scanner(System.in);
//        boolean flag = false;
//        while (!flag){
//            System.out.println("请输入正方形的边长：");
//            double length = sc.nextDouble();
//            dos.writeDouble(length);
//            dos.flush();
//
//            double area = dis.readDouble();
//            System.out.println("服务器返回的计算面积为："+area);
//
//            socket.close();
//        }
    }
}
class socketThread implements Runnable{

    private double length;

    public socketThread(double length) {
        this.length = length;
    }

    @Override
    public void run() {
        int port = 7000;
        String host = "localhost";
        //创建一个套接字，将其连接到指定的端口号
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            Scanner sc = new Scanner(System.in);
            boolean flag = false;
            while (!flag){
//                System.out.println("请输入正方形的边长：");
//                double length = sc.nextDouble();
                dos.writeDouble(length);
                dos.flush();

                double area = dis.readDouble();
                System.out.println("服务器返回的计算面积为："+area);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

