package com.explorer.samples;

import java.util.Calendar;

public class Synthetic {
	// Any constructs introduced by the compiler that do not have a
	// corresponding construct in the source code must be marked as
	// synthetic, except for default constructors and the class initialization
	// method.

	// When an enclosing class accesses a private attribute of a nested class,
	// Java compiler creates synthetic method for that attribute. If there is a
	// getter method available in source then this synthetic method will not be
	// created.

	// A class member that does not appear in the source code must be marked
	// using a Synthetic attribute, or else it must have its ACC_SYNTHETIC flag
	// set. The only exceptions to this requirement are compiler-generated
	// methods which are not considered implementation artifacts, namely the
	// instance initialization method representing a default constructor of the
	// Java programming language (§2.9), the class initialization method (§2.9),
	// and the Enum.values() and Enum.valueOf() methods..

	public static void main(String[] args) {

		Synthetic.NestedClass nested = new Synthetic.NestedClass();
		System.out.println("String: " + nested.variable1);

		// use javap against the class you see synthetic method
		//a synthetic method with the name access$100 has been created on the
		// nested class NestedClass to provide its private String to the
		// enclosing class.
	}

	private static final class NestedClass {
		private String variable1 = "this is sample";
		private int variable2 = 1;
	}

}
