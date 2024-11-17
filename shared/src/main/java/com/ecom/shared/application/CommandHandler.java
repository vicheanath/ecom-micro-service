package com.ecom.shared.application;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}