
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        SLR slr = new SLR();
        var scanner = new Scanner(System.in);
        
        float beta1 = slr.b1();
        float beta0 = slr.b0();
        System.out.println("Ecuacion de regresion");
        System.out.println("Y = " + beta0 + " + " + beta1 + "X" );
        
        float R = slr.rCuadrada();
        System.out.println("R2 = " + R*100 + "%");
        
        int X;
        System.out.println("\nEscribe el valor de X: "); 
        X = Integer.parseInt(scanner.nextLine());
        
        float Y = beta0 + beta1 * X;
        System.out.println("\nResultado de la ecuacion cuando X vale " + X);
        System.out.println("Y = " + Y);
        
        System.out.println("\nResultado calculado con R2");
        System.out.println("Y = " + Y * R);
        
    }

}
