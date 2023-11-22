---
layout: with-sidebar
index: 10
name: PA8
released-on: "2023-11-22"
---
# CSE 12 Programming Assignment 8

### Heaps

**This assignment is open to collaboration.**

This assignment will teach you how to implement and use Heaps.

This PA is due on ** **Wednesday, November 29 at 8:00am** **

## CSE Mantra: *Start early, start often!*

*You will notice throughout the quarter that the PAs get harder and harder. By starting the quarter off with good habits, you can prepare yourself for future PAs that might take more time than the earlier ones.*


## Getting the Code
The starter code is here: [https://github.com/ucsd-cse12-f23/cse12-pa8-Heap](https://github.com/ucsd-cse12-f23/cse12-pa8-Heap). If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

   If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa4-starter*.

2. Using git clone (requires terminal/command line)

   If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.

If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.


## Part 1: An Implementation of `Heap` 

You will create a file named `Heap.java` where you will implment the `Heap` class. You will implement all the methods defined in the given interface `PriorityQueue.java` in the `Heap` class as well as additional methods described below.

### Import Statements
For `Heap.java`, you are allowed to use the following Java packages:
```
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;
```
*Do **NOT** import any additional packages!*

### `Heap` Class
#### Instance Variables
- `public List<Entry<K, V>> entries`: Instead of creating a tree of entries, we will use a list to maintain the heap structure.
- `public Comparator<K> comparator`: This comparator will be passed into the constructor and will be used to determine which entry objects have more priority based on their keys. This comparator class has one method as follows:

`public int compare(Integer a, Integer b)`: takes in two integers and returns an integer value that represent whether a, takes priority over b. A return value of 0 signifies that the priorities of a and b are equal. A negative return value will signify that a has less priority than b and a positive return value will assume the opposite.

#### Constructor
Your heap implementation will have one constructor that takes a comparator as its argument.
` public Heap(Comparator<K> comparator)`: initializes the instance variables

#### Required Method Descriptions

| Method Name | Description |
|-------------|----------------------|
|`void add(K k, V v)`| Insert a new entry with the given key and value to the end of the heap. Then, `bubbleUp` so that the heap properties are not violated |
|`Entry<K, V> poll()`| Remove and return the root element in the heap. Set the last entry in the heap to the root. Use `bubbleDown` to fix the heap after the removal. If the size is zero, throw `NoSuchElementException()`|
|`Entry<K, V> peek()`| Return the root element of the heap. If the size is zero, throw `NoSuchElementException()`  |
|`List<Entry<K,V>> toArray()`| Return the list of entries. |
|`public boolean isEmpty()`| If the List of entries is empty, return true. Otherwise, return false. |


#### Additional Method Descriptions

| Method Name | Description |
|-------------|----------------------|
|`public int parent(int index)`| Return the parent index. |
|`public int left(int index)`| Return the left child index. |
|`public int right(int index)`| Return the right child index. |
|`public void swap(int i1, int i2)`| Takes the index of two entries and swaps them. |
|`public void bubbleUp(int index)`| A recursive method that moves the entry at the specified `index` to a smaller index (up the tree) while maintaining the heap structure. In the case where the element is equal to the parent, you should **not** swap. |
|`public void bubbleDown(int index)`| A recursive method that moves the entry at the specified `index` to a larger index (down the tree) while maintaining the heap structure. Swap with the child with higher priority. If both chilren are equal and swapping is needed, **swap with the left child**. In the case where the element is equal to the smaller child, you should **not** swap. However, if the child with high priority has greater priority than the parent, you still must swap.|
|`public boolean existsAndGreater(int index1, int index2)`| Returns true if the entry at index1 is greater than that at index2 (Note: Both entries at the specified indicies must exists for this to be true). Return false otherwise.  |
|`public int size()`| Returns the number of elements in `entries`. |
|`public String toString()`| Returns a string representation of the elements in `entries` (this method is helpful for debugging) |

You may find the following link useful:
- [`Comparator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html)


## Part 2: Kth largest/smallest element finder

For part two, you have to write a method to return the kth largest or smallest element from a list of n elements, where n is several times larger than k. An obvious approach to finding the Kth largest/smallest element would be to sort them, which requires O(nlogn) operations. However, this approach becomes inefficient in both time and space with increase in input size. Heaps, on the other hand, provide a much better solution. The run-time complexity with heaps is O(nlogk). Your task is to come with an algorithm to find the kth largest or smallest element using heaps in O(nlogk).

Given a list of n non-negative integers in the form of a file, the `Kth_finder` method would return the Kth largest/smallest number from the input file. File name, value of K and the type of the task ("largest" or "smallest") are the arguments to the function. This function is present inside the ElementFinder class.

For example, input.txt is a file that contains 15 numbers with 5 space-separated numbers in each line. The method Kth_finder("input.txt", 4, "largest") would return 13.

1 4 6 8 9

10 13 14 0 1

98 96 5 3 2

#### Required Method Description

| Method Name | Description |
|-------------|----------------------|
|`public Kth_finder(filename, K, operation)`| Return the Kth largest or Kth smallest element| 

Parameters: 
* filename - String type. Make sure to add proper checks and try/catch conditions.
* K - You can expect K to always be smaller than the size of the input and greater than 0.
* operation - Either "largest" or "smallest"

Reading the file: You should read one line at the time, evaluate all the numbers in that line and then read the next line. You should not load the entire file at once. You can expect test cases where the file size is bigger than the available memory.

Return value: The method should return the kth largest/smallest element if it exists. If no such element exists, the method should return -1.

Algorithm: There are four steps to this algorithm:
* First, figure out the type of heap (Min-Heap or Max-Heap) you will need depending upon the type of operation. There's no programming involved in this step.
* Second, implement the comparators needed for each type of heap. Take a look at the unit test for help.
* The third step is to create a heap that allows you to find the required element in O(nlogk) complexity. What it means is that the bubbleUp/bubbleDown operations should only take about O(logk). Think of the input file as an infinite sequence of numbers. There's no possible way to store all of them. But we can store upto K elements in the form of a heap. So far the complexity is only O(klogk).
* The last step is to use this heap in a way that for every element after the first k, you'd need at most O(logk) operations to figure out if this element should be discarded or stored in the heap.


## Testing
### Heap - HeapTest.java
In the starter code, we provide you with HeapTest which has an example of how to unit test your implementaion. **Note**: For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class. You are required to have at least one unit test written by yourself. 

## Clarification
- You should use `compare` in `existsAndGreater()`, which is where you should check if the indices exists before calling `compare`.
- Your implementation of Heap should simply use the `Comparator` that was passed into it's constructor to do the comparisons. You do not need to specify Min/Max anywhere in your Heap implementation so long as you are correctly using the passed in `Comparator` object.
- `Integer::compare` will result in a max heap. `Collections.reverseOrder(Integer::compare)` will result in a min heap.

## Style (0 points)

The following files should have good style:

* Heap.java
* HeapTest.java
* ElementFinder.java

To find the full style guideline, follow this link: [https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing](https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing)

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are recommended but will not be graded. 

On this PA, **all guidelines should be followed**, they are summarized below:

- file headers
- method headers (not required for test methods)
- Lines should not be longer than 100 characters
- Inconsistent indentation
- Lines **should not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method should have meaningful names
- Helper method should have meaningful names
- descriptive variable names
- magic numbers

## Submitting

#### Part 1 & 2
On the Gradescope assignment **Programming Assignment 8 - code** please submit the following files:

* Entry.java
* PriorityQueue.java
* Heap.java
* ElementFinder.java
* HeapTest.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline.

## Scoring (30 points total)

- 18 points: implementation of `Heap` [automatically graded]
- 11 points: Implementation of `Kth_Finder` [automatically graded]
- 1 point: `HeapTest` graded on completion [manually graded]
