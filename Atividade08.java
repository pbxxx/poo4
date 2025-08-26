import java.util.Scanner;

public class Atividade08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        char[] consoantes = new char[21];
        
        // Separando consoantes
        int cont = 0;
        for (char c : alfabeto) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                consoantes[cont++] = c;
            }
        }
        
        System.out.print("Digite o tamanho da senha (máximo 26): ");
        int tamanho = scanner.nextInt();
        
        if (tamanho > 26) {
            System.out.println("Tamanho máximo é 26!");
            return;
        }
        
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            if (i % 2 == 0) {
                // Posição par - consoante
                int index = (int)(Math.random() * 21);
                senha.append(consoantes[index]);
            } else {
                // Posição ímpar - vogal
                int index = (int)(Math.random() * 5);
                senha.append(vogais[index]);
            }
        }
        
        // Se tamanho for ímpar, garante que termina com consoante
        if (tamanho % 2 != 0) {
            int index = (int)(Math.random() * 21);
            senha.setCharAt(tamanho-1, consoantes[index]);
        }
        
        System.out.println("Senha gerada: " + senha.toString());
    }
}