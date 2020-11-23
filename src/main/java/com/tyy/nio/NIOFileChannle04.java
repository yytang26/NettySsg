package com.tyy.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:tyy
 * @date:2020/11/23
 * @Desc:用transferFrom完成拷贝
 */
public class NIOFileChannle04 {
    public static void main(String[] args) throws Exception {
        File file=new File("D:\\java\\action\\Netty\\file01.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileChannel channel=fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\action\\Netty\\file03.txt");
        FileChannel outChannel=fileOutputStream.getChannel();

        outChannel.transferFrom(channel,0,channel.size());
        outChannel.close();
        channel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
