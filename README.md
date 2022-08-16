# Java - Functional Programming

This course will teach you Modern Java features like Lambdas,Functional Interfaces, Streams API, Optionals, Functional Interfaces,Date/Time libraries and Parallel Programming. This is **a purely coding based case-study project.** Enjoy programming with Modern Java!!


Begin your learning journey of this case study project in this order below. I have mentioned every single Java package link here to assist your learning. Starting with point (1) below and till the end in that particular order mentioned for a smooth ride. Happy Learning!!

(1) **Start with the lambda expressions first.** In every package folder you will find learning.txt file
This file contains the gist of every concept distilled out for an easier grasp.

Click here Lambdas --> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/lambdas/learning.txt "Lambdas")

Then follow the code samples (Java files) mentioned in the learning.txt file. The code in the Java files have appropriate comments for easier understanding. Type the code in your text editor and compile it using a JDK on your machine. You can download this project itself and import into an IDE of your choice and follow the samples.
The code is free of cost and you can re-use it without giving me any credit. Enjoy the bliss !!

Now follow point (2) and the remaining as mentioned below.

(2)
I have created a new package for the [employee database](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/casestudy "Case study")

The package has two files - "Employee.java" which consists of employee details - name,gender,salary,hobbies,employee ID,address and
department. I have generated getters and setters as well along with the constructor and toString() method.

The "EmployeeDatabase.java" class consists of 8 employee objects and the method returns a list of these 8 employee objects. We will be using these two classes extensively in this case study to build functional interfaces examples
discussed in point (3) and beyond.

(3) **Now understand the functional interfaces**

Click here Functional Interfaces ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/functionalinterface/learning.txt "Functional Interfaces")

There are 9 types of functional interfaces. Study them in the order defined above. The names of the java classes in the package are self-explanatory.

PredicateConsumerCombo.java --> two excellent examples built on the logic of consumer,biconsumer and predicate. Read this after Consumer,biconsumer and predicate. You will have feel better if you can solve these two problems. I promise elation if you can crack them!!


(4) **After functional interfaces, it is time to learn method references and local variables for lambdas**

Click here references ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/referenceslambdas/learning.txt "Method references")

Click here for problems ---> [Problems](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/referenceslambdas "Problems")

(5) **Now it is time to turbo-charge with the Streams API**

Click here for streams api ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/streams/learning.txt "Streams API")

Problems --> [Streams API Problems](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/streams "Streams API")



#### DIFFERENCES between Collections and Streams
---------------------------------------------

| Collections  | Streams |
| ---------------------------------------- | -------------------------------------------- |
|Can add,delete or update elements|Cannot add,delete or update elements in the stream.It is immutable data.|
|Example: List -> lists.add(elem)| NA |
|Elements in the list can be accessed via the indices in any order | Only sequential access is possible for streams |
|Example: lists.get(5);| NA |
|Collection is eagerly constructed|Stream is lazily constructed|
|The collection can be traversed any number of times|Streams can be traversed only once.|
|Performs external iteration to iterate through the elements|Performs internal iteration to iterate through the elements|

6) **The Streams API ends with some other utility functions**

Click here for more streams api ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/streamexamples/learning.txt "Streams API")

Problems --> [Streams API utilities](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/streamexamples "Streams API Utilities")

7**Numeric Streams** -- 3 problems to learn

8) **Terminal operations** --- 7 problems to learn

9) **GroupingByExamples** -- 6 problems to learn here

10) **Parallel streams**

Click here for more parallel streams ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/parallelstreams/learning.txt "Parallel Streams")

Problems --> [Parallel Streams](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/parallelstreams "Parallel Streams")

11) **Optional**

Click here for Optional ---> [learning.txt](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/optional/learning.txt "Optional")

Problems --> [Optional](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/optional "Optional")

12) **Interfaces -- default and static methods**

Problems --> [Interfaces](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/interfaces "Interfaces")

We will first implement the default method "sort" in the List interface and learn comparator chaining examples.

Follow the Method examples.java to learn the sort() and comparator chaining examples.

13) **Date/Time API** 

Problems --> [Date/Time API](https://github.com/hegde10122/ModernJavaLearnings/blob/master/hegde/src/java8/learnings/datetime "Date/Time API")
