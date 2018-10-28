package studyAlgorithm.ch01;

/**
 * 欧几里得算法 最小公约数
 * @author ChaoChao
 *
 */
public class Gcd {

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b); 
    }
    public static void main(String[] args) {
        System.out.println(gcd(2,6));
    }
}
