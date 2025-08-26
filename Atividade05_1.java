import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Atividade05_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Quantas cartelas deseja gerar? ");
        int n = scanner.nextInt();
        
        int[][] cartelas = new int[n][6];
        int[] numerosSorteados = gerarNumerosSorteados();
        
        for (int i = 0; i < n; i++) {
            cartelas[i] = gerarCartelaUnica(random);
            Arrays.sort(cartelas[i]);
        }
        
        int[] acertos = new int[n];
        for (int i = 0; i < n; i++) {
            acertos[i] = contarAcertos(cartelas[i], numerosSorteados);
        }
        
        System.out.println("\nNúmeros sorteados: " + Arrays.toString(numerosSorteados));
        System.out.println("\n=== CARTELAS E ACERTOS ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("Cartela %d: %s → %d acertos\n", 
                             i+1, Arrays.toString(cartelas[i]), acertos[i]);
        }
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            salvarEmArquivo(cartelas, acertos, numerosSorteados);
        }
        
        System.out.print("Deseja ler dados de arquivo? (s/n): ");
        opcao = scanner.next().charAt(0);
        if (opcao == 's' || opcao == 'S') {
            lerDeArquivo();
        }
    }
    
    private static int[] gerarCartelaUnica(Random random) {
        int[] cartela = new int[6];
        boolean[] usado = new boolean[61]; 
        
        for (int i = 0; i < 6; i++) {
            int numero;
            do {
                numero = random.nextInt(60) + 1;
            } while (usado[numero]);
            
            cartela[i] = numero;
            usado[numero] = true;
        }
        
        return cartela;
    }
    
    private static int[] gerarNumerosSorteados() {
        Random random = new Random();
        int[] sorteados = new int[6];
        boolean[] usado = new boolean[61];
        
        for (int i = 0; i < 6; i++) {
            int numero;
            do {
                numero = random.nextInt(60) + 1;
            } while (usado[numero]);
            
            sorteados[i] = numero;
            usado[numero] = true;
        }
        
        Arrays.sort(sorteados);
        return sorteados;
    }
    
    private static int contarAcertos(int[] cartela, int[] sorteados) {
        int acertos = 0;
        for (int numCartela : cartela) {
            for (int numSorteado : sorteados) {
                if (numCartela == numSorteado) {
                    acertos++;
                    break;
                }
            }
        }
        return acertos;
    }
    
    private static void salvarEmArquivo(int[][] cartelas, int[] acertos, int[] sorteados) {
        try (PrintWriter writer = new PrintWriter("loteria_dados.txt")) {
            writer.println("Números sorteados: " + Arrays.toString(sorteados));
            writer.println("\n=== CARTELAS ===");
            for (int i = 0; i < cartelas.length; i++) {
                writer.printf("Cartela %d: %s → %d acertos\n", 
                             i+1, Arrays.toString(cartelas[i]), acertos[i]);
            }
            
            System.out.println("Dados salvos em loteria_dados.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    private static void lerDeArquivo() {
        try (Scanner fileScanner = new Scanner(new File("loteria_dados.txt"))) {
            System.out.println("\n=== DADOS DO ARQUIVO ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}