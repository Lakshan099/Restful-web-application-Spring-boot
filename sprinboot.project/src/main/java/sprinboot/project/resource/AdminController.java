package sprinboot.project.resource;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import sprinboot.project.model.Admin;
import sprinboot.project.repository.AdminRepository;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = {"springboot.mongo.api.repository"})
@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository Adminrepository;
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		Adminrepository.save(admin);
		return "Add Admin with id : "+ admin.getid();
	}
	
	@GetMapping("/findAllAdmins")
	public List<Admin>getAdmins(){
		return Adminrepository.findAll();
	}
	
	@GetMapping("/findAdmin/{id}")
	public Optional<Admin> getAdmin(@PathVariable int id){
		return Adminrepository.findById(id);
	}
	
	@GetMapping("/ValidateAdmin/{AdminName}")
	public String ItemList(Admin admin) {
		((Model) admin).addAttribute("AdminList", Adminrepository.findAll());
        return "index";
    }

}

