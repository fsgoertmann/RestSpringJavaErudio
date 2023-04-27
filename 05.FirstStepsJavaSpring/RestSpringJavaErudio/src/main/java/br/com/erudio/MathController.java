package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.operations.Operations;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		return Operations.sum(numOne, numTwo);		
	}
	
	@RequestMapping(value = "/sub/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		return Operations.sub(numOne, numTwo);		
	}
	
	@RequestMapping(value = "/mult/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		return Operations.mult(numOne, numTwo);		
	}
	
	@RequestMapping(value = "/div/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		return Operations.div(numOne, numTwo);		
	}
	
	@RequestMapping(value = "/med/{numbers}", method=RequestMethod.GET)
	public Double med(
			@PathVariable(value = "numbers") String numbers
			) throws Exception {
		return Operations.med(numbers);
	}
	
	@RequestMapping(value = "/root/{numOne}", method=RequestMethod.GET)
	public Double root(
			@PathVariable(value = "numOne") String numOne
			) throws Exception {
		return Operations.root(numOne);		
	}
}
