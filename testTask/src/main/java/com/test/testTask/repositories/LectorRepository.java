package com.test.testTask.repositories;

import com.test.testTask.domains.Lector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Lector repository
 */
@Repository
public interface LectorRepository  extends CrudRepository<Lector, Long> {
    /***
     * To get lector from DB by id
     * @param id
     * @return lector
     */
    Lector getById(Long id);

    /***
     * To get all lectors from DB
     * @return list of lectors
     */
    @Query(nativeQuery = true, value = "SELECT * FROM lectors")
    List<Lector> getAllLector();
}
