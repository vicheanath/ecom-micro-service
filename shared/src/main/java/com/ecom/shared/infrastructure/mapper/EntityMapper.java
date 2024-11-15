package com.ecom.shared.infrastructure.mapper;

public interface EntityMapper<TEntiy , TDmain> {
    TEntiy toEntity(TDmain domain);
    TDmain toDomain(TEntiy entity);
}
