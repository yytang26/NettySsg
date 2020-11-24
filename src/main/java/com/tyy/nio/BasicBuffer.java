package com.tyy.nio;

import java.nio.IntBuffer;

/**
 * @author:tyy
 * @date:2020/11/24
 * @Desc:举例说明Buffer的使用
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer allocate = IntBuffer.allocate(5);
        for(int i=0;i<5;i++){
            allocate.put(i);
        }
        allocate.flip();
        allocate.position(1);
        allocate.limit(2);
        while (allocate.hasRemaining()){
            System.out.println(allocate.get());
        }

    }
}
