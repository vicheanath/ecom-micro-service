package com.ecom.shared.application;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
