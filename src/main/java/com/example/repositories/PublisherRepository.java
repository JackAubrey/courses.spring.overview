/**
 * 
 */
package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Publisher;

/**
 * @author dcividin
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
