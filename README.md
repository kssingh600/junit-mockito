# junit-mockito
---------------Test Doubles-----------------
Different types of test doubles are:
1. Dummy
 - while creating tests if a dependency does not play any role but still come into picture we can create dummy out of it
 - It does not have any business logic 
 - It is an object that is used only for code to compile
2. Fake
  - Fake objects are usually light weight objects used only for testing. They have working implementations, but not as actual production object
  - Fake objects have functional implementation, but its in very basic form
  - Instead of actual production database, we can use an in-memory database, hashmaps or lists etc. in test
3. Stub
  - provides predefined answers to method executions made during the test
  - This behavior is hardcoded programmatically for a particular test 
  - Instead of calling external service, stub is called and it returns back an expected response
4. Mock
  - works similar to spy. mock object records method calls on it, and verifies later that the recorded calls match
  - The assert and behavior verification is done at the mock object
5. Spy
  - spy objects are very similar to stubs, but they record information about how they were executed
  - mostly used with stubbed external dependency + recording evry interaction with external dependency

Mockito Stubbing:
  1. Using static method when() + thenReturn(). It states that 'when' any specific method is called on mock object, 'then return' preconfigured value.
  2. Using Mockito's static method doReturn()+when(). It states that 'do return' preconfigured value, 'when' specific method is called on mock object.
  - Mockito uses equals() method while matching arguments during stubbing
  - In case response is not stubbed for a method, default values are returned when called
    1. Primitive Types: 0
    2. Boolean: false 
    3. Objects and Arrays: null
    4. Collections: Empty collection is returned

Behavior verfication:
  - One of the primary benifit of Mock Object is that once it gets created, it remembers all operations performed on it
  - Behaviour verification help us in verifying that certain mock method was called by System Under Test or not
  - It is done by using verify() method e.g. verify(bookRepository).save(book) ;
  - verify() method checks if a given method was called once and only once with given arguments
  - It uses equals() method to compare the arguments and verify that mock method was called with proper arguments

Mockito Spy
 - Spy objects record information about how they were interacted
 - spies allow us to call all the normal methods of the external dependency while still tracking every interaction. Thus, its very less used test double as actual external dependency is still involved
 - They are also termed as Partial Mock

Behavior Driven Development
 - It is a development process that encourages writing tests in a natural, human readable language that focuses on behavior of the application
 - It defines a style of writing test cases in given, when, then format
 - It also corresponds to AAA testing i.e. Arrange Act Assert
  1. given some values and preconditions (Arrange)
  2. When an action is performed (Act)
  3. then verify/assert the output (Assert)
 - e.g. Given a book, when addBook method is called, then book is saved to database 
 - Mockito library contains a class by name BDDMockito, which introduced BDD style API's

Argument Matchers
- One of the primary benefit of Mockito is ability to perform Stubbing of methods and Behavior verification
- example(Stubbing of methods): when(bookRepository.findBookById("1")).thenReturn(book) ;
- example(Behavior Verification): verify(bookRepository).save(book) ;
- Mockito uses equals() method to compare the arguments and verify that the mock method was called with proper arguments
- Argument matchers are like wildcards where instead of specific input we can specify range or type of inputs
- e.g. instead of using specific string "1234", we can specify any String using anyString() method

Type Argument Matchers
- can match to any type of arguments
Method Name         Matching Rules
any()               any object or null
any(Class<T> clazz) any object of given type or null
anyVararg()         any vararg

specific Type Argument Matchers
- Specific Type Argument Matchers can match to any object of given type
- anyBoolean(): any object of Boolean type or null
- anyByte(): any object of Byte type or null
- anyChar(): any object of Character type or null
- anyDouble(): any object of Double type or null
- anyFloat(): any object of Float type or null
- anyInt(): any object of Integer type or null
- anyLong(): any object of Long type or null
- anyShort(): any object of Short type or null
- anyString(): any object of String type or null

Collection type Argument Matchers
- Collection Type Argument Matchers can match to any collection type based on provided type
- anyCollection(): any object of Collection type or null
- anyList(): any object of List type or null
- anyMap(): any object of Map type or null
- anySet(): any object of Set type or null

String Type Argument Matchers
Method Name             Matching Rules
matches(String regex)   String that matches to given regular expression
startsWith(String s)    String that starts with given string
endsWith(String s)      String that ends with given string
contains(String s)      String that contains the given string
