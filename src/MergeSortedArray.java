public class MergeSortedArray {

    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?
     */

    /// first version
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pointer1 = m-1;
        int pointer2 = n-1;

        if (m == 0) {
            for (int i = 0; i <= n-1; i++) {
                nums1[i] = nums2[i];
            }
        } else
            for (int i = (m + n) - 1; i > m-1; i--) {

                if (nums2[pointer2] >= nums1[pointer1]) {

                    nums1[i] = nums2[pointer2];
                    System.out.println(nums2[pointer2] + " foi para posição " + i);
                    pointer2--;

                } else {

                    nums1[i] = nums1[pointer1];
                    System.out.println(nums1[pointer1] + " foi para posição " + i);
                    int aux = 1;
                    while (aux <= (pointer1) && nums1[pointer1 - aux] >= nums2[pointer2] ) {

                        nums1[pointer1 - (aux - 1)] = nums1[pointer1 - aux];
                        System.out.println(nums1[pointer1 - aux] + " foi para posição " + pointer1);
                        aux++;

                    }

                    nums1[pointer1 - (aux-1)] = nums2[pointer2];
                    System.out.println(nums2[pointer2] + " foi para posição " + (pointer1 - (aux-1)));
                    pointer2--;

                }


            }

    }


    /// second version
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int pointer1 = m-1;
        int pointer2 = n-1;
        int position = (m + n) - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {

            if (nums2[pointer2] > nums1[pointer1]) {

                nums1[position] = nums2[pointer2];
                pointer2--;

            } else {

                nums1[position] = nums1[pointer1];
                pointer1--;

            }

            position--;

        }

        while (pointer2 >= 0) {

            nums1[position] = nums2[pointer2];
            pointer2--;
            position--;

        }




    }

}
