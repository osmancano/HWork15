package com.ironyard.repositories;

import com.ironyard.data.Instructor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/5/17.
 */
public interface InstructorRepo extends CrudRepository<Instructor,Long> {
}
