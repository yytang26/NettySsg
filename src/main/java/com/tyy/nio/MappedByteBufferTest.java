package com.tyy.nio;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:tyy
 * @date:2020/11/23
 * @Desc:直接在堆外内存修改
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile=new RandomAccessFile("D:\\java\\action\\Netty\\file02.txt","rw");
        FileChannel fileChannel=randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0,(byte)'L');
        mappedByteBuffer.put(4,(byte)'D');


    }
}
