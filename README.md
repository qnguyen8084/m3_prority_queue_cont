# Assignment Overview:
Objective: The primary aim of this assignment is to build upon the concepts introduced in Assignment 1 by implementing the Iterator, Strategy, and Command patterns in your priority queue code. Additionally, you will refine your code, assess the effectiveness of existing unit tests, and add new tests as needed.

## Overview: Produce code with the following functionality:

### Evaluate Unit Tests:
-[ ] Begin by reviewing and utilizing the unit tests created in Assignment 1.
-[ ] Assess the robustness of the tests after incorporating the changes required in this assignment.
-[ ] Reflect on your confidence in the code's functionality post-refactoring. 
*Determine if new tests are necessary to validate the modified code.*

### Refactor Priority Queue Code:
-[x] Enhance the clarity of your code by using standard names for methods.
-[x] Eliminate any unnecessary helper methods, particularly those related to nodes.
-[x] Perform additional cleanup, considering the use of refactoring techniques like "rename" and "move" where applicable.

### Collection Class Integration:
https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
-[x] Identify the appropriate location for your priority queue class within your language's collection class hierarchy.
-[x] Determine and implement all necessary methods to integrate your class seamlessly into the language's collection class hierarchy.

### Parent Class Alignment:
-[x] Set the parent class of your priority queue in accordance with the determined hierarchy.
-[x] Rename existing methods to align with the standards of collection classes.
-[x] Stub any required methods to meet the constraints of the parent class. *Implement only essential methods; not all methods need to be implemented. Add "toArray" and "toString" methods in addition to those from Assignment 1.*

### Strategy Pattern Implementation:
-[x] Employ the strategy pattern to enable dynamic determination of the ordering mechanism for the priority queue during object creation.

### Iterator Implementation:
-[x] Develop an iterator for your strategy pattern class.
-[x] Avoid converting the priority queue to an array or other collection to implement the iterator.
-[x] Choose between implementing an internal or external iterator based on your preferences.

### Command Pattern for Undo Support:
-[ ] Integrate the Command pattern to facilitate undo functionality for your priority queue.
-[ ] Enable the creation of a priority queue, addition and removal of elements, and subsequent undoing of these operations one at a time.

### Unit Testing:
-[ ] Write comprehensive unit tests to validate the functionality of the code developed for this assignment.