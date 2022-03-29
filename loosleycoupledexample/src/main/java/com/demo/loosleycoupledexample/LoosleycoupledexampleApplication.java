package com.demo.loosleycoupledexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LoosleycoupledexampleApplication {
	
	public static void main(String[] args) {
	 ApplicationContext applicationContext =	SpringApplication.run(LoosleycoupledexampleApplication.class, args);
	 
	 BinarySearch binarySearch = (BinarySearch) applicationContext.getBean("binarySearch");
	 BinarySearch binarySearch1 = (BinarySearch) applicationContext.getBean(BinarySearch.class);
	 System.out.println(binarySearch == binarySearch1);
	 System.out.println(binarySearch.search(null, 0));
	}
	
	
	

}
