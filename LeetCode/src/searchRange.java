/**
 * Author: Wang Zhaorong
 */

/**
 * 这题要求在一个排好序可能有重复元素的数组里面找到包含某个值的区间范围。 要求使用O(log n)的时间，
 所以我们采用两次二分查找。 首先二分找到第一个该值出现的位置， 譬如m， 然后在[m, n)区间内第二次二
 分找到最后一个该值出现的位置。 代码如下：
 */
public class searchRange {
    public static int[] searchRange(int[] A, int target)
    {
        int[] res = new int[2];
        //边角判断
        if(A.length == 0)
        {
            res[0]=res[1]=-1;
            return res;
        }

        int length = A.length;
        int low = 0;
        int heigh = length-1;
        int mid = 0;

        //寻找第一个位置
        while(low <= heigh)
        {
        mid = low + (heigh - low)/2;
        if(A[mid] >= target)
            heigh = mid - 1;
        else low = mid + 1;
        }

        if (low < length && A[low]==target)
            res[0] = low;
        else
            {
                res[0]=res[1]=-1;
                return res;
            }
        //寻找第二个位置
        heigh = length - 1;
        while (low <= heigh)
        {
            mid = low + (heigh - low)/2;
            if(A[mid] <= target)
                low = mid + 1;
            else heigh = mid - 1;
        }
        res[1] = heigh;
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {0, 1, 2, 8, 8, 8, 8, 9, 10, 11};
        int target = 8;
        int[] res = searchRange(A, target);
        for(int a:res)
            System.out.print(a+",");
    }
}
