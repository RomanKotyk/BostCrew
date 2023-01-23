package com.test.testTask.repositories;

import com.test.testTask.domains.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * Department repository
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    /***
     * To get department from DB by name
     * @param name
     * @return department
     */
    Department getByName(String name);
}
