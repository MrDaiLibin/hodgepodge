package com.awakeee.hodgepodge.netty1.handler2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline().addLast(new MyClientHandler());
    }
}
