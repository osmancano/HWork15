package com.ironyard.repositories;

import com.ironyard.data.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/5/17.
 */
public interface StudentRepo extends CrudRepository<Student,Long>{
}
