/**
 * Author: Wang Zhaorong
 */
public class missingNumber {
    public static int missingNumber(int[] nums)
    {
        int x = 0;
        for(int i=0; i<= nums.length; i++)
            x = x ^ i;
        for(int n : nums)
            x = x ^ n;
        return x;
    }

    public static void main(String[] args)
    {
        int[] nums = {0, 1, 2, 3, 5, 6, 7};
        System.out.print(missingNumber(nums));
    }
}
