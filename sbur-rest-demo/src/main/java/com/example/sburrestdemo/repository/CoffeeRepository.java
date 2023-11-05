package com.example.sburrestdemo.repository;

import com.example.sburrestdemo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    
}
