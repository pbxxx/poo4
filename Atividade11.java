import java.util.Scanner;

public class Atividade11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite palavras separadas por ; : ");
        String texto = scanner.nextLine();
        
        String[] palavras = texto.split(";");
        
        System.out.println("Palavras encontradas:");
        for (int i = 0; i < palavras.length; i++) {
            System.out.println("Posição " + i + ": " + palavras[i].trim());
        }
    }
}