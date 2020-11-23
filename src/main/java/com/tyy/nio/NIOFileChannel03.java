package com.tyy.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @author:tyy
 * @date:2020/11/23
 * @Desc:仅使用一个buffer，把一个文件的数据拷贝到另一个文件
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        File file=new File("D:\\java\\action\\Netty\\file01.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileChannel channel=fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\action\\Netty\\file02.txt");
        FileChannel outChannel=fileOutputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        while(true){
            byteBuffer.clear();
            int read=channel.read(byteBuffer);
            if(read==-1) break;
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.flip();
        }
    }
}
