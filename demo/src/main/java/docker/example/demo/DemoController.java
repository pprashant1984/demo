package docker.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private List<String> list  = new ArrayList<>();
	
	public DemoController() {
		list.add("Apple");
		list.add("Orange");
		list.add("Mango");
	}
	
	@GetMapping("/item")
	public List<String> getItems(){
		return list;
	}
}
