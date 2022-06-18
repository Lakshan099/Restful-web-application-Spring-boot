package sprinboot.project.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sprinboot.project.model.Admin;

@Repository("AdminRepository")
public interface AdminRepository extends MongoRepository<Admin, Integer>{
	
	

	

}