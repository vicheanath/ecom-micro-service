package com.ecom.application;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}
