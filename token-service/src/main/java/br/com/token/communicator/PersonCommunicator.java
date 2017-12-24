package br.com.token.communicator;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("backoffice-service")
public interface PersonCommunicator {

	@RequestMapping(value = "/v1/persons/{id}", method = RequestMethod.GET)
	Person findOne(@PathVariable("id") Integer id); 
	
}
