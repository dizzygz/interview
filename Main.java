package javatar.demo;
//test design pattern

import java.io.*;
import java.lang.IllegalArgumentException;
import java.nio.*;

abstract class  Car{
	abstract Car makeCar();
}

class Forte extends Car{
	Car makeCar(){
		System.out.println("Bingo, you have a Forte now!");

		return new Forte();
	}
}


class BMW extends Car{
	Car makeCar(){
		System.out.println("Bingo, you have a BMW now!");

		return  new BMW();
	}
}

class ForteFactory extends CarFactory{
	public Car makeCar(){
		return (new Forte());
	}
}

class BMWFactoroy extends CarFactory{
	public Car makeCar(){
		return  new BMW();
	}
}
abstract class  CarFactory{
	private static final ForteFactory myForte = new ForteFactory();
	private static final BMWFactoroy myBMW = new BMWFactoroy();

	public static final int CAR_FORTE=1;
	public static final  int CAR_BMW=2;

	public static final CarFactory getFactory(int carType){
		switch(carType){
			case CAR_FORTE:
			return myForte;

			case CAR_BMW:
			return myBMW;

			default:
			String errMsg = Integer.toString(carType);
			throw new IllegalArgumentException(errMsg);

		}
	}

	public abstract Car makeCar();
	
}

public class Main {
	public static void main(String[] args) {
		try{
			Car myCar1 = CarFactory.getFactory(CarFactory.CAR_FORTE).makeCar();
			myCar1.makeCar();

			Car myCar2 = CarFactory.getFactory(4).makeCar();

		}
		catch (IllegalArgumentException e){
				e.printStackTrace();
		}
	}
    
}
