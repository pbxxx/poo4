import java.util.Scanner;

public class Atividade15 {
    public static void main(String[] args) {
        final int N = 5; 
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[N];
        
        System.out.println("Digite " + N + " valores entre 0 e 20:");
        
        for (int i = 0; i < N; i++) {
            int valor;
            do {
                System.out.print("Valor " + (i+1) + ": ");
                valor = scanner.nextInt();
                if (valor < 0 || valor > 20) {
                    System.out.println("Valor inválido! Digite entre 0 e 20.");
                }
            } while (valor < 0 || valor > 20);
            valores[i] = valor;
        }
        
        System.out.println("\nGrágico de valores:");
        for (int i = 0; i < N; i++) {
            System.out.print(valores[i] + ": ");
            for (int j = 0; j < valores[i]; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}