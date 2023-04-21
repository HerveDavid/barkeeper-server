package com.barkeeper.barkeeperserver.configuration;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.netty.http.server.HttpServer;

@Component
public class NettyWebServerFactoryPortCustomizer
    implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Value("${server.port}")
    Integer port;

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.setPort(port);
        serverFactory.addServerCustomizers(new PortCustomizer(port));
        serverFactory.addServerCustomizers(new EventLoopNettyCustomizer());
    }

    private record PortCustomizer(int port) implements NettyServerCustomizer {
        @Override
        public HttpServer apply(HttpServer httpServer) {
            return httpServer.port(port);
        }
    }

    private static class EventLoopNettyCustomizer implements NettyServerCustomizer {
        @Override
        public HttpServer apply(HttpServer httpServer) {
            EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
            eventLoopGroup.register(new NioServerSocketChannel());
            return httpServer.runOn(eventLoopGroup);
        }
    }

    @Bean
    public NettyReactiveWebServerFactory nettyReactiveWebServerFactory() {
        NettyReactiveWebServerFactory webServerFactory = new NettyReactiveWebServerFactory();
        webServerFactory.addServerCustomizers(new EventLoopNettyCustomizer());
        return webServerFactory;
    }

}
