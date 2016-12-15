package com.explorer.samples;
import java.util.Optional;

public class OptionalTest {
	

	public static void main(String[] args) {
		OptionalTest test = new OptionalTest();
		OptionalTest.A a = test.new A();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(a.getB());
		String text  = a.getB().orElse(test.new B()).getC().orElse(test.new C()).getText().orElse("not present"); 
	
		
	}

	public class A {
		private Optional<B> b;

		public Optional<B> getB() {
			return b;
		}

		public void setB(Optional<B> b) {
			this.b = b;
		}
	}
	public class B{
		private Optional<C> c;

		public Optional<C> getC() {
			return c;
		}

		public void setC(Optional<C> c) {
			this.c = c;
		}
	}
	public class C{
		private Optional<String> text;

		public Optional<String> getText() {
			return text;
		}

		public void setText(Optional<String> text) {
			this.text = text;
		}
	}

}
