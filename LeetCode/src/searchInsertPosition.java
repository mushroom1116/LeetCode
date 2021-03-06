/**
 * Author: Wang Zhaorong
 */
/**
 * 这题要求在一个排好序的数组查找某值value， 如果存在则返回对应index， 不存在则返回能插入到数组中的
 index（保证数组有序） 。
 对于不存在的情况， 我们只需要在数组里面找到最小的一个值大于value的index， 这个index就是我们可以
 插入的位置。 譬如[1, 3, 5, 6]， 查找2， 我们知道3是最小的一个大于2的数值， 而3的index为1， 所以我们需
 要在1这个位置插入2。 如果数组里面没有值大于value， 则插入到数组末尾。
 我们采用二分法解决：
 * */

public class searchInsertPosition {
    public static int searchInsertPosition(int[] A, int target)
    {
        int low = 0;
        int heigh = A.length - 1;
        int mid = 0;

        while (low <= heigh)
        {
            mid = low + (heigh - low)/2;
            if(A[mid] == target)
                return mid;
            else if (A[mid] < target)
                low = mid + 1;
            else heigh = mid - 1;
        }
        return low;
    }

    public static void main(String[] args)
    {
        int[] A = {0,1,4};
        int target = 3;
        System.out.print(searchInsertPosition(A,target));
    }
}
