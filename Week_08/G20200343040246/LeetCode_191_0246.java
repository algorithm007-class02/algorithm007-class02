package Week_08.G20200343040246;

public class LeetCode_191_0246 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_191_0246().hammingWeight(12));
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}