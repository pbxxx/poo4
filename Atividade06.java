import java.util.Scanner;

public class Atividade06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] medias = new double[10];
        int contAprovados = 0;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite as 4 notas do aluno " + (i+1) + ":");
            double soma = 0;
            for (int j = 0; j < 4; j++) {
                soma += scanner.nextDouble();
            }
            medias[i] = soma / 4;
            
            if (medias[i] >= 7.0) {
                contAprovados++;
            }
        }
        
        System.out.println("Alunos com média >= 7.0: " + contAprovados);
    }
}