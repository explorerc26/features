# Nested Classes


The Java programming language allows you to define a class within another class. Such a class is called a nested class

Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes.

Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. 
 
Static nested classes do not have access to other members of the enclosing class.

A nested class can be declared private, public, protected, or package private.


Static Nested Classes

As with class methods and variables, a static nested class is associated with its outer class. And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.

Static nested classes are accessed using the enclosing class name:

OuterClass.StaticNestedClass

For example, to create an object for the static nested class, use this syntax:

OuterClass.StaticNestedClass nestedObject =
     new OuterClass.StaticNestedClass();
	 


Inner Classes


As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields. Also, because an inner class is associated with an instance, it cannot define any static members itself.


To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:

OuterClass.InnerClass innerObject = outerObject.new InnerClass();


There are two special kinds of inner classes: local classes and anonymous classes.

Serialization of inner classes, including local and anonymous classes, is strongly discouraged. Serialization of inner classes, including local and anonymous classes, is strongly discouraged. When the Java compiler compiles certain constructs, such as inner classes, it creates synthetic constructs; these are classes, methods, fields, and other constructs that do not have a corresponding construct in the source code. Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM. However, synthetic constructs can vary among different Java compiler implementations, which means that .class files can vary among different implementations as well. Consequently, you may have compatibility issues if you serialize an inner class and then deserialize it with a different JRE implementation.