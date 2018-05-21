package com.project.iban;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/rest")
@CrossOrigin(origins = {"http://192.168.1.2:8100","http://localhost:8100"})
class Iban{
 
   @RequestMapping(value="/iban/{iban}",method = RequestMethod.GET)
   public String getAllStudents(@PathVariable("iban") String iban){
	   	  String URL = "https://openiban.com/validate/"+iban+"?getBIC=true&validateBankCode=true";
	      RestTemplate template=new RestTemplate();
	      
	      return (template.getForObject(URL,String.class));
      
   }
}
