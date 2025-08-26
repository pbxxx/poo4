import java.util.Scanner;

public class Atividade05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[20];
        int[] pares = new int[20];
        int[] impares = new int[20];
        int contPares = 0, contImpares = 0;
        
        System.out.println("Digite 20 números inteiros:");
        for (int i = 0; i < 20; i++) {
            numeros[i] = scanner.nextInt();
            if (numeros[i] % 2 == 0) {
                pares[contPares++] = numeros[i];
            } else {
                impares[contImpares++] = numeros[i];
            }
        }
        
        System.out.println("Todos os números:");
        for (int i = 0; i < 20; i++) {
            System.out.print(numeros[i] + " ");
        }
        
        System.out.println("\nNúmeros pares:");
        for (int i = 0; i < contPares; i++) {
            System.out.print(pares[i] + " ");
        }
        
        System.out.println("\nNúmeros ímpares:");
        for (int i = 0; i < contImpares; i++) {
            System.out.print(impares[i] + " ");
        }
    }
}