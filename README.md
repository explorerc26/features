# features
Streams : The Java API designers are updating the API with a new abstraction called Stream that lets you process data in a declarative way. Furthermore, streams can leverage multi-core architectures without you having to write a single line of multithread code. 

from http://download.java.net/lambda/b78/docs/api/java/util/stream/Stream.html : 
reduce
T reduce(T identity,
       BinaryOperator<T> reducer)
Perform a reduction on the elements of this stream using the provided identity value and an associative reducing function, and return the reduced value. This is equivalent to:
     T result = identity;
     for (T element : this stream)
         result = reducer.apply(result, element)
     return result;
