# Tech Interview Cheatsheet

## Time complexities of different data structures


## Time and space complexity of searching and sorting

|   Algorithm    | Best Time Complexity | Average Time Complexity | Worst Time Complexity  | Worst Space Complexity |
|:--------------:|:--------------------:|:-----------------------:|:----------------------:|:----------------------:|
| Linear search  |         O(1)         |          O(n)           |          O(n)          |          O(1)          |
| Binary search  |         O(1)         |        O(log n)         |        O(log n)        |          O(1)          |
|                |                      |                         |                        |                        |
|  Bubble sort   |         O(n)         |    O(n<sup>2</sup>)     |    O(n<sup>2</sup>)    |          O(1)          |
| Selection sort |   O(n<sup>2</sup>)   |    O(n<sup>2</sup>)     |    O(n<sup>2</sup>)    |          O(1)          |
| Insertion sort |         O(n)         |    O(n<sup>2</sup>)     |    O(n<sup>2</sup>)    |          O(1)          |
|   Merge sort   |       O(nlogn)       |        O(nlogn)         |        O(nlogn)        |          O(n)          |
|   Quick sort   |       O(nlogn)       |        O(nlogn)         |    O(n<sup>2</sup>)    |        O(log n)        |
|   Heap sort    |       O(nlogn)       |        O(nlogn)         |        O(nlogn)        |          O(n)          |
|  Bucket sort   |        O(n+k)        |         O(n+k)          |    O(n<sup>2</sup>)    |          O(n)          |
|   Radix sort   |        O(nk)         |          O(nk)          |         O(nk)          |         O(n+k)         |
|    Tim sort    |         O(n)         |        O(nlogn)         |        O(nlogn)        |          O(n)          |
|   Shell sort   |         O(n)         |  O((nlogn)<sup>2</sup>  | O((nlogn)<sup>2</sup>  |          O(1)          |

![Big O complexity chart](https://github.com/suyogkolte/leetcode/blob/main/Images/Big%20O%20complexity%20chart.png)

## Searching
### Binary Search
1. Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
2. Conditions for applying binary search: 
   1. The arrays or f(x) should be monotonic in nature.
3. Original Formula to find the mid element:
   1. mid = (l + r) / 2
   2. This formula gives ArrayIndexOutOfBoundsException for large values of the int variables l and r
   3. Specifically, it fails if the sum of low and high is greater than the maximum positive int value (2<sup>31</sup> - 1). 
   4. The sum overflows to a negative value, and the value stays negative when divided by two.
4. Revised Formula to find the mid element:
   1. mid = l + ((r - l) / 2)
5. Time complexity: O(log n)



