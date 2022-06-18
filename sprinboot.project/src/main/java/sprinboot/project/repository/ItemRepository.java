package sprinboot.project.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sprinboot.project.model.Item;

public interface ItemRepository extends MongoRepository<Item, Integer>{

	

}
