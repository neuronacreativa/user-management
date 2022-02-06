package org.nc.usermanagement.infrastructure.persistence.db.repository.jpa;

import org.nc.usermanagement.infrastructure.persistence.db.model.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserModelRepository extends PagingAndSortingRepository<UserModel, Integer> {
}
