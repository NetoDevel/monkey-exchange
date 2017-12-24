package br.com.token.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Jwts;

@Controller
public class ValidatorTokenController {

	@GetMapping("/cad")
	public @ResponseBody String index(@RequestParam("url_token") String urlToken) {
		String email = Jwts.parser().setSigningKey("chave").parseClaimsJws(urlToken).getBody().getSubject();
		return email;
	}
	
}
