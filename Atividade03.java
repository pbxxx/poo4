import java.util.Scanner;

public class Atividade03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;
        
        System.out.println("Digite 4 notas:");
        for (int i = 0; i < 4; i++) {
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }
        
        System.out.println("Notas digitadas:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Nota " + (i+1) + ": " + notas[i]);
        }
        
        double media = soma / 4;
        System.out.println("Média: " + media);
    }
}