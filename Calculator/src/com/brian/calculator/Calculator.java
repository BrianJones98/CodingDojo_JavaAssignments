package com.brian.calculator;

public class Calculator implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result;
	
	public Calculator() {
	}
	//Getters
	public double getResults() {
		return this.result;
	}
	//Setters
	public void setOperandOne(double value) {
		this.operandOne = value;
	}
	public void setOperandTwo(double value) {
		this.operandTwo = value;
	}
	public void setOperation(String operation) {
		if(operation == "+" || operation == "-") {
			this.operation = operation;
		}
		else {
			System.out.println("Invalid operation");
		}
	}
	public void performOperation() {
		if(this.operation == "+") {
			this.result = this.operandOne + this.operandTwo;
		}
		else {
			this.result = this.operandOne - this.operandTwo;
		}
	}
}
