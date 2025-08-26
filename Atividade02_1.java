import java.io.*;
import java.util.Scanner;

public class Atividade02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int PRODUTOS = 5;
        final int SUPERMERCADOS = 5;
        double[][] precos = new double[PRODUTOS][SUPERMERCADOS];
        
        // Entrada de dados
        for (int i = 0; i < PRODUTOS; i++) {
            System.out.println("\nProduto " + (i+1) + ":");
            for (int j = 0; j < SUPERMERCADOS; j++) {
                System.out.print("Supermercado " + (j+1) + ": R$ ");
                precos[i][j] = scanner.nextDouble();
            }
        }
        
        double[] mediaProdutos = new double[PRODUTOS];
        double[] somaSupermercados = new double[SUPERMERCADOS];
        double totalGeral = 0;
        
        for (int i = 0; i < PRODUTOS; i++) {
            double somaProduto = 0;
            for (int j = 0; j < SUPERMERCADOS; j++) {
                somaProduto += precos[i][j];
                somaSupermercados[j] += precos[i][j];
                totalGeral += precos[i][j];
            }
            mediaProdutos[i] = somaProduto / SUPERMERCADOS;
        }
        
        int indiceMaisBarato = 0, indiceMaisCaro = 0;
        for (int j = 1; j < SUPERMERCADOS; j++) {
            if (somaSupermercados[j] < somaSupermercados[indiceMaisBarato]) {
                indiceMaisBarato = j;
            }
            if (somaSupermercados[j] > somaSupermercados[indiceMaisCaro]) {
                indiceMaisCaro = j;
            }
        }

        System.out.println("\n=== PREÇOS POR SUPERMERCADO ===");
        for (int j = 0; j < SUPERMERCADOS; j++) {
            System.out.println("\nSupermercado " + (j+1) + ":");
            for (int i = 0; i < PRODUTOS; i++) {
                System.out.printf("Produto %d: R$ %.2f\n", i+1, precos[i][j]);
            }
        }
        
        System.out.println("\n=== MÉDIAS POR PRODUTO ===");
        for (int i = 0; i < PRODUTOS; i++) {
            System.out.printf("Produto %d: R$ %.2f\n", i+1, mediaProdutos[i]);
        }
        
        System.out.println("\n=== SOMA POR SUPERMERCADO ===");
        for (int j = 0; j < SUPERMERCADOS; j++) {
            System.out.printf("Supermercado %d: R$ %.2f\n", j+1, somaSupermercados[j]);
        }
        
        System.out.printf("\nSupermercado mais barato (%d): R$ %.2f\n", 
                         indiceMaisBarato+1, somaSupermercados[indiceMaisBarato]);
        System.out.printf("Supermercado mais caro (%d): R$ %.2f\n", 
                         indiceMaisCaro+1, somaSupermercados[indiceMaisCaro]);
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            salvarEmArquivo(precos, mediaProdutos, somaSupermercados, 
                           indiceMaisBarato, indiceMaisCaro);
        }
        
        System.out.print("Deseja ler dados de arquivo? (s/n): ");
        opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            lerDeArquivo();
        }
    }
    
    private static void salvarEmArquivo(double[][] precos, double[] mediaProdutos, 
                                      double[] somaSupermercados, int maisBarato, int maisCaro) {
        try (PrintWriter writer = new PrintWriter("supermercados_dados.txt")) {
            writer.println("=== PREÇOS ===");
            for (int i = 0; i < precos.length; i++) {
                for (int j = 0; j < precos[0].length; j++) {
                    writer.printf("Produto%d-Supermercado%d: %.2f\n", i+1, j+1, precos[i][j]);
                }
            }
            
            writer.println("\n=== MÉDIAS POR PRODUTO ===");
            for (int i = 0; i < mediaProdutos.length; i++) {
                writer.printf("Produto%d: %.2f\n", i+1, mediaProdutos[i]);
            }
            
            writer.println("\n=== TOTAL POR SUPERMERCADO ===");
            for (int j = 0; j < somaSupermercados.length; j++) {
                writer.printf("Supermercado%d: %.2f\n", j+1, somaSupermercados[j]);
            }
            
            writer.printf("\nMais barato: Supermercado%d - R$ %.2f\n", maisBarato+1, somaSupermercados[maisBarato]);
            writer.printf("Mais caro: Supermercado%d - R$ %.2f\n", maisCaro+1, somaSupermercados[maisCaro]);
            
            System.out.println("Dados salvos em supermercados_dados.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    private static void lerDeArquivo() {
        try (Scanner fileScanner = new Scanner(new File("supermercados_dados.txt"))) {
            System.out.println("\n=== DADOS DO ARQUIVO ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}