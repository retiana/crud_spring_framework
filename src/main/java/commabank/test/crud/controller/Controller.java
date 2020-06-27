package commabank.test.crud.controller;


import commabank.test.crud.services.ServicesCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

	@Autowired
	private ServicesCRUD service;
	
	@RequestMapping(value = "/CreateData", method = RequestMethod.POST, produces = "application/json")
	public Object insertData(@RequestBody String input) {
		return service.insertData(input);
	}

	@RequestMapping(value = "/UpdateData", method = RequestMethod.POST, produces = "application/json")
	public Object updateData(@RequestBody String input) {
		return service.updateData(input);
	}

	@RequestMapping(value = "/DeleteData", method = RequestMethod.POST, produces = "application/json")
	public Object deleteData(@RequestBody String input) {
		return service.deleteData(input);
	}

	@RequestMapping(value = "/SelectData", method = RequestMethod.GET, produces = "application/json")
	public Object selectData(@RequestBody String input) {
		return service.selectData();
	}
}
