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


There are two additional types of inner classes. You can declare an inner class within the body of a method. These classes are known as local classes. You can also declare an inner class within the body of a method without naming the class. These classes are known as anonymous classes.

Local Classes

Local classes are classes that are defined in a block, which is a group of zero or more statements between balanced braces. You typically find local classes defined in the body of a method.
A local class has access to the members of its enclosing class. 
In addition, a local class has access to local variables. However, a local class can only access local variables that are declared final. When a local class accesses a local variable or parameter of the enclosing block, it captures that variable or parameter.
However, starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final. 
Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters.
Local classes are similar to inner classes because they cannot define or declare any static members. 
Local classes are non-static because they have access to instance members of the enclosing block. Consequently, they cannot contain most kinds of static declarations.
You cannot declare an interface inside a block; interfaces are inherently static.
A local class can have static members provided that they are constant variables. 

Anonymous Classes

Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time. They are like local classes except that they do not have a name. Use them if you need to use a local class only once.
While local classes are class declarations, anonymous classes are expressions, which means that you define the class in another expression.
An anonymous class is an expression. The syntax of an anonymous class expression is like the invocation of a constructor, except that there is a class definition contained in a block of code.
The anonymous class expression consists of the following:

The new operator

The name of an interface to implement or a class to extend.

Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. Note: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in this example.

A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.

Because an anonymous class definition is an expression, it must be part of a statement.

Like local classes, anonymous classes can capture variables; they have the same access to local variables of the enclosing scope:

An anonymous class has access to the members of its enclosing class.

An anonymous class cannot access local variables in its enclosing scope that are not declared as final or effectively final.

Like a nested class, a declaration of a type (such as a variable) in an anonymous class shadows any other declarations in the enclosing scope that have the same name. See Shadowing for more information.

Anonymous classes also have the same restrictions as local classes with respect to their members:

You cannot declare static initializers or member interfaces in an anonymous class.

An anonymous class can have static members provided that they are constant variables.

Note that you can declare the following in anonymous classes:

Fields

Extra methods (even if they do not implement any methods of the supertype)

Instance initializers

Local classes

However, you cannot declare constructors in an anonymous class.

Lambda
One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear.
Lambda expressions let you express instances of single-method classes more compactly.
A functional interface is any interface that contains only one abstract method. (A functional interface may contain one or more default methods or static methods.)
JDK defines several standard functional interfaces, which you can find in the package java.util.function.

Serialization

You can serialize a lambda expression if its target type and its captured arguments are serializable. However, like inner classes, the serialization of lambda expressions is strongly discouraged.



