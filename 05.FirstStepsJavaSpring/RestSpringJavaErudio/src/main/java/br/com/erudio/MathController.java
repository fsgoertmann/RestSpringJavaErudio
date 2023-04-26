package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		return convertToDouble(numOne) + convertToDouble(numTwo);		
	}
	
	@RequestMapping(value = "/sub/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		return convertToDouble(numOne) - convertToDouble(numTwo);		
	}
	
	@RequestMapping(value = "/mult/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or numeric two values!");
		}
		return convertToDouble(numOne) * convertToDouble(numTwo);		
	}
	
	@RequestMapping(value = "/div/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numOne") String numOne,
			@PathVariable(value = "numTwo") String numTwo
			) throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		if ("0".equals(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a number bigger than 0!");
		}
		return convertToDouble(numOne) / convertToDouble(numTwo);		
	}
	
	@RequestMapping(value = "/med/{numbers}", method=RequestMethod.GET)
	public Double med(
			@PathVariable(value = "numbers") String numbers
			) throws Exception {
		if (!numbers.contains(" ")) {
			throw new UnsuportedMathOperationException("Please, insert multiple numbers separated by spaces between them!");
		}
		String[] nums = numbers.split(" ");
		Double sum = 0D;
		for(String num : nums) {
			if (!isNumeric(num)) {
				throw new UnsuportedMathOperationException("Please, set only numeric values!");
			}
			sum += convertToDouble(num);
		}
		return sum / nums.length;
	}
	
	@RequestMapping(value = "/root/{numOne}", method=RequestMethod.GET)
	public Double root(
			@PathVariable(value = "numOne") String numOne
			) throws Exception {
		if (!isNumeric(numOne)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value!");
		}
		return Math.sqrt(convertToDouble(numOne));		
	}

	private Double convertToDouble(String num) {
		if(num == null) return 0D;
		String number = num.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String num) {
		if(num == null) return false;
		String number = num.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
