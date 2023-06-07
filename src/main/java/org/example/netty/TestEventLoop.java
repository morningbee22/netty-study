package org.example.netty;

import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.TimeUnit;

public class TestEventLoop {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        System.out.println(group.next());
        System.out.println(group.next());

        group.next().execute(()->{
            System.out.println(Thread.currentThread().getName() + " hello");
        });

        group.next().scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + "hello2");
        },0,1, TimeUnit.SECONDS);

        group.shutdownGracefully();
    }
}
