package me.j360.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author: min_xu
 * @date: 2017/12/25 下午5:41
 * 说明：
 */
public class EchoServerHandler extends SimpleChannelInboundHandler<ByteBuf> {


    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        System.out.println("server ready");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("receive -> "+byteBuf.toString(Charset.forName("UTF-8")));

        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("hello client, I am server", CharsetUtil.UTF_8));
    }
}
