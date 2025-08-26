import java.util.Scanner;

public class Atividade02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vetor = new double[10];
        
        System.out.println("Digite 10 números reais:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.nextDouble();
        }
        
        System.out.println("Números na ordem inversa:");
        for (int i = 9; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
}