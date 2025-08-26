import java.util.Scanner;

public class Atividade09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um texto: ");
        String texto = scanner.nextLine();
        
        char[] vetor = texto.toCharArray();
        
        System.out.println("Texto no vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": '" + vetor[i] + "'");
        }
    }
}