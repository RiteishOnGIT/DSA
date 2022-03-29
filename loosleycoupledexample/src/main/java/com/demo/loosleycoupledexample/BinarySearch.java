package com.demo.loosleycoupledexample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.loosleycoupledexample.sorting.SortingAlgorithm;


@Component
public class BinarySearch {
	
	
	@Autowired
	SortingAlgorithm bubbleSort;
	
	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("post construct called");
	}
	
	public int search(int array[], int element) {
		bubbleSort.sort(array);
		return element;
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("pre destroy called");
	}
}
