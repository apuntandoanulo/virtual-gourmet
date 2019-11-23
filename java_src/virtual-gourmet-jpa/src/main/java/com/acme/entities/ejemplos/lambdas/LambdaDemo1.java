package com.acme.entities.ejemplos.lambdas;

public class LambdaDemo1 {

	 
	
	public static void main(String[] args) {
		//Con clases internas anonimas
		/*MyNumber mn = new MyNumber() {
			@Override
			public double getValue() {
				return 123.45;
			}
		};*/
		
		MyNumber mn = () -> 123.45;
		
		System.out.println(mn.getValue());
		/*
		MyNumber mn2 = new MyNumber() {
			@Override
			public double getValue() {
				return Math.random() * 100;
			}
		};*/
		
		mn = () -> Math.random() * 100;
		
		System.out.println(mn.getValue());
	}
}
