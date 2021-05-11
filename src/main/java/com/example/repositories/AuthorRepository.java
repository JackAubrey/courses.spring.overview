/**
 * 
 */
package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Author;

/**
 * @author dcividin
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{

}
