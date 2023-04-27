package br.com.erudio.operations;

import br.com.erudio.commons.NumericCommons;
import br.com.erudio.exceptions.UnsuportedMathOperationException;

public class Operations {
	public static Double sum(String numOne, String numTwo) throws Exception {
		if (!NumericCommons.isNumeric(numOne) || !NumericCommons.isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		return NumericCommons.convertToDouble(numOne) + NumericCommons.convertToDouble(numTwo);		
	}
	
	public static Double sub(String numOne, String numTwo) throws Exception {
		if (!NumericCommons.isNumeric(numOne) || !NumericCommons.isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		return NumericCommons.convertToDouble(numOne) - NumericCommons.convertToDouble(numTwo);		
	}
	
	public static Double mult(String numOne, String numTwo) throws Exception {
		if (!NumericCommons.isNumeric(numOne) || !NumericCommons.isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or numeric two values!");
		}
		return NumericCommons.convertToDouble(numOne) * NumericCommons.convertToDouble(numTwo);		
	}
	
	public static Double div(String numOne, String numTwo) throws Exception {
		if (!NumericCommons.isNumeric(numOne) || !NumericCommons.isNumeric(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value or two numeric values!");
		}
		if ("0".equals(numTwo)) {
			throw new UnsuportedMathOperationException("Please, set a number bigger than 0!");
		}
		return NumericCommons.convertToDouble(numOne) / NumericCommons.convertToDouble(numTwo);		
	}
	
	public static Double med(String numbers) throws Exception {
		if (!numbers.contains(" ")) {
			throw new UnsuportedMathOperationException("Please, insert multiple numbers separated by spaces between them!");
		}
		String[] nums = numbers.split(" ");
		Double sum = 0D;
		for(String num : nums) {
			if (!NumericCommons.isNumeric(num)) {
				throw new UnsuportedMathOperationException("Please, set only numeric values!");
			}
			sum += NumericCommons.convertToDouble(num);
		}
		return sum / nums.length;
	}
	
	public static Double root(String numOne) throws Exception {
		if (!NumericCommons.isNumeric(numOne)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value!");
		}
		return Math.sqrt(NumericCommons.convertToDouble(numOne));		
	}
}
