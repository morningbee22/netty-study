package org.example.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.nio.charset.StandardCharsets;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

public class ByteBufStudy {


    public static void main(String[] args) {
        //默认使用直接内存，容量为256个字节。可以指定初始容量的大小,也可以指定需要扩容时，扩容的大小
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16,20);
        ByteBufUtil.log(buffer);

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 20; i++) {
//            sb.append("a");
//        }
//        buffer.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8));
//        ByteBufUtil.log(buffer);
        buffer.writeBytes(new byte[]{1,2,3,4});

        //大端写入
        buffer.writeInt(5);
        ByteBufUtil.log(buffer);

        //小端写入
        buffer.writeIntLE(6);
        ByteBufUtil.log(buffer);

        buffer.writeLong(7);
        ByteBufUtil.log(buffer);
    }

}
