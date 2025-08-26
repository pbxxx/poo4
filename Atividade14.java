import java.util.Scanner;

public class Atividade14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[30];
        double[] alturas = new double[30];
        
        System.out.println("Digite idade e altura de 30 alunos:");
        for (int i = 0; i < 30; i++) {
            System.out.print("Aluno " + (i+1) + " - idade: ");
            idades[i] = scanner.nextInt();
            System.out.print("Aluno " + (i+1) + " - altura: ");
            alturas[i] = scanner.nextDouble();
        }
        
        double somaAltura = 0;
        for (int i = 0; i < 30; i++) {
            somaAltura += alturas[i];
        }
        double mediaAltura = somaAltura / 30;
        
        int cont = 0;
        for (int i = 0; i < 30; i++) {
            if (idades[i] > 13 && alturas[i] < mediaAltura) {
                cont++;
            }
        }
        
        System.out.println("Média de altura: " + mediaAltura + "m");
        System.out.println("Alunos com mais de 13 anos e altura inferior à média: " + cont);
    }
}