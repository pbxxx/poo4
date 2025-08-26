import java.util.Scanner;

public class Atividade07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];
        int soma = 0;
        int multiplicacao = 1;
        
        System.out.println("Digite 5 números inteiros:");
        for (int i = 0; i < 5; i++) {
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            multiplicacao *= numeros[i];
        }
        
        System.out.println("Números digitados:");
        for (int i = 0; i < 5; i++) {
            System.out.print(numeros[i] + " ");
        }
        
        System.out.println("\nSoma: " + soma);
        System.out.println("Multiplicação: " + multiplicacao);
    }
}