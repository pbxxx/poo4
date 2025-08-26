import java.io.*;
import java.util.Scanner;

public class Atividade04_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de atletas: ");
        int n = scanner.nextInt();
        
        String[] nomes = new String[n];
        double[][] saltos = new double[n][5];
        double[] medias = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nAtleta " + (i+1) + ":");
            System.out.print("Nome: ");
            scanner.nextLine(); 
            nomes[i] = scanner.nextLine();
            
            System.out.println("Digite os 5 saltos:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Salto " + (j+1) + ": ");
                saltos[i][j] = scanner.nextDouble();
            }
            
            double soma = 0;
            double pior = saltos[i][0];
            double melhor = saltos[i][0];
            
            for (int j = 0; j < 5; j++) {
                soma += saltos[i][j];
                if (saltos[i][j] < pior) pior = saltos[i][j];
                if (saltos[i][j] > melhor) melhor = saltos[i][j];
            }
            
            medias[i] = (soma - pior) / 4;
            System.out.printf("Média (descartando pior salto): %.2f\n", medias[i]);
        }
        
        int indiceCampeao = 0;
        int indiceUltimo = 0;
        
        for (int i = 1; i < n; i++) {
            if (medias[i] > medias[indiceCampeao]) {
                indiceCampeao = i;
            }
            if (medias[i] < medias[indiceUltimo]) {
                indiceUltimo = i;
            }
        }
        
        System.out.println("\n=== RESULTADOS FINAIS ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("\n%s: ", nomes[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%.2f ", saltos[i][j]);
            }
            System.out.printf("→ Média: %.2f", medias[i]);
        }
        
        System.out.printf("\n\nCampeão: %s (%.2f)\n", nomes[indiceCampeao], medias[indiceCampeao]);
        System.out.printf("Último lugar: %s (%.2f)\n", nomes[indiceUltimo], medias[indiceUltimo]);
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            salvarEmArquivo(nomes, saltos, medias, indiceCampeao, indiceUltimo);
        }
        
        System.out.print("Deseja ler dados de arquivo? (s/n): ");
        opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            lerDeArquivo();
        }
    }
    
    private static void salvarEmArquivo(String[] nomes, double[][] saltos, double[] medias, 
                                      int campeao, int ultimo) {
        try (PrintWriter writer = new PrintWriter("saltos_dados.txt")) {
            writer.println("=== RESULTADOS DOS SALTOS ===");
            for (int i = 0; i < nomes.length; i++) {
                writer.printf("%s: ", nomes[i]);
                for (int j = 0; j < 5; j++) {
                    writer.printf("%.2f ", saltos[i][j]);
                }
                writer.printf("→ Média: %.2f\n", medias[i]);
            }
            
            writer.printf("\nCampeão: %s (%.2f)\n", nomes[campeao], medias[campeao]);
            writer.printf("Último lugar: %s (%.2f)\n", nomes[ultimo], medias[ultimo]);
            
            System.out.println("Dados salvos em saltos_dados.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    private static void lerDeArquivo() {
        try (Scanner fileScanner = new Scanner(new File("saltos_dados.txt"))) {
            System.out.println("\n=== DADOS DO ARQUIVO ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}