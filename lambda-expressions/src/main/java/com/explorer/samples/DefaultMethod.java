package com.explorer.samples;

//Java 8 introduces a new concept of default method implementation 
//in interfaces. This capability is added for backward compatibility 
//so that old interfaces can be used to leverage the lambda expression capability of Java 8
public class DefaultMethod {

	public static void main(String[] args) {

	}

	
	public interface ExampleA{
		
		public int methodai();
		
		public default int methoda(){
			return 0 ; 
		}
		//same default method name in two interfaces
		default public int method(){
			return 0 ; 
		}
		
//		default public int methodTest(){
//			return 0 ; 
//		}
	}
	
	public interface ExampleB{
		
		public int methodbi();
		
		default int methodb(){
			return 0 ; 
		}
		
		default public int method(){
			return 0 ; 
		}
		
//		default public float methodTest(){
//			return 0 ; 
//		}
	}
	
	public class ExampleAB implements ExampleA, ExampleB{

		@Override
		public int methodbi() {
			return 0;
		}

		@Override
		public int methodai() {
			return 0;
		}

		@Override
		public int method() {
			return 0;
		}


		
	}
	
}
