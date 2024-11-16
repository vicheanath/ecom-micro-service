package com.ecom.shared.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CommandHandlerConfig {

    @Bean
    public Map<Class<?>, CommandHandler<?>> voidHandlers(List<CommandHandler<?>> handlers) {
        Map<Class<?>, CommandHandler<?>> map = new HashMap<>();
        for (CommandHandler<?> handler : handlers) {
            map.put(handler.getSupportedCommand(), handler);
        }
        return map;
    }

    @Bean
    public Map<Class<?>, CommandHandlerWithResponse<?, ?>> responseHandlers(List<CommandHandlerWithResponse<?, ?>> handlers) {
        Map<Class<?>, CommandHandlerWithResponse<?, ?>> map = new HashMap<>();
        for (CommandHandlerWithResponse<?, ?> handler : handlers) {
            map.put(handler.getSupportedCommand(), handler);
        }
        return map;
    }
}

