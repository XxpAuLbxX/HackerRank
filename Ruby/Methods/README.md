HackerRank Ruby Methods
=======================
Ruby - Methods - Introduction
-----------------------------
In our previous challenges, we have been using methods (def method() .. end construct) to abstract compound operations, perform data manipulations and learn various concepts of the language, without talking in much detail about the concept of methods themselves, and how they are useful for a programmer. In this set of challenges, we will explore the guiding principles behind methods, learn more features and how to use them efficiently in our programs.

In simpler terms, a method is a group of several expressions (block, so to say) that can be referred with a name, can be passed some arguments (input) and are associated with one or more objects.

If you have programmed before, you might notice that the description above sounds almost same as functions in other languages (e.g, Python) except the last part which talks about association with one or more objects. It might be a bit non trivial to comprehend since Classes haven't been introduced, but what it means is that these methods, even though they appear like global functions, are instead private methods of a root Object class on which they are implicitly defined and invoked automatically.

So, when you write -
```
def hello_world
    'Eha! Ruby'
end

> hello_world
'Eha! Ruby'
```
You are essentially adding a private method to Object class -
```
class Object
    private

    def hello_world2
        'Eha! Ruby'
    end
end

> hello_world2
=> 'Eha! Ruby'
```
This, however, is not the focus of this challenge. Instead, it was just to show you the true object nature of Ruby, and we'll return to it again later during our challenges on classes.

In this challenge, you need to write a method prime? that takes an argument and returns true or false depending on if the number is prime or not.
```
> prime? 3
true
> prime? 17
true
> prime? 22
false
```
Further reading

These methods, unlike functions in other object oriented programming language (e.g., Python) are not a first-class citizens, because they cannot be passed to other methods as arguments, returned by other methods, or assigned to variables.

Ruby - Methods - Arguments
--------------------------
In our previous challenge, we learned about methods and how they help us to abstract similar computations into logical chunks of code that otherwise would be very clumsy and difficult to manage. Methods, in a way, also behave like a black box where the programmer should ideally be concerned only with a basic description of the box - what it does, what is it input and what is the expected output, without having to worry about how it does it. This allows us to focus more on the functionality and correctness of program instead of implementation details. In these set of tutorials, we will make the same black box assumptions and focus on building a better understanding of the three aspects described above.

The ability to pass arguments is of critical importance as it determines the complexity and variability of output that we can generate. We have already seen straight forward cases of passing several values as variables to our methods, but however, there's much more to Ruby's methods. Let's examine it with practical scenarios.

Consider a case where you have a method that is invoked from different portions of your code with some variation in one of the arguments. However, you still need to pass a value for the remaining arguments which mostly remain constant through these calls. In such cases, the ability to assign default values to your arguments becomes increasingly useful as it helps you to avoid passing a value for all arguments and decrease chances of making errors. It is quite analogous to an on-demand behavior where you pass an argument only when you need it to affect your output, otherwise let the default action go on.

For example,
```
def prefix(s, len=1)
  s[0,len]
end

> prefix("Ruby", 3) # => "Rub"
> prefix("Ruby")    # => "R"
```
In this challenge, your task is to figure out what take method does using the examples below and implement the method. It should help you understand how to build on implementation through the expected functionality.
```
> take([1,2,3], 1)
[2, 3]
> take([1,2,3], 2)
[3]
> take([1,2,3])
[2, 3]
```
Note

One can invoke method by simply writing name('Foolan', 'Barik') or without the parentheses like name 'Foolan', 'Barik', although the latter convention can be confusing and hence is not recommended.

Ruby - Methods - Variable Arguments
-----------------------------------
In our previous challenges, we explored some ways to pass arguments to our methods; however, they were limited in terms of the number of arguments we can pass to them. Using default parameters allows us to lower the number of arguments in some cases, but it's not helpful in situations where we need to pass a variable (and potentially very large) number of arguments.

Consider a method that computes the sum of numbers. Obviously, you wouldn't want to write different methods accounting for some variable number of arguments (e.g.: summing two numbers, three numbers, four numbers, etc.). This is where Ruby's * comes into play. Take a look at the following code:
```
def sum(first, *rest)
    rest.reduce(first) { |o, x| o + x }
end

> sum(1) # first = 1, rest = []
1
> sum(1, 2) # first = 1, rest = [2]
3
> sum(1, 2, 3) # first = 1, rest = [2, 3]
6
```
Prepending an asterisk (*), or splat, to a parameter assigns all of the values starting from that position in the method call to an array named  inside the method. In this case, our method has at least one required parameter named , and then any subsequent values are assigned as an array to .

Write a method named full_name that generates the full names of people given their first name, followed by some variable number of middle names, followed by their last name.

Sample Input 0
```
> full_name('Harsha', 'Bhogle')
```
Sample Output 0
```
"Harsha Bhogle"
```
Sample Input 1
```
> full_name('Pradeep', 'Suresh', 'Satyanarayana')
```
Sample Output 1
```
"Pradeep Suresh Satayanarayana"
```
Sample Input 2
```
> full_name('Horc', 'G.', 'M.', 'Moon')
```
Sample Output 2
```
"Horc G. M. Moon"
```

Ruby - Methods - Keyword Arguments
----------------------------------
In our previous challenge, we explored one way to pass a variable number of arguments to our methods. While it may seem handy feature to have, except few circumstances, you are never going to use that many variables for your method. Also, if your are passing several different types of variables to the method which then will be assigned to the array, it can be difficult for the programmer invoking the method to remember the proper order for those arguments.

Ruby allows you to (partially) mitigate this problem by passing a Hash as an argument or one of the arguments. For example, you have a method that takes a URI to download a file and another argument containing a Hash of other named options (proxy, timeout, active-connections etc.,)
```
def fetch_file(uri, options)
    if options.has_key?(:proxy)
        # do something
    end
end
```
The main problem with this technique, however, is that you cannot easily set default value for arguments (Read more). Since this construct is highly useful, Ruby 2 introduced keyword arguments which allows you to write -
```
def foo(x, str: "foo", num: 424242)
  [x, str, num]
end

foo(13) #=> [13, 'foo', 424242]
foo(13, str: 'bar') #=> [13, 'bar', 424242]
```
Also, introducing the double splat (**) which similar to it's counterpart collects all the extra named keywords as a hash parameter.
```
def foo(str: "foo", num: 424242, **options)
  [str, num, options]
end

foo #=> ['foo', 424242, {}]
foo(check: true) # => ['foo', 424242, {check: true}]
```
In this challenge, your task is to write a method convert_temp that helps in temperature conversion. The method will receive a number as an input (temperature), a named parameter input_scale (scale for input temperature), and an optional parameter output_scale (output temperature scale, defaults to Celsius) and return the converted temperature. It should perform interconversion between Celsius, Fahrenheit and Kelvin scale.

For example,
```
> convert_temp(0, input_scale: 'celsius', output_scale: 'kelvin')
=> 273.15 
> convert_temp(0, input_scale: 'celsius', output_scale: 'fahrenheit')
=> 32.0
```
Note that the input values are lowercase version of corresponding scales.

Blocks
------
Higher order functions are one of the key components of functional programming.

A higher order function is a tool that takes other functions as parameters or returns them as a result.

Blocks are nameless methods that can be passed to another method as a parameter. 
Passing a block to a method is a great way of data abstraction.

Blocks can either be defined with a keyword do ... end or curly braces { ... }.

Example:

a). Passing a block to a method that takes no parameter

CODE
```
def call_block
    puts "Start of method."
    yield
    puts "End of method."
end 
call_block do 
    puts "I am inside call_block method."
end
```
OUTPUT
```
Start of method.
I am inside call_block method.
End of method.
```
In this example, a block is passed to the call_block method. 
To invoke this block inside the method, we used a keyword, yield. 
Calling yield will execute the code within the block that is provided to the method.

b). Passing a block to a method that takes one or more parameters.

CODE
```
def calculate(a,b)
    yield(a, b)
end

puts calculate(15, 10) {|a, b| a - b}  
``` 
OUTPUT
```
5
```
In this example, we have defined a method calculate that takes two parameters  and . 
The yield statement invokes the block with parameters  and , and executes it.

Task

You are given a partially complete code. Your task is to fill in the blanks (_______). 
The factorial method computes: n! { n x n-1 x ...2 x 1 }.

Procs
-----
Passing blocks is one way to pass functions as arguments to other functions.

Blocks are one of the very few exceptions to the "everything is an object" rule in Ruby. Blocks are not objects, and they can't be saved to variables.

Proc objects are blocks of code that can be bound to a set of local variables. You can think of a proc object as a "saved" block.

Procs are a great way of keeping your code DRY. DRY stands for Do not Repeat Yourself.

Example:

CODE
```
def foo(a, b, my_proc)
    my_proc.call(a, b)
end

add = proc {|x, y| x + y}

puts foo(15, 10, add)
```
OUTPUT
```
25
```
In this example, we have created the proc add, which adds two numbers. 
The proc add is passed as a parameter to the method foo. 
In the method foo, my_proc.call(a, b) executes the proc.

Task

You are given a partially complete code. Your task is to fill in the blanks (______).

The square_of_sum method computes the sum of the elements in an input array and returns the square of the summed elements. 

For example:
```
Input array: [1, 2, 3]
Output: 36
```

Lambdas
-------
Lambdas are anonymous functions. Lambdas in Ruby are objects of the class Proc. 
They are useful in most of the situations where you would use a proc.

The simplest lambda takes no argument and returns nothing as shown below:

Example:
```
#Ruby version <= 1.8
    lambda { .... } 

    lambda do
        ....
    end

#Ruby version >= 1.9, "stabby lambda" syntax is added
    -> { .... }

    -> do
        ....
    end
```
Ruby version >=1.9 can use both lambda and stabby lambda, ->.

Lambdas can be used as arguments to higher-order functions. They can also be used to construct the result of a higher-order function that needs to return a function.

Example:

(a). Lambda that takes no arguments.
```
def area (l, b)
   -> { l * b } 
end

x = 10.0; y = 20.0

area_rectangle = area(x, y).call
area_triangle = 0.5 * area(x, y).()

puts area_rectangle     #200.0
puts area_triangle      #100.0
```
(b). Lambda that takes one or more arguments.
```
area = ->(a, b) { a * b }

x = 10.0; y = 20.0

area_rectangle = area.(x, y)
area_triangle = 0.5 * area.call(x, y)

puts area_rectangle     #200.0
puts area_triangle      #100.0    
```
In the above example, we can see that lambdas can be called using both .call() and .().

Is there any difference between lambdas and procs? 
Yes, there is difference between a proc and a lambda in Ruby.

Task

You are given a partially complete code. Your task is to fill in the blanks (______). 
There are 5 variables defined below:

square is a lambda that squares an integer.
plus_one is a lambda that increments an integer by 1.
into_2 is a lambda that multiplies an integer by 2.
adder is a lambda that takes two integers and adds them.
values_only is a lambda that takes a hash and returns an array of hash values.

Closures
--------
Closure is a function/method that:

► Can be passed around like an object.

It can be treated like a variable, which can be assigned to another variable, passed as an argument to a method.
► Remembers the value of variables no longer in scope.

It remembers the values of all the variables that were in scope when the function was defined. It is then able to access those variables when it is called even if they are in a different scope.
Example:
```
def plus_1(y)
   x = 100
   y.call       #remembers the value of x = 1
end

x = 1
y = -> { x + 1 }
puts plus_1(y)  #2
```
In this example, the variable x, which is closed within the lambda y, remembers its values. Here, x remembers its value as 1.

Blocks, Procs and Lambdas are closures in Ruby.

Task

You are given a partially complete code. Your task is to fill in the blanks (______).

* block_message_printer prints the message if the block exists. 
* proc_message_printer prints the message inside a Proc. 
* lambda_message_printer prints the message inside a Lambda.

Partial Applications
--------------------
In Partial Application, we create a lambda that takes a parameter and returns a lambda that does something with it.

Example:
```
multiply_function = -> (number) do
   -> (another_number) do
       number * another_number
   end
end

doubler = multiply_function.(2)
tripler = multiply_function.(3)

puts doubler.(4)
puts tripler.(4)
```
In the above example, the lambda will take number as a parameter, and return a lambda. When you call this lambda with another_number, it will return the product of the two.

Task

You are given a partially complete code. Your task is to fill in the blanks (_______).

Here, combination is a variable that stores a partial application which computes combination nCr.

Currying
--------
Currying is a technique in which a function accepts n parameters and turns it into a sequence of n functions, each of them take 1 parameter.

Example :-
```
multiply_numbers = -> (x,y) do
    x*y
end

doubler = multiply_numbers.curry.(2)
tripler = multiply_numbers.curry.(3)

puts doubler.(4)    #8
puts tripler.(4)    #12
```
In the above example, lambda take two parameters x, y and return the product of the two. 
multiply_numbers.curry.(2) returns a lambda which takes only one parameter necessary for calculation.

Task

You are given a partially complete code. Your task is to fill in the blanks (_______). 
Write a curry, which pre-fills power_function with variable base.

Lazy Evaluation
---------------
Lazy evaluation is an evaluation strategy that delays the assessment of an expression until its value is needed.

Ruby 2.0 introduced a lazy enumeration feature. Lazy evaluation increases performance by avoiding needless calculations, and it has the ability to create potentially infinite data structures.

Example:
```
power_array = -> (power, array_size) do 
    1.upto(Float::INFINITY).lazy.map { |x| x**power }.first(array_size) 
end

puts power_array.(2 , 4)    #[1, 4, 9, 16]
puts power_array.(2 , 10)   #[1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
puts power_array.(3, 5)     #[1, 8, 27, 64, 125]
```
In this example, lazy avoids needless calculations to compute power_array. 
If we remove lazy from the above code, then our code would try to compute all x ranging from 1 to Float::INFINITY. 
To avoid timeouts and memory allocation exceptions, we use lazy. Now, our code will only compute up to first(array_size).

Task

Your task is to print an array of the first  palindromic prime numbers. 
For example, the first  palindromic prime numbers are [2,3,5,7,11,101,131,151,181,191].

Input Format

A single line of input containing the integer N.

Constraints

You are not given how big N is.

Output Format

Print an array of the first N palindromic primes.

Sample Input
```
5
```
Sample Output
```
[2, 3, 5, 7, 11]
```