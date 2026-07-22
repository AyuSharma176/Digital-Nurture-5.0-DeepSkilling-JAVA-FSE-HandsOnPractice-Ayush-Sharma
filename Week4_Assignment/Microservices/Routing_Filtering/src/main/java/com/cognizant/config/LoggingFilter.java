package com.cognizant.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String method = exchange.getRequest().getMethod().name();
        String uri    = exchange.getRequest().getURI().toString();

        System.out.println("=== Incoming Request ===");
        System.out.println("Time   : " + LocalDateTime.now());
        System.out.println("Method : " + method);
        System.out.println("URI    : " + uri);
        System.out.println("Headers: " + exchange.getRequest().getHeaders());

        long startTime = System.currentTimeMillis();

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("=== Response ===");
            System.out.println("Status  : " + exchange.getResponse().getStatusCode());
            System.out.println("Duration: " + duration + "ms");
        }));
    }

    @Override
    public int getOrder() {
        return -1; // Run before other filters
    }
}
