package com.ecom.caltalog.infrastructure;

import com.ecom.shared.application.Command;
import com.ecom.shared.application.CommandHandler;
import com.ecom.shared.application.Query;
import com.ecom.shared.application.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleMediator implements Mediator {

    private final ApplicationContext applicationContext;

    public SimpleMediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R, C extends Command<R>> R send(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) applicationContext.getBean(getHandlerName(command.getClass()));
        return handler.handle(command);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R, Q extends Query<R>> R ask(Q query) {
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) applicationContext.getBean(getHandlerName(query.getClass()));
        return handler.handle(query);
    }


    private String getHandlerName(Class<?> commandOrQueryClass) {
        return commandOrQueryClass.getSimpleName() + "Handler";
    }
}