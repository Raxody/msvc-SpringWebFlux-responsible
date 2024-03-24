package com.pragma.assets.infraestructure.crud.repository;

import com.pragma.assets.infraestructure.persistence.EmployeeEntity;
import com.pragma.assets.infraestructure.persistence.ResponsibleEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ResponsibleCrudRepository extends ReactiveMongoRepository<ResponsibleEntity,String> {
    @Query("{'email': ?0}")
    Mono<ResponsibleEntity> findByEmail(String email);
    @Query("{'email': ?0}")
    Mono<Boolean> deleteByEmail(String email);
    @Query("{'_class': ?0}")
    Flux<ResponsibleEntity> findByClass(String type);

}
