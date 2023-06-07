package org.example.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * slice
 */
public class ByteBufStudy2 {

    public static void main(String[] args) {
        //默认使用直接内存，容量为256个字节。可以指定初始容量的大小,也可以指定需要扩容时，扩容的大小
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16,20);
        ByteBufUtil.log(buffer);

        //向buffer中写入数据
        buffer.writeBytes(new byte[]{1,2,3,4,5,6,7,8,9,10});

        ByteBuf slice1 = buffer.slice(0, 5);
        ByteBuf slice2 = buffer.slice(5, 5);

        slice1.retain();
        slice2.retain();

        ByteBufUtil.log(slice1);
        ByteBufUtil.log(slice2);

        System.out.println("===============修改原buffer中的值======================");
        buffer.setByte(0,5);

        System.out.println("===============打印slice1======================");
        ByteBufUtil.log(slice1);
    }

}
