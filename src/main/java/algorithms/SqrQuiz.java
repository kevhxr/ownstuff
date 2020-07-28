package algorithms;

public class SqrQuiz {


    static double EPSILON = 0.0000000001;
    public static void main(String[] args) {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            System.out.println(high+" "+low+" "+(high-low)+" "+ EPSILON);
            mid = (high + low) / 2;
        }

        System.out.println(mid);
    }
}
