/**
 * Created by abhishek.ar on 02/04/18.
 */
public class Java {

    // java switch case is fall through. i.e, it executes all the statements after first match if break is not used.
    // default gets executed always as well if there is no break prior to that
    public static void main(String[] args) {
        int number = 20;
        switch (number) {
            case 10:
                System.out.println("10");
            case 20:
                System.out.println("20");
            case 30:
                System.out.println("30");
            default:
                System.out.println("Not in 10, 20 or 30");
        }
    }

}
