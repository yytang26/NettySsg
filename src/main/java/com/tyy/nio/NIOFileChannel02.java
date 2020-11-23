package com.tyy.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:tyy
 * @date:2020/11/23
 * @DESC:本地文件读数据
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream=new FileInputStream("D:\\java\\action\\Netty\\file01.txt");
        FileChannel channel = fileInputStream.getChannel();
        //也可根据实际的文件长度设置合适的capacity
        //如果capacity的容量比实际文本长度小，那么仅仅会显示出前capacity个
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array()));
        channel.close();
        fileInputStream.close();
    }

}
