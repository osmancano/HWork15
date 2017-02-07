package com.ironyard.repositories;

import com.ironyard.data.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/5/17.
 */
public interface CompanyRepo extends CrudRepository<Company, Long>{
}
