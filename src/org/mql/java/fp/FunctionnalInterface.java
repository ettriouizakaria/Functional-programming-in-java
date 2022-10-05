package org.mql.java.fp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javax.swing.JButton;

public class FunctionnalInterface {

	public FunctionnalInterface() {
		exp03();
	}

	void exp1() {
		String[] t = { "D", "A", "a", "D", "E", "B", "b", "C", "a", "*", "+", "D", ";" };
		
		//Example 1
		//on peut faire ca sauf si on va pas besoin de reutiliser le code
		Arrays.stream(t)
			.filter(s -> s.charAt(0) >= 'A')
			.filter(s -> s.charAt(0) <= 'z')
			.map(String::toUpperCase)
			.distinct()
			.sorted(String::compareTo)
			.forEach(System.out::println);
		//example 2
		List<String> list = Arrays.stream(t)
		.filter(s -> s.charAt(0) >= 'A')
		.filter(s -> s.charAt(0) <= 'z')
		.map(String::toUpperCase)
		.distinct()
		.sorted(String::compareTo)
		.collect(Collectors.toList());
		System.out.println(list);
		
		//example 3
		Arrays.stream(t)
				.filter(s -> s.charAt(0) >= 'A')
				.filter(s -> s.charAt(0) <= 'z')
				.map(String::toUpperCase)
				.distinct()
				.sorted(String::compareTo)
				.findFirst()
				.ifPresent(System.out::println);
	}
	
//	void exp2() {
//		String s ="";
//		
//	}
	
	
	void exp02() {
		JButton button = new JButton();
		button.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		//pas de classe cree
		button.addActionListener(e -> System.exit(0));
		
		Logger logger = new Logger() {
			
			public void log(String msg) {
				System.out.println("msg "+msg);
				
			}
		} ;
		
		logger.log("Un msg");
		//juste avec des interfaces qui ne disposent d'une seuls methodes = =>interface fonctionnelle
		logger = m->System.out.println("***"+m+"***");
		
		logger.log("un message");
		
		//utiliser une interface predefinier
		Consumer<String> consumer  = m->System.out.println("|||"+m+"|||");
		consumer.accept("un msg");
//		new Supplier<String>() {
//			@Override
//			public String get() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
		
	}
	
	
	void exp03() {
		//les interfaces predefinier les plus imporatantes
		Function<?, ?> f1;
		BiFunction<?, ?, ?> f2;
	
		Predicate<?> p1;     //sortie : true ou flase
		BiPredicate<?, ?> p2;
		
		Consumer<?> c1;
		BiConsumer<?, ?> b2;
		
		Supplier<?> s1;
		
		BinaryOperator<?> op1;
		UnaryOperator<?> op2;
		
		
		
		new Function<String, Integer>() { //BiFunction()
			public Integer apply(String t) {
				return null;
			};
		};
		
		Function<String, Integer> f3 = s->s.length();
		int n = f3.apply("Une chaine de caracteres");
		System.out.println(n);
	}
	

	public static void main(String[] args) {
		new FunctionnalInterface();
	}
}
