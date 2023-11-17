---
layout: with-sidebar
index: 9
name: PA7
released-on: "2023-11-15"
---

# CSE 12 Programming Assignment 7

### Binary Search Trees

**This assignment is open to collaboration.**

This assignment will teach you how to implement a Binary Search Tree and use it to order and filter data from a text file. 

### Deadlines

This PA is due on ** **Wednesday, November 22 at 8:00am** **

## CSE Mantra: *Start early, start often!*

*You will notice throughout the quarter that the PAs get harder and harder. By starting the quarter off with good habits, you can prepare yourself for future PAs that might take more time than the earlier ones.*


## Getting the Code

The starter code is here: [https://github.com/ucsd-cse12-f23/cse12-pa7-BST](https://github.com/ucsd-cse12-f23/cse12-pa7-BST). If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

   If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa4-starter*.

2. Using git clone (requires terminal/command line)

   If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.

If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Part 1: An Implementation of `DefaultMap` (18 points)

You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map.

- `put`, required O(n)
- `replace`, required _O(n)_
- `remove`, required _O(n)_
- `set`, required _O(n)_
- `get`, required _O(n)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_
- `keys`, required _O(n)_

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!

## Part 2: File System Filtering (16 points)

 <hr />

### FileData 

 <hr />

In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. This is the same FileData from PA6 so feel free to reuse your code!

#### Instance Variables

##### `name`

The name of the given file in string format.

##### `dir`

The directory of where the file is stored, represented in a string format.

##### `lastModifiedDate`

The date of when the file is last modified, represented in a string format. Format: yyyy/mm/dd

#### Methods

In FileData.java, you will implement and thoroughly test the following methods:

- `public FileData(String name, String directory, String modifiedDate)`
- `public String toString()`

#### `public FileData(String name, String directory, String modifiedDate)`

A *constructor* that creates an instance of `FileData` object by intializing its instance variables with the given parameters. You may assume that the parameters passed in to the constructor will be non-null.


#### `public String toString()`

A method that returns the string representation of FileData by displaying the file information. It should strictly follow the format of `{Name: file_name, Directory: dir_name,  Modified Date: date}`.

 <hr />

### FileSystem

 <hr />

The FileSystem class will be used to represent the entire structure of the file system. You should store the file information in the instance variables provided to ensure that the lookup times are as efficient as possible.  You are **NOT ALLOWED** to add any additional instance variables or include any additional imports in `FileSystem.java`.

## Instance Variables

##### `nameTree`

A BST that uses the file name as the key and the `FileData` as the value.  

![](https://i.imgur.com/sU5Fmov.png){:width="100%"}

##### `dateTree`

A BST that uses the file date in a different format (format: yyyy/mm/dd) as the key and a list of FileData as the value. This list should keep track of the files in the order that they arrive in.   

![](https://i.imgur.com/jXJqMJg.png){:width="100%"}



## FileSystem Methods

In `FileSystem.java`, you will implement and thoroughly test the following methods:

- `public FileSystem()`
- `public FileSystem(String inputFile)`
- `public void add(String name, String dir, String date)`
- `public ArrayList<String> findFileNamesByDate(String date)`
- `public FileSystem filter(String startDate, String endDate)`
- `public FileSystem filter(String wildCard)`
- `public List<String> outputNameTree()`
- `public List<String> outputDateTree()`


#### `public FileSystem()`

Default constructor that creates a new `FileSystem` object and initializes its instance variable.

#### `public FileSystem(String inputFile)`

*Constructor* that creates a new `FileSystem` object with the given `inputFile` that contains the file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes FileSystem's instance variables and populate FileSystem with each file's information.   
Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 2021/02/01`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy).  
We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your FileSystem implementation thoroughly.   
You may assume that `inputFile` parameter is properly formatted and is non-null.


#### `public void add(String name, String dir, String date)`

This method should create a FileData object with the given file information and add it to the instance variables of FileSystem. If there is a duplicate file name, then the FileData with the most recent date should be used. For example, if the first FileData stored in the trees is `test.txt, /home, 2021/01/01` and the next FileData is `test.txt, /home, 2021/02/01`, the second FileData should *replace* the first FileData stored in the trees.   

Here is another example: Let File1 be `mySample1.txt, /root, 2021/02/01` and File2 be `mySample1.txt, /root, 2023/02/01`. Before we add File2, assume that we already have File1 in the `FileSystem`. In this situation, check which file is the most recent. If the original file was more recent, keep it and do not change the trees. If the new file is more recent, update `nameTree` and `dateTree`. Note that `dateTree` now has a new key and needs to be removed from the original list. In this example, before we add File2, `dateTree` should have “2021/02/01” as the key and File1 in the value. Since File2 has the same name as File1 but a more recent date, File1 should be removed from the ArrayList associated with the date “2021/02/01” and File2 should be added to the ArrayList associated with the date “2023/02/01”. 

Note that since we are using yyyy/mm/dd as our date format now, you can use Java's `compareTo()` method to compare two dates and determine which one is more recent. To read more on the usage of `compareTo()`, see [this documentation](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html#compareTo(java.lang.String)).

If the `name`, `dir`, or `date` is `null`, then do not add anything to the FileSystem.

Follow this table for further clarification on when to add or update the trees
![](https://i.imgur.com/5eCBBJ9.png){:width="100%"}

#### `public ArrayList<String> findFileNamesByDate(String date)`

Given a `date` (format: yyyy/mm/dd), return an ArrayList of file names that correspond to this date. This list should have the file names in the order that they were added.


If the `date` given is `null`, return `null`.

#### `public FileSystem filter(String startDate, String endDate)`

Given a `startDate` and an `endDate` (format: yyyy/mm/dd), return a new FileSystem that contains only the files that are within the range (`startDate` is inclusive, `endDate` is exclusive).
Assume the given parameters are valid and non-null.  

Example: Let's call `filter("2021/01/20", "2021/02/02")` on a `FileSystem` with the following `dateTree`:   

![](https://i.imgur.com/Ic1sTIw.png){:width="100%"}




It should return a **FileSystem** with a `dateTree` that looks like the following (note: there should be a populated `nameTree` with the same entries):   

![](https://i.imgur.com/N1YIzHe.png)



#### `public FileSystem filter(String wildCard)`

Give a string `wildCard`, return a new FileSystem that contains only the files with names that contain the `wildCard` string. Note that this wildcard can be found anywhere in the file name (if the wild card is `test`, then `test.txt`, `thistest.txt` and `thistest` would all be files that should be selected in the filter)  
Assume the given parameter is valid and non-null. 

Example: Let's call `filter("mySam")` on a `FileSystem` with the following `nameTree`:  

![](https://i.imgur.com/sU5Fmov.png){:width="100%"}



It should return a **FileSystem** with a `nameTree` that looks like the following (note: there should be a populated `dateTree` as well - it is not shown here):   

![](https://i.imgur.com/AmAoKzW.png)


#### `public List<String> outputNameTree()`

Return a List<String> that contains the `nameTree` where each entry is formatted as:    
"<file name>: <FileData toString()>"  

This list should be in alphabetical order. In the examples below, the quotations are there to indicate that the outputs are strings, thus " should not show up in the actual output.   

Input file: 

```
mySample.txt, /home, 2021/02/01
mySample1.txt, /root, 2021/02/01
mySample2.txt, /user, 2021/02/06
```

Example Output: 

```
["mySample.txt: {Name: mySample.txt, Directory: /home, Modified Date: 2021/02/01}", 
"mySample1.txt: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}", 
"mySample2.txt: {Name: mySample2.txt, Directory: /user, Modified Date: 2021/02/06}"]

```

#### `public List<String> outputDateTree()`

Return a List<String> that contains the `dateTree` where each entry is formatted as:  
"<date>: <FileData toString()>"  

The List should be in order from most recent to oldest. If there are multiple files associated with the same date, add them to the List in reverse order they were added into the ArrayList (see example below).

Input file: 

```
mySample.txt, /home, 2021/02/01
mySample1.txt, /root, 2021/02/01
mySample2.txt, /user, 2021/02/06
```

Example Output:

```
["2021/02/06: {Name: mySample2.txt, Directory: /user, Modified Date: 2021/02/06}", 
"2021/02/01: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}", 
"2021/02/01: {Name: mySample.txt, Directory: /home, Modified Date: 2021/02/01}"]
```

 <hr />

## Testing

 <hr />

### BSTTest.java and FileSystemTest.java

For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. You don't need to write tests for any constructor that you choose to create in `BST.java`.



## Answers for FAQ
* **About creating your own constructors** `FileSystem` should have constructor descriptions in the writeup and is included in the starter code. For `BST`, we will be using the default constructor when testing your code so account for this when creating your own instance variables. In other words, your methods should assume that only the default constructor is being used. As for `Node`, this is a private class only in `BST` so you are welcome to write whatever you see fit. We will not be testing it directly
* The `get()` method should return null if the key is not found
* If you are getting an exception on a gradescope sanity test, make sure that the structure of `dateTree` is correct. The key of the tree is a date in yyyy/mm/dd format
* **About** `<? super K>` The generic type `K` extends `Comparable` which is an interface. It means it can only be a type that has implemented the interface `Comparable` as these support comparisons. To see a list of types in Java that already do this and examples check out the table in this link: https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html. You can think of `<? super K>` as `<K itself or one of K's superclasses>`. For example, if I had `<? super Integer>`, this includes `<Integer>`, `<Number>`, and `<Object>`. I wouldn't worry too much about understanding this as it is beyond the scope of the course but it is good Java knowledge.
* **Why is the Node class static?** This is common for nested classes to make the implementation cleaner. We essentially don’t want `Node` to have access to `BST`'s instance variables. To learn more check out the documentation here: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
* In the output example, the “” are there to emphasize that the elements in the list are Strings
* You are allowed to use code provided in lecture or discussion
* **About “alphabetical” order** It is derived from `compareTo()` result

## Style (0 points)

The following files should have good style:

* BST.java
* BSTTest.java
* FileData.java
* FileSystem.java
* FileSystemTest.java

To find the full style guideline, follow this link: [https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing](https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing  )

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are recommended but will not be graded. 

On this PA, **most guidelines should be followed**, they are summarized below: 

- file headers
- method headers (not required for test methods)
- Lines cannot be longer than 100 characters
- Inconsistent indentation
- Lines **should not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- magic numbers

## Submitting

#### Part 1 & 2

On the Gradescope assignment **Programming Assignment 7 - code** please submit the following file structure:

* BST.java
* BSTTest.java
* FileData.java
* FileSystem.java
* FileSystemTest.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

## Scoring (36 points total)

- 18 points: implementation of `DefaultMap` [automatically graded]
- 16 points: implementation of `FileSystem` [automatically graded]
- 2 point: BSTTest and FileSystemTest graded on completition [manually graded]





