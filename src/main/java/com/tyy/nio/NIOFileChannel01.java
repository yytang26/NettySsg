package com.tyy.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:tyy
 * @date:2020/11/23
 * @Desc:主要是演示一下缓冲、管道、输出流之间的关系
 * 本地文件写数据
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception{
        //定义要写入缓冲区的文字
        String write="Hello World";
        //定义一个输出流
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\action\\Netty\\file01.txt");
        //定义一个管道
        //实际是FileChannelImpl
        FileChannel fileChannel=fileOutputStream.getChannel();
        //把输出流封装到管道中
        //创立缓冲区，并设置缓冲区的容量是1024
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //把文字放入缓冲区
        byteBuffer.put(write.getBytes());
        //反转缓冲区，从读变成写
        byteBuffer.flip();
        //把缓冲区的数据写入到管道
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }
}
