import java.util.Scanner;

public class Atividade13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] vetor3 = new int[20];
        
        System.out.println("Digite 10 elementos para o primeiro vetor:");
        for (int i = 0; i < 10; i++) {
            vetor1[i] = scanner.nextInt();
        }
        
        System.out.println("Digite 10 elementos para o segundo vetor:");
        for (int i = 0; i < 10; i++) {
            vetor2[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < 10; i++) {
            vetor3[i*2] = vetor1[i];
            vetor3[i*2 + 1] = vetor2[i];
        }
        
        System.out.println("Vetor intercalado:");
        for (int i = 0; i < 20; i++) {
            System.out.print(vetor3[i] + " ");
        }
    }
}