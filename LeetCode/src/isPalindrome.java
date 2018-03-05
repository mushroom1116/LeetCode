/**
 * 计算一个数字是否是回文数，就是将这个数字x除以10，保留他的余数，下次将余数乘以10， 加上这个数字除以10后的余数，得到y，直到x为0，得到的y与x一样就是回文数。
 */
public class isPalindrome {
    public static boolean isPalindrome(int x)
    {
        if(x < 0)
            return false;
        else if (x == 0)
            return true;
        else
            {
                int temp = x;
                int y = 0;
                while (temp != 0 )
                {
                    y = y * 10 + temp % 10;
                    temp = temp / 10;
                }
                if (y == x)
                    return true;
                else
                    return false;

            }
    }

    public static void main(String[] args)
    {
        int x = 1221;
        System.out.print(isPalindrome(x));
    }
}
