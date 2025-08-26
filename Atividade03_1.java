import java.io.*;
import java.util.Scanner;

public class Atividade03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de alunos: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        String[] nomes = new String[n];
        double[][] notas = new double[n][2];
        double[] medias = new double[n];
        double somaGeral = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nAluno " + (i+1) + ":");
            System.out.print("Nome: ");
            nomes[i] = scanner.nextLine();
            
            System.out.print("Nota 1: ");
            notas[i][0] = scanner.nextDouble();
            System.out.print("Nota 2: ");
            notas[i][1] = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer
            
            medias[i] = (notas[i][0] + notas[i][1]) / 2;
            somaGeral += medias[i];
        }
        
        double mediaGeral = somaGeral / n;
        
        double maiorNota = notas[0][0];
        double menorNota = notas[0][0];
        String alunoMaiorNota = nomes[0];
        String alunoMenorNota = nomes[0];
        
        double maiorMedia = medias[0];
        double menorMedia = medias[0];
        String alunoMaiorMedia = nomes[0];
        String alunoMenorMedia = nomes[0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (notas[i][j] > maiorNota) {
                    maiorNota = notas[i][j];
                    alunoMaiorNota = nomes[i];
                }
                if (notas[i][j] < menorNota) {
                    menorNota = notas[i][j];
                    alunoMenorNota = nomes[i];
                }
            }
            
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
                alunoMaiorMedia = nomes[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
                alunoMenorMedia = nomes[i];
            }
        }
        
        System.out.println("\n=== DADOS DOS ALUNOS ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s: Nota1=%.1f, Nota2=%.1f, Média=%.1f\n", 
                             nomes[i], notas[i][0], notas[i][1], medias[i]);
        }
        
        System.out.printf("\nMaior nota: %.1f (%s)\n", maiorNota, alunoMaiorNota);
        System.out.printf("Menor nota: %.1f (%s)\n", menorNota, alunoMenorNota);
        System.out.printf("Maior média: %.1f (%s)\n", maiorMedia, alunoMaiorMedia);
        System.out.printf("Menor média: %.1f (%s)\n", menorMedia, alunoMenorMedia);
        System.out.printf("Média geral: %.1f\n", mediaGeral);
        
        System.out.println("\n=== ALUNOS ACIMA DA MÉDIA ===");
        for (int i = 0; i < n; i++) {
            if (medias[i] > mediaGeral) {
                System.out.printf("%s: %.1f\n", nomes[i], medias[i]);
            }
        }
        
        System.out.println("\n=== ALUNOS ABAIXO DA MÉDIA ===");
        for (int i = 0; i < n; i++) {
            if (medias[i] < mediaGeral) {
                System.out.printf("%s: %.1f\n", nomes[i], medias[i]);
            }
        }
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            salvarEmArquivo(nomes, notas, medias, mediaGeral, maiorNota, menorNota, 
                           alunoMaiorNota, alunoMenorNota, maiorMedia, menorMedia, 
                           alunoMaiorMedia, alunoMenorMedia);
        }
        
        System.out.print("Deseja ler dados de arquivo? (s/n): ");
        opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            lerDeArquivo();
        }
    }
    
    private static void salvarEmArquivo(String[] nomes, double[][] notas, double[] medias, 
                                      double mediaGeral, double maiorNota, double menorNota,
                                      String alunoMaiorNota, String alunoMenorNota,
                                      double maiorMedia, double menorMedia,
                                      String alunoMaiorMedia, String alunoMenorMedia) {
        try (PrintWriter writer = new PrintWriter("alunos_dados.txt")) {
            writer.println("=== DADOS DOS ALUNOS ===");
            for (int i = 0; i < nomes.length; i++) {
                writer.printf("%s: Nota1=%.1f, Nota2=%.1f, Média=%.1f\n", 
                             nomes[i], notas[i][0], notas[i][1], medias[i]);
            }
            
            writer.printf("\nMaior nota: %.1f (%s)\n", maiorNota, alunoMaiorNota);
            writer.printf("Menor nota: %.1f (%s)\n", menorNota, alunoMenorNota);
            writer.printf("Maior média: %.1f (%s)\n", maiorMedia, alunoMaiorMedia);
            writer.printf("Menor média: %.1f (%s)\n", menorMedia, alunoMenorMedia);
            writer.printf("Média geral: %.1f\n", mediaGeral);
            
            writer.println("\nAlunos acima da média:");
            for (int i = 0; i < medias.length; i++) {
                if (medias[i] > mediaGeral) {
                    writer.printf("%s: %.1f\n", nomes[i], medias[i]);
                }
            }
            
            System.out.println("Dados salvos em alunos_dados.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    private static void lerDeArquivo() {
        try (Scanner fileScanner = new Scanner(new File("alunos_dados.txt"))) {
            System.out.println("\n=== DADOS DO ARQUIVO ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}