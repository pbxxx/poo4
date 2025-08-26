import java.util.Scanner;

public class Atividade01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[5];
        
        System.out.println("Digite 5 números inteiros:");
        for (int i = 0; i < 5; i++) {
            vetor[i] = scanner.nextInt();
        }
        
        System.out.println("Números digitados:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }
    }
}