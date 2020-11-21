package com.tyy.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:tyy
 * @date:2020/11/21 11:14
 * @version:0.0.1
 */
public class BIOServer {

    public static void main(String[] args) throws  Exception{
        //线程池机制

        //思路
        //创建一个线程池
        //如果有客户端连接，就创建一个线程与之通讯(分开写)
        ExecutorService service = Executors.newCachedThreadPool();
        //创建ServerSocket
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("服务器启动了");
        //监听6666端口，直到有客户端连接过来，否则会处于阻塞态
        System.out.println("服务器在等待客户端连接");
        final Socket socket = serverSocket.accept();
        //服务器创建一个线程和客户端进行通信
        service.execute(new Runnable() {
            public void run() {
                handler(socket);  //通信方法
            }
        });


    }
    public static void handler(Socket socket){
        //创建一个字节数组作为缓存数据的缓冲区
        byte[] bytes=new byte[1024];
        System.out.println("当前线程的id"+Thread.currentThread().getId());
        try{
            InputStream inputStream =socket.getInputStream();
            System.out.println("服务端在读取客户端的数据");
            while(true){
                int read=inputStream.read(bytes);
                if(read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

}

}
