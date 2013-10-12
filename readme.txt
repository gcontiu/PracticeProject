This is about
- final classes
- final attributes
- immutability

Example from:
http://www.javapractices.com/topic/TopicAction.do?Id=15
http://www.javapractices.com/topic/TopicAction.do?Id=29


Conclusions:
- final attributes must be instantiated inside constructors outside inside the class. But only in one of these places.

The Getters of final primitives, final immutable objects and final mutable object:

- the getter of a final primitive will return a copy of that primitive
    So the internal state will not be changed when the caller uses the getter and then changes the value.

- the getter of an immutable object (String name) returns the immutable object, so its state can not be changed.

- the getter of a mutabale object field allows the caller to change the internal state of the object.
    SOLUTION:
        1.make a defensive copy of the object and return it inside the getter.
        2.make the mutable object immutable.


Final ATTRIBUTES:
- Declaring primitive fields as final automatically ensures thread-safety for that field.


An object is immutable even if it has mutable attributes provided that the caller can not change their state
    eg (return a defensive copy of the mutable attribute)



COLLECTIONS' IMMUTABILITY
- both jdk's  and Guava's ImmutableList allow their elements to have their state changed.
- Collections.unmodifiableList(....) will change its size if the backed list is changed.
- ImmutableList will not change its size according to the backed list.



