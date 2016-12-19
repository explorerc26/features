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
		//String text  = a.getB().orElse(test.new B()).getC().orElse(test.new C()).getText().orElse("not present"); 
		//test1
		
		// not allowerd
		//Optional<A> r1 = Optional.of(null);
		
		Optional<A> r1 = Optional.of(a);
		
		Optional<A> r2 = Optional.ofNullable(null);
		System.out.println("r2 : "+r2);
		System.out.println("r2 getB: "+r2.flatMap(A::getB)); // returns empty not null
		System.out.println("Printing value of B");
		r2.ifPresent(System.out::print);
		System.out.println("Printing value of B done");
		//exception
		//System.out.println("r2 A : "+r2.get());
		
		Optional<String> result1  = Optional.empty();
		System.out.println(result1);
		
		Optional<A> r3 = Optional.ofNullable(null);
		A aa = r3.orElse(a);
		System.out.println("aa: "+aa);
		
		
		Optional<String> result  = a.getB().flatMap(B::getC).map(C::getText).orElse(Optional.empty());
		System.out.println("result"+result);
		
		
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
