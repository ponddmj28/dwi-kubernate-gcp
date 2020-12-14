package th.co.acc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

	@RequestMapping(value = "/isAlive" ,method=RequestMethod.GET)
	public @ResponseBody String isAlive() {
		return "{healthy:true}";
	}
	
	@RequestMapping(value = "/" ,method=RequestMethod.GET)
	public @ResponseBody String init() {
		return isAlive();
	}
	@RequestMapping(value = "/healthz",method=RequestMethod.GET)
	public @ResponseBody String isHealthz() {
		return isAlive();
	}
}
