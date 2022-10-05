package org.mql.java.fp;

import java.util.Hashtable;
import java.util.function.BinaryOperator;

public class Operation {
	private static Hashtable<String, BinaryOperator<Double>> operations;     //UnaryOperation

	
	static {
		operations = new Hashtable<String, BinaryOperator<Double>>();
		operations.put("+", new A());
		operations.put("-", (a,b)->a-b);
		operations.put("*", (a,b)->a*b);
		operations.put("/", (a,b)->a/b);
	}
	
	static class A implements BinaryOperator<Double>{
		
		public Double apply(Double t, Double u) {
			return t+u;
		}
	}
	
	public Operation() {
		
	}
	
	public static double value(double x, double y, String op) {
		return operations.get(op).apply(x, y);
	}
}
