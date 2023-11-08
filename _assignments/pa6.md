---
layout: with-sidebar
index: 8
name: PA6
released-on: "2023-11-08"
---

# CSE 12 Programming Assignment 6

### FileSystem

**This assignment is open to collaboration.**

This assignment will teach you how to use Hash Maps and apply them to implement a basic file searching system.

This PA is due on ** **Wednesday, November 15 at 8:00am** **

## Getting the Code
The starter code is in [https://github.com/ucsd-cse12-f23/cse12-pa6-HashMap](https://github.com/ucsd-cse12-f23/cse12-pa6-HashMap). If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

    If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa6-starter*.

2. Using git clone (requires terminal/command line)

    If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.
    
If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Part 1: An Implementation of `DefaultMap` (17 points)
You’ll provide a fast implementation of an interface called `DefaultMap` in `MyHashMap.java`.  


You will implement all the methods defined in the `DefaultMap` interface. Using [amortized analysis](https://en.wikipedia.org/wiki/Amortized_analysis), you must ensure that each has the specified big-O bound and argue why based on the documentation of any libraries you use or based on your implementation. In each, _n_ represents the number of entries in the map.  
Here is a helpful link to learn more about amortized analysis that gives an example with a dynamic array: http://www.cs.cornell.edu/courses/cs3110/2011sp/Lectures/lec20-amortized/amortized.htm

- `put`, required O(1)
- `replace`, required _O(1)_
- `remove`, required _O(1)_
- `set`, required _O(1)_
- `get`, required _O(1)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(1)_
- `keys`, required _O(n)_

In `MyHashMap.java` you will implement a single constructor that takes two arguments (the
initial capacity and the load factor). This is where you will initialize the instance variables. 
 
### `HashMapEntry<K, V>`
Within `MyHashMap.java`, you are provided the private inner class `HashMapEntry<K, V>`. Use this class to represent your key value pairs in your HashMap. Note it implements the `DefaultMap.Entry<K, V>` interface. Each `HashMapEntry` object has two instance variables (`K key`, `V value`). Use the getters/setters from this class to get the key values and set the values. 

### Instance Variables
- `loadFactor`: the load factor for when to increase the capacity of the HashMap (default = 0.75)
- `capacity`: the overall capacity of the HashMap (initial default = 16)
- `size`: the number of elements in the HashMap
- `buckets` or `entries`: If you would like to using Separate chaining conflict resolution, use the List array `buckets`. If you would like to use Linear Probing for your conflict resoultion, use the array `entries`. For either case, `buckets` or `entries` is where your elements will be stored. However, we **strongly recommend** handling collision using **separate chaining**. 

**Note:** `initialCapacity` must be *non-negative* and `loadFactor` must be *positive*. If either of these conditions are violated, you must throw an `IllegalArgumentException` in your constructor with the appropriate error message. 

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. You may use any methods in the Java collections library to implement them (including helpers like `Collections.sort`). If you don't know how to use a particular library method, interface, or class in the standard Java utils, ask! This is an opportunity to learn about the built-in libraries.
***Note:*** You are not allowed to use the java HashMap library!!!

You may find these useful:
- [`Set`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)
- [`Collection`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)

The pages linked from those may also have useful information. For specific hash map implementation detail, please follow your implementation based on lecture. Your
implementation of `DefaultMap` will be graded automatically by tests that we
provide. 

**Note:** Please make sure that you test your MyHashMap implementation thoroughly before proceeding to part 2 as you will be using your implementation of MyHashMap in part 2.

## Part 2: File System Implementation (16 points)
You are asked to implement a basic unix file system structure to support files look up methods. It is shown in the log history that users tend to search files either by their names, their directories, or their modified dates. After implementing MyHashMap in part 1, you think that a hash map will be a perfect data structure for this task to perform these searches in an efficient way. Your task is to design a simplified file system structure with a hash map that can support users defined filtering methods while making sure that those filtering methods are performed in an efficient way.

You should only modify `FileSystem.java` and `FileData.java` for implementation of the file system. 

*Note*: It's likely that you need to store multiple files with the same name in your computer, therefore our file system support duplicate files with the same name or date in different directories. However, the name should always be unique in each directory.

### FileData
In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. 
#### Instance Variables
##### `name`
The name of the given file in string format.
##### `dir`
The directory of where the file is stored in, represented in a string format.
##### `lastModifiedDate`
The date of when the file is last modified, represented in a string format.

#### Methods
In FileData.java, you will implement and thoroughly test the following methods:

- `public FileData(String name, String directory, String modifiedDate)`
- `public String toString()`

#### `public FileData(String name, String directory, String modifiedDate)`

A *Constructor* that creates an instance of `FileData` object by intializing its instance variables with the given parameters. You may assume that the parameters passed in to the constructor will be non-null.


#### `public String toString()`

A method that returns the string representation of FileData by displaying the file information. It should strictly follow the format of `{Name: file_name, Directory: dir_name,  Modified Date: date}`.



### FileSystem

In our file system, FileSystem class will be used to represent the entire structure of the file system. You should store file's information in the instance variable provided to ensure that the look up times are as efficient as possible.  You are **NOT ALLOWED** to add any additional instance variables or to include any additional imports in `FileSystem.java`.

#### Instance Variables
##### `nameMap`
A MyHashMap that uses file name as the key and a list of FileData as the value.
![](https://i.imgur.com/S2bucAA.png){:width="100%"}
**Illustration to show that "test.txt" is an entry within nameMap that uses filename (String) as a key that maps to an arraylist of all fileData with the same filename but in a different directory.*

##### `dateMap`
A MyHashMap that uses file's date as the key and a list of FileData as the value.
![](https://i.imgur.com/DSqDRBz.png){:width="100%"}
**Illustration to show that "02/01/2021" is an entry within nameMap that uses file's lastModifiedDate (String) as a key that maps to an arraylist of all fileData with the same lastModifiedDate.*


#### Methods
In `FileSystem.java`, you will implement and thoroughly test the following methods:

- `public FileSystem()`
- `public FileSystem(String fileInfo)`
- `public boolean add(String fileName, String directory, String modifiedDate)`
- `public FileData findFile(String name, String directory)`
- `public ArrayList<String> findAllFilesName()`
- `public ArrayList<FileData> findFilesByName(String name)`
- `public ArrayList<FileData> findFilesByName(String modifiedDate)`
- `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
- `public boolean removeByName(String name)`
- `public boolean removeFile(String name, String directory)`

#### `public FileSystem()`
Default constructor that creates a new `FileSystem` object and initializes its instance variable.

#### `public FileSystem(String inputFile)`

*Constructor* that creates a new `FileSystem` object with the given `inputFile` that contains the file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes FileSystem's instance variables and populate FileSystem with each file's information. Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy). We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your FileSystem implementation thoroughly. You may assume that `inputFile` parameter is properly formatted and is non-null.




#### `public boolean add(String fileName, String directory, String modifiedDate)`

This method should create a FileData object with the given file information and add it to the instance variables of FileSystem. This method should return true if the file is successfully added to the FileSystem, and false if a file with the same name already exists in that directory. The default values for `filenName`, `dir`, and `modifiedDate` are `""`, `"/"`, `"01/01/2021"` in case any of these variables is null.


#### `public FileData findFile(String name, String directory)`
This method should return a single FileData object with the given name and directory. You should not modify the FileSystem itself. Return null if such a file does not exist. 

#### `public ArrayList<String> findAllFilesName()`

This method should return an array list of string that represents all unique file names across all directories within the fileSystem. You should not modify the FileSystem itself. Return an empty array list if there is no file in the file system yet.

#### `public ArrayList<FileData> findFilesByName(String name)`

The find method should return a list of FileData with the given name. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesByDate(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate that has at least another file with the same file name in a different directory. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public boolean removeByName(String name)`
This method should remove all the files with the given name in the FileSystem. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.

#### `public boolean removeFile(String name, String directory)`

This method should remove a certain file with the given name and directory. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.

## Testing (3 points)
In the starter code, there are three files where you may add tests:
- MyHashMapTest.java
- FileSystemTest.java
- FileDataTest.java

Write at least **two** tests per file and submit these to Gradescope along with your implementations. This section will be graded based on completion. 

### Style (0 points)
The following files should have good style:
* MyHashMap.java
* FileSystem.java
* FileData.java

To find the full style guideline, follow this link: https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing  

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are recommended but will not be graded. 

On this PA, **all guidelines should be followed**, they are summarized below: 

- file headers
- method headers (not required for test methods)
- Lines cannot be longer than 100 characters
- Inconsistent indentation
- Lines **should not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- descriptive variable names
- magic numbers

## Answers for FAQ
#### FileNotFound Exception
If you receive `FileNotFound` exception when instantiating FileSystem with input.txt in Eclipse Window, make sure to place input.txt in the correct directory since Eclipse for Windows puts the files at the project root, not the `bin` or `src`.

#### Clarification on findFilesInMultDir
For example, if we have following entries in input file: test.txt, /home, 01/01/01 test.txt, /root, 01/01/01 sample.txt, /home, 01/01/01 sample.txt, /root, 02/01/01 text, /home, /02/01/01. Calling `findFilesInMultDir(“01/01/01”)` should return you an array list of {Name: test.txt, Directory: /home, Modified Date: 01/01/01}, {Name: test.txt, Directory: /root, Modified Date: 01/01/01}, {Name: sample.txt, Directory: /home, Modified Date: 01/01/01}.

#### Amortized Analysis Explanation
Amortized Analysis allows us to find a tight bound on the worst case. Sometimes data structures will have a costly operation (for example, the HashTable has `expandCapacity`). However, this operation is not performed very often. Because of this, the data structure should not be considered a costly structure. This is when we would use amortized analysis to average out the costly operations when finding the worst case.

Example: HashTable `set()` In the worst case, this would be O(n).

However, we are not calling `expandCapacity` at every step, so this is not a tight worst case bound. With amortized analysis, we can look at how often `expandCapacity` and find the average cost for the operations. In the image below, we have an example of the cost of adding a value n times. 

![](https://i.imgur.com/Z24BZPd.png)

We can see that `expandCapacity` occurs at the 2nd, 3rd, 5th and 9th steps. We then average the costs over the number of elements that were added and find that the upper bound is 3 which is O(1). So the tight bound for the worst case is O(1). This can also be considered the average case.
So in summary, the amortized analysis focuses on the worst-case runtime per operation rather than per algorithm. It allows us to accurately measure the performance of different data structures that might have occasional costly operations.


## Submitting

#### Part 1 & 2
On the Gradescope assignment **Programming Assignment 6 - code** please submit the following files:

* MyHashMap.java
* MyHashMapTest.java
* FileSystem.java
* FileSystemTest.java
* FileData.java
* FileDataTest.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

## Scoring (36 points total)

- 17 points: implementation of `DefaultMap` [automatically graded]
- 16 points: implemetnation of `FileSystem` and `FileData` [automatically graded]
- 3 point: MyHashMapTest, FileSystemTest, and FileDataTest graded on completition [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that `MyHashMap` and the `FileSystem` you wrote work as expected.
