import java.io.*;
import java.util.Scanner;

public class Atividade01_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho = 0;
        
        do {
            System.out.print("Digite um número ímpar entre 3 e 11: ");
            tamanho = scanner.nextInt();
        } while (tamanho < 3 || tamanho > 11 || tamanho % 2 == 0);
        
        int[][] matriz = new int[tamanho][tamanho];
        
        System.out.println("Digite os valores da matriz " + tamanho + "x" + tamanho + ":");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        int soma = 0, maior = matriz[0][0], menor = matriz[0][0];
        int pares = 0, impares = 0;
        int diagPrincipal = 0, diagSecundaria = 0;
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                soma += matriz[i][j];
                
                if (matriz[i][j] > maior) maior = matriz[i][j];
                if (matriz[i][j] < menor) menor = matriz[i][j];
                
                if (matriz[i][j] % 2 == 0) pares++;
                else impares++;
                
                if (i == j) diagPrincipal += matriz[i][j];
                if (i + j == tamanho - 1) diagSecundaria += matriz[i][j];
            }
        }
        
        double media = (double) soma / (tamanho * tamanho);
        
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Soma dos elementos: " + soma);
        System.out.printf("Média dos elementos: %.2f\n", media);
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Quantidade de pares: " + pares);
        System.out.println("Quantidade de ímpares: " + impares);
        System.out.println("Soma diagonal principal: " + diagPrincipal);
        System.out.println("Soma diagonal secundária: " + diagSecundaria);
        
        System.out.println("\nMatriz:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            salvarEmArquivo(matriz, soma, media, maior, menor, pares, impares, diagPrincipal, diagSecundaria);
        }
        
        System.out.print("Deseja ler dados de arquivo? (s/n): ");
        opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            lerDeArquivo();
        }
    }
    
    private static void salvarEmArquivo(int[][] matriz, int soma, double media, int maior, 
                                      int menor, int pares, int impares, int diagPrincipal, int diagSecundaria) {
        try (PrintWriter writer = new PrintWriter("matriz_dados.txt")) {
            writer.println("Tamanho: " + matriz.length);
            writer.println("Soma: " + soma);
            writer.println("Média: " + String.format("%.2f", media));
            writer.println("Maior: " + maior);
            writer.println("Menor: " + menor);
            writer.println("Pares: " + pares);
            writer.println("Ímpares: " + impares);
            writer.println("Diagonal Principal: " + diagPrincipal);
            writer.println("Diagonal Secundária: " + diagSecundaria);
            writer.println("Matriz:");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    writer.print(matriz[i][j] + " ");
                }
                writer.println();
            }
            System.out.println("Dados salvos em matriz_dados.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    private static void lerDeArquivo() {
        try (Scanner fileScanner = new Scanner(new File("matriz_dados.txt"))) {
            System.out.println("\n=== DADOS DO ARQUIVO ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado ou erro na leitura: " + e.getMessage());
        }
    }
}