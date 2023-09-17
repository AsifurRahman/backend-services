package com.asif.backend.generic.service;

import com.asif.backend.common.Utils.Helper;
import com.asif.backend.common.constant.ErrorId;
import com.asif.backend.common.exception.RmsServerException;
import com.asif.backend.generic.model.BaseEntity;
import com.asif.backend.generic.payload.request.IDto;
import com.asif.backend.generic.payload.response.PageData;
import com.asif.backend.generic.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class AbstractService<E extends BaseEntity, D extends IDto> implements IService<E, D> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
    protected final AbstractRepository<E> repository;

    @Override
    public E create(D d) {
        validateClientData(d, null);
        return saveItem(convertToEntity(d));
    }

    @Override
    public E update(D d, Long id) {
        validateClientData(d, null);
        return saveItem(convertToEntity(d, findById(id)));
    }

    @Override
    public <T> T getSingle(Long id) {
        return convertToResponseDto(findById(id));
    }

    @Override
    public E findById(Long id) {
        return repository.findById(id).orElseThrow(() -> RmsServerException.notFound(ErrorId.NOT_FOUND));
    }

    @Override
    public void updateActiveStatus(Long id, Boolean isActive) {
        E e = findById(id);
        if (e.getIsActive() == isActive) {
            throw RmsServerException.badRequest(ErrorId.ONLY_TOGGLE_VALUE_ACCEPTED);
        }

        e.setIsActive(isActive);
        saveItem(e);
    }

    @Override
    public E saveItem(E entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            LOGGER.error("Save failed for entity {}", entity.getClass().getSimpleName());
            LOGGER.error("Error message: {}", e.getMessage());
            throw RmsServerException.dataSaveException(ErrorId.DATA_NOT_SAVED);
        }
    }

    @Override
    public List<E> saveItemList(List<E> entityList) {
        try {
            if (CollectionUtils.isEmpty(entityList)) {
                return entityList;
            }
            return repository.saveAll(entityList);
        } catch (Exception e) {
            String entityName = entityList.get(0).getClass().getSimpleName();
            LOGGER.error("Save failed for entity {}", entityName);
            LOGGER.error("Error message: {}", e.getMessage());
            throw RmsServerException.dataSaveException(Helper.createDynamicCode(ErrorId.DATA_NOT_SAVED_DYNAMIC,
                    entityName));
        }
    }


    @Override
    public PageData getAll(Boolean isActive, Pageable pageable) {
        Page<E> pagedData = repository.findAllByIsActive(isActive, pageable);
        List<Object> models = pagedData.getContent().stream().map(this::convertToResponseDto)
                .collect(Collectors.toList());
        return PageData.builder()
                .model(models)
                .totalPages(pagedData.getTotalPages())
                .totalElements(pagedData.getTotalElements())
                .currentPage(pageable.getPageNumber() + 1)
                .build();
    }

    @Override
    public List<E> findAllByIds(Collection<Long> ids) {
        return repository.findAllByIdIn(ids);
    }

    protected abstract <T> T convertToResponseDto(E e);

    protected abstract E convertToEntity(D d);

    protected abstract E convertToEntity(D d, E entity);



}
