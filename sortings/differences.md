1. Mergesort vs Quicksort (similar idea - divide & conquer)

  -Mergesort splits the array into two halves, whereas Quicksort might split the array in any ratio, depending on where the position of pivot is.
  -Mergesort is O(nlogn) time and O(n) extra space (since the branches are executed sequentially at any given point of time we are using no more than 3n extra memory)
  -Mergesort does not need random access much, so it is better for linked-lists
  -Quicksort sorts the array in place, but sometimes might get to the worst-case O(n^2). Say if we choose pivot to be the last element and the array is sorted. There are
  different methods for choosing pivot.
  -Mergesort is external, because it accesses elements sequentially and hence is cache efficient, while Quicksort in general accesses elements randomly.
  -Mergesort is stable, quicksort is unstable, but can be made stable in some implementations. Naive one would be to use extra memory to preserve order.
  -Quicksort is more efficient on smaller datasets.
  -Quicksort should never be used in cases, which require guaranteed response time. 
 
 2. Heapsort
 
  -Heapsort is inplace, but because of the specifics of heap storage in memory is not cache-effecient. 
  -Heapsort is not stable
  
