// source: https://leetcode.com/problems/design-most-recently-used-queue/

/*
Design a queue-like data structure that moves the most recently used element to the end of the queue.

Implement the MRUQueue class:

MRUQueue(int n) constructs the MRUQueue with n elements: [1,2,3,...,n].
int fetch(int k) moves the kth element (1-indexed) to the end of the queue and returns it.


Example 1:

Input:
["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
[[8], [3], [5], [2], [8]]
Output:
[null, 3, 6, 2, 2]

Explanation:
MRUQueue mRUQueue = new MRUQueue(8); // Initializes the queue to [1,2,3,4,5,6,7,8].
mRUQueue.fetch(3); // Moves the 3rd element (3) to the end of the queue to become [1,2,4,5,6,7,8,3] and returns it.
mRUQueue.fetch(5); // Moves the 5th element (6) to the end of the queue to become [1,2,4,5,7,8,3,6] and returns it.
mRUQueue.fetch(2); // Moves the 2nd element (2) to the end of the queue to become [1,4,5,7,8,3,6,2] and returns it.
mRUQueue.fetch(8); // The 8th element (2) is already at the end of the queue so just return it.


Constraints:

1 <= n <= 2000
1 <= k <= n
At most 2000 calls will be made to fetch.


Follow up: Finding an O(n) algorithm per fetch is a bit easy. Can you find an algorithm with a better complexity for each fetch call?
*/

import java.util.ArrayList;

public class MRUQueue {
    ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) {
        MRUQueue q = new MRUQueue(8);
        System.out.println(q.fetch(3));
        System.out.println(q.fetch(5));
        System.out.println(q.fetch(2));
        System.out.println(q.fetch(8));
    }
    public MRUQueue(int n) {
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int fetch(int k) {
        //Normal fetch: Time complexity: O(n) because we have to shift elements
        int ans = queue.get(k - 1); // ArrayList in java is 0-indexed
        queue.remove(k-1);
        queue.add(ans); //add removed element to end of arraylist: O(1)
        return ans;

        /* Optimized fetch: Use square root decomposition technique
        You can build chunks of size sqrt(n). For each fetch operation, you can search for the
        chunk which has the ith element and update it (i.e., O(sqrt(n)) per operation),
        and move this element to an empty chunk at the end.
        */
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
