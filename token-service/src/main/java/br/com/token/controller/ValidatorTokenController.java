package br.com.token.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.token.communicator.Person;
import br.com.token.communicator.PersonCommunicator;
import io.jsonwebtoken.Jwts;

@Controller
public class ValidatorTokenController {

	@Autowired
	private PersonCommunicator personCommunicator;
	
	@GetMapping("/register")
	public @ResponseBody Person index(@RequestParam("url_token") String urlToken) {
		String id = Jwts.parser().setSigningKey("chave").parseClaimsJws(urlToken).getBody().getSubject();
		return personCommunicator.findOne(Integer.parseInt(id));
	}
	
}
