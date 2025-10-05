package com.mogam.cloud.api_gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
public class CustomFilter implements GlobalFilter {

    Logger log = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//      pre filter
        ServerHttpRequest request = exchange.getRequest();
        log.info("Authorization Filter : {}", request.getHeaders().getFirst("Authorization"));

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//          post filter
            ServerHttpResponse response = exchange.getResponse();
            log.info("Http Status Code : {}", response.getStatusCode());
        }));
    }
}
