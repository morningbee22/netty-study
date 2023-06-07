package org.example.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * read bytebuf 读取
 */
public class ByteBufStudy1 {


    public static void main(String[] args) {
        //默认使用直接内存，容量为256个字节。可以指定初始容量的大小,也可以指定需要扩容时，扩容的大小
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16,20);
        buffer.writeBytes(new byte[]{1,2,3,4});
        buffer.writeInt(5);
        ByteBufUtil.log(buffer);

        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        ByteBufUtil.log(buffer);

        buffer.markReaderIndex();
        System.out.println(buffer.readInt());
        ByteBufUtil.log(buffer);

        buffer.resetReaderIndex();
        ByteBufUtil.log(buffer);

        System.out.println(buffer.readInt());
        ByteBufUtil.log(buffer);
    }

}
