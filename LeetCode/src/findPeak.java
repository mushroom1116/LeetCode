/**
 * Author: Wang Zhaorong
/**
 * 这题要求我们在一个无序的数组里面找到一个peak元素， 所谓peak， 就是值比两边邻居大就行了。
 对于这题， 最简单地解法就是遍历数组， 只要找到第一个元素， 大于两边就可以了， 复杂度为O(N)。 但这
 题还可以通过二分来做。
 首先我们找到中间节点mid， 如果大于两边返回当前index就可以了， 如果左边的节点比mid大， 那么我们可
 以继续在左半区间查找， 这里面一定存在一个peak， 为什么这么说呢？假设此时的区间范围为[0, mid -
 1]， 因为num[mid - 1]一定大于num[mid]了， 如果num[mid - 2] <= num[mid - 1]， 那么num[mid - 1]就是一
 个peak。 如果num[mid - 2] > num[mid - 1]， 那么我们就继续在[0, mid - 2]区间查找， 因为num[-1]为负无
 穷， 所以最终我们绝对能在左半区间找到一个peak。 同理右半区间一样*/
public class findPeak {
    public static int findPeak(int[] A)
    {
        int low = 0;
        int heigh = A.length - 1;
        int mid = 0;

        if(A.length == 1)
            return 0;

        while (low <= heigh)
        {
            mid = low + (heigh - low)/2;
            if((mid==0 || A[mid] >= A[mid-1]) && (mid == A.length-1 || A[mid] > A[mid+1]))
                return mid;
            else if(mid > 0 && A[mid-1]>A[mid])
                heigh = mid - 1;
            else
                low = mid + 1;
        }
        return mid;
    }
    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,2};
        System.out.print(findPeak(A));
    }
}
