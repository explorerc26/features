package com.explorer.samples;

public class Shadow {

	public int x = 100;

	class InnerClass {
		
		public int x = 200;

		void simpleMethod(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("InnerClass.this.x = " + InnerClass.this.x);
			System.out.println("Shadow.this.x = " + Shadow.this.x); // qualified this
		}
	}

	public static void main(String... args) {
		Shadow st = new Shadow();
		Shadow.InnerClass fl = st.new InnerClass();
		fl.simpleMethod(300);
		
		//qualified this 
//		Any lexically enclosing instance (§8.1.3) can be referred to by explicitly qualifying the keyword this.
//		Let C be the class denoted by ClassName. Let n be an integer such that C is the n'th lexically enclosing class of the class in which the qualified this expression appears.
//		The value of an expression of the form ClassName.this is the n'th lexically enclosing instance of this.
//		The type of the expression is C.
//		It is a compile-time error if the current class is not an inner class of class C or C itself.
	}
}
