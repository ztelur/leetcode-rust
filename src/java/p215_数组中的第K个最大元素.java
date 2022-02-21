package java;

import java.util.Random;

/**
 * 快排
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 * 最大堆和最小堆
 *
 *
 */

class Solution {
    Random rand=new Random();
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums,k,0,nums.length-1);
    }
    private int quickSort(int[] nums,int k,int left,int right){
        // 随机任意找一个。
        int index=rand.nextInt(right-left+1)+left;
        // 将其放在最left上
        int flag=nums[index];
        nums[index]=nums[left];


        int i=left,j=right;
        //
        while (i<j){
            //flag 的右边需要都是小于它的
            while (i<j && nums[j]<=flag) {
                j--;
            }
            // 找到的大于 flag的防止在 i初，第一次i = left，旧值已经被放到 nums[index]了，所以没问题
            nums[i]=nums[j];
            // flag 的左侧需要都是大于自己的
            while (i<j && nums[i]>=flag) {
                i++;
            }
            // 将刚才的位置进行填充
            nums[j]=nums[i];
        }
        // 最后停留的位置，再填入 flag
        nums[i]=flag;
        // i 位置表示前边有i个比自己大的，所以自己就是第 i + 1 大的
        if (i==k-1) {
            return nums[i];
        }
        else if (i<k-1) {
            // 表示比如 i = 2 表示自己是第3大数，而k等于5，要的是第五大的，所以要向right部分遍历
            return quickSort(nums, k, i + 1, right);
        } else {
            // 向 left 部分遍历
            return quickSort(nums,k,left,i-1);
        }
    }


    public int findKthLargestWithHeap(int[] nums, int k) {
        int heapSize = nums.length;

        buildMaxHeap(nums, heapSize);

        // 建立完之后，nums[0] 就是最大的，删除堆顶元素，直到删除了 k - 1 个

        for (int i = nums.length - 1; i >= nums.length - k + 1; i --) {
            // 删除 头部元素，其实就是将其移动到末尾，让末尾的值上来，然后在做调整
            swap(nums, 0, i);
            heapSize --;
            // 然后再次
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];

    }

    public void buildMaxHeap(int[] a, int heapSize) {

        /**
         *    0
         *   1 2
         *  3 4 5 6
         *
         *  所以 （6-2） / 2 = 2；
         *  送一 (5-2) / 2 = 1.5 = 2
         *
         */


        // 从最后一个父节点开始调整每一个节点的子树，数组的长度为 heapSize，因此最后一个节点的位置是 heapSize - 1, 父节点的位置是 (heapSize - 1 -1 ) / 2

        for (int i = (heapSize- 2) / 2; i >=0; i--) {
            maxHeapify(a, i , heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;

        // 如果左子节点在数组内，且比当前父节点大，则将最大值的指针指向左子节点
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }

        // 同理
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        // 如果最大的值不是父亲节点，则交换父亲节点和当前最大值的子节点
        if (largest != i) {
            swap(a, largest, i);
            // 由于交换了父子节点，可能导致子节点的子树有影响，所以对子节点进行处理
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



}