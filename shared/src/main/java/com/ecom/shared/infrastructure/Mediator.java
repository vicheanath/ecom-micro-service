package com.ecom.caltalog.infrastructure;


import com.ecom.shared.application.Command;
import com.ecom.shared.application.Query;
import org.springframework.stereotype.Component;

@Component
public interface Mediator {
    <R, C extends Command<R>> R send(C command);

    <R, Q extends Query<R>> R ask(Q query);
}

