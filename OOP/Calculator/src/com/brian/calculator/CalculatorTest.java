package com.brian.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator newCalculation = new Calculator();
		
		newCalculation.setOperandOne(10.5);
		newCalculation.setOperandTwo(5.2);
		newCalculation.setOperation("+");
		newCalculation.performOperation();
		System.out.println(newCalculation.getResults());
	}

}
