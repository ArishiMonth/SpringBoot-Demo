package io.arish.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String say() {
		return "Hello Spring Boot!";
	}

}
