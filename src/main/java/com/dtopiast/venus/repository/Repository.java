package com.dtopiast.venus.repository;

import com.dtopiast.venus.domain.base.MyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * A generic repository interface for accessing and managing entities that extend MyModel.
 *
 * @param <TEntity> The type of entities managed by this repository, extending MyModel.
 */
public interface Repository<TEntity extends MyModel> extends JpaRepository<TEntity, Long>, JpaSpecificationExecutor<TEntity> {

}