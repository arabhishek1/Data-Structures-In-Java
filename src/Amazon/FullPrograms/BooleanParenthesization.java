package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 06/04/18.
 */

/*
* If we assume T(i,j) is the number of ways to place brackets which will return true then
*
* T(i,j) = For(k= i+1...j)
*          T(i,k)*T(k+1,j) [for '&'] +
*          Total(i,k)*Total(k+1,j) - F(i,k)*F(k+1,j) [for '|'] +
*          T(i,k)*F(k+1,j) + F(i,k)*T(k+1,j) [for '^']
*
*
    Similarly F(i,j)
F(i,j) = For(k= i+1...j)
*          Total(i,k)*Total(k+1,j) - T(i,k)*T(k+1,j) [for '&'] +
*          F(i,k)*F(k+1,j) [for '|'] +
*          T(i,k)*T(k+1,j) + F(i,k)*F(k+1,j) [for '^']
*


      Total(i,j) = T(i,j) + F(i,j)


      Base cases

      T(i,i) = 1 if (symbol = 'T')
      T(i,i) = 0 if (symbol = 'F')

      F(i,i) = 0 if (symbol = 'T')
      F(i,i) = 1 if (symbol = 'F')

*
* */
public class BooleanParenthesization {

    public static int booleanParenthesization(String symbols, String operators) {
        int size = symbols.length();
        int T[][] = new int[size][size];
        int F[][] = new int[size][size];

        for(int i=0; i <size; ++i){
            T[i][i] = (symbols.charAt(i) == 'T') ? 1 : 0;
            F[i][i] = (symbols.charAt(i) == 'F') ? 1 : 0;
        }

        for(int gap=1; gap < size; ++gap){
//            for(int j=0; j < size; ++i){
//                for(int k=1; k < size; ++k){
//
//                }
//            }
        }
        return 0;
    }
}
