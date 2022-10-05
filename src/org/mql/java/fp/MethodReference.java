package org.mql.java.fp;

import java.awt.Dimension;
import java.awt.Point;
import java.util.function.BiFunction;

public class MethodReference {
	private Logger logger;
	/*
	 * static method reference
	 * Instance method reference
	 * Arbitrary instance method reference
	 * Constructor reference
	 */
	public MethodReference(Logger logger) {
		this.logger = logger;
	}
	
	
	void print(String msg) {
		logger.log(msg);
	}
	
	static void exp01() {
		MethodReference r1 = new MethodReference(msg->System.out.println("### " +msg));
		r1.print("Lambda Expression");
	}
	
	// instance method reference
	static void exp02() {
		MethodReference r1 = new MethodReference(System.out::println);
		r1.print("instance method reference");
	}
	
	static <T> T create(int x, int y,BiFunction<Integer, Integer, T> f) {
		return f.apply(x, y);
	}
	
	//Constructor reference
	static void exp03() {
		Point p1 = create(20, 20, Point::new);
		Dimension d1 = create(20,20,Dimension::new);
		System.out.println(p1);
		System.out.println(d1);
	}
	
	static void exp04() {
		Factory<Point> f1 = Point::new;
		Factory<Dimension> f2 = Dimension::new;
		
		System.out.println(f1.create(20, 30));
		System.out.println(f2.create(20, 30));
	}
	
	public static void main(String[] args) {
		exp04();
	}
}
