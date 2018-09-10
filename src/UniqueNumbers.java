public class UniqueNumbers {

    public static int factorial(int n){
        int factorial =1;
        for(int i=n; i > 0 ; --i){
            factorial = factorial *i;
        }
        return factorial;
    }
    public static int findUnique(int n){
        int permutationOfNumberWithZeroes = factorial(10)/factorial(10-n);
        int permutationOfNumberWithoutZeroes = permutationOfNumberWithZeroes -
                (factorial(9)/factorial(9-n+1));
        return permutationOfNumberWithoutZeroes;
    }

    public static void main(String[] args) {
        System.out.println(findUnique(1));
    }
}
