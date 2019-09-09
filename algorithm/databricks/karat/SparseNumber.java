package algorithm.databricks.karat;

public class SparseNumber {
    public static boolean checkIfSparse(int n){
        return (n&(n>>1))==0;
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        for(int i=0;i<=N/2;i++){
            if(checkIfSparse(i)&&checkIfSparse(N-i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        System.out.println(solution(888888888));
    }
}
