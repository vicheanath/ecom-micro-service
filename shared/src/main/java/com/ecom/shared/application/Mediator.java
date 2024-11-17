//package com.ecom.shared.application;
//
//import org.springframework.stereotype.Component;
//import java.util.Map;
//
//@Component
//public class Mediator {
//    private final Map<Class<?>, CommandHandler<?>> voidHandlers;
//    private final Map<Class<?>, CommandHandlerWithResponse<?, ?>> responseHandlers;
//
//    public Mediator(Map<Class<?>, CommandHandler<?>> voidHandlers,
//                    Map<Class<?>, CommandHandlerWithResponse<?, ?>> responseHandlers) {
//        this.voidHandlers = voidHandlers;
//        this.responseHandlers = responseHandlers;
//    }
//
//    @SuppressWarnings("unchecked")
//    public <C extends Command> void send(C command) {
//        CommandHandler<C> handler = (CommandHandler<C>) voidHandlers.get(command.getClass());
//        if (handler == null) {
//            throw new IllegalArgumentException("No void handler registered for command type: " + command.getClass().getName());
//        }
//        handler.handle(command);
//    }
//
//    @SuppressWarnings("unchecked")
//    public <C extends Command, TResponse> TResponse send(C command, Class<TResponse> responseType) {
//        CommandHandlerWithResponse<C, TResponse> handler =
//                (CommandHandlerWithResponse<C, TResponse>) responseHandlers.get(command.getClass());
//        if (handler == null) {
//            throw new IllegalArgumentException("No response handler registered for command type: " + command.getClass().getName());
//        }
//        return handler.handle(command);
//    }
//}
//
