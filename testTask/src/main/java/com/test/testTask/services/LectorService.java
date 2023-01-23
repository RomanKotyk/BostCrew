package com.test.testTask.services;

import com.test.testTask.domains.Lector;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * The interface for working with Lector objects
 */
@Service
public interface LectorService {
    /***
     * To get lector by id
     * @param id - id of lector
     * @return lector
     */
    Lector getLectorById(Long id);

    /***
     * To get lectors which contain template in the name or surname
     * @param template - string from user request
     * @return list of lectors
     */
    List<Lector> getLectorsByTemplate(String template);

    /***
     * Get all lectors from DB
     * @return list of lectors
     */
    List<Lector> getAllLectors();
}
