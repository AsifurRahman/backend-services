package com.asif.backend.generic.service;

import com.asif.backend.generic.model.BaseEntity;
import com.asif.backend.generic.payload.request.IDto;
import com.asif.backend.generic.payload.response.PageData;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface IService<E extends BaseEntity, D extends IDto> {

    E create(D d);

    E update(D d, Long id);

    <T> T getSingle(Long id);

    E findById(Long id);

    void updateActiveStatus(Long id, Boolean b);

    E saveItem(E entity);

    List<E> saveItemList(List<E> entityList);

    default void validateClientData(D d, Long id) {
    }

    PageData getAll(Boolean isActive, Pageable pageable);

    List<E> findAllByIds(Collection<Long> ids);
}
