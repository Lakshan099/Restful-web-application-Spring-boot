package sprinboot.project.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sprinboot.project.model.Item;

@Repository
public class IteamSearchRepository {
	
	@Autowired
    MongoTemplate mongoTemplate;

    public Collection<Item> searchItems(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                        .orOperator(Criteria.where("id").regex(text, "i"),
                                    Criteria.where("MedicineName").regex(text, "i"),
                                    Criteria.where("Description").regex(text, "i"),
                        			Criteria.where("Quantity").regex(text, "i"),
                        			Criteria.where("Price").regex(text, "i"),
        							Criteria.where("ExDate").regex(text, "i"))
                        ), Item.class);
    }

}
