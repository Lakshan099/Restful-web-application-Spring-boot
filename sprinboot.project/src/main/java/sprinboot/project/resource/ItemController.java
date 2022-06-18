package sprinboot.project.resource;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


import sprinboot.project.exception.ResourceNotFoundException;
import sprinboot.project.model.Item;
import sprinboot.project.repository.ItemRepository;
import sprinboot.project.repository.IteamSearchRepository;


@RestController
public class ItemController {
	
	@Autowired
	ItemRepository repository;
	@Autowired
	private IteamSearchRepository SearchRepository;
	
	@PostMapping("/addItem")
	public String insertItem(@RequestBody Item item) {
		repository.save(item);
		return "Add Medicine with id : "+ item.getid();
	}
	
	@GetMapping("/findAllItems")
	public List<Item>getItems(){
		return repository.findAll();
	}
	
	@RequestMapping("/index")
    public String ItemList(Model model) {
        model.addAttribute("itemList", repository.findAll());
        return "index";
    }
	
	@RequestMapping(value = "/addItemMedi", method = RequestMethod.POST)
    public RedirectView addItemMedi(@ModelAttribute Item item) {
		repository.save(item);
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("index.html");
        return redirectView;
    }

	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("itemList", SearchRepository.searchItems(search));
		model.addAttribute("search", search);
		return "ItemList";
	}
	

	
	@GetMapping("/findItem/{id}")
	public Optional<Item> getItem(@PathVariable int id){
		return repository.findById(id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable int id) {
		repository.deleteById(id);
		return "Item deleted by id : "+id;
		
	}
	
	@PutMapping("/UpdateItem/{id}")
	public Optional<Item> updateItem(@PathVariable(value = "id")int Itemid,@Validated @RequestBody Item itemDetails)
			throws ResourceNotFoundException {
		
			Item item = repository.findById(Itemid)
					.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + Itemid));
			
			item.setMedicineName(itemDetails.getMedicineName());
			item.setDescription(itemDetails.getDescription());
			item.setQuantity(itemDetails.getQuantity());
			item.setPrice(itemDetails.getPrice());
			item.setExDate(itemDetails.getExDate());
			final Item updateItem = repository.save(item);
			return repository.findById(Itemid);	
		
	}
}
