package th.co.acc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

	@RequestMapping(value = "/isAlive" ,method=RequestMethod.GET)
	public String isAlive() {
		return "{healthy:true}";
	}
}
