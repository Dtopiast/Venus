package com.dtopiast.venus.domain.base;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

/**
 * Base class for entities in the system.
 */
@Entity
@EqualsAndHashCode(of = "id")
public abstract class MyModel {

    /**
     * The unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

