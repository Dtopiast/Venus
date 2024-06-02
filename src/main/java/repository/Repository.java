package repository;

import com.dtopiast.venus.model.base.MyModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A generic repository interface for accessing and managing entities that extend MyModel.
 *
 * @param <TEntity> The type of entities managed by this repository, extending MyModel.
 */
public interface Repository<TEntity extends MyModel> extends JpaRepository<TEntity, Long> {

}