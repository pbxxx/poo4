import java.util.Scanner;

public class Atividade04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] caracteres = new char[10];
        int contConsoantes = 0;
        
        System.out.println("Digite 10 caracteres:");
        for (int i = 0; i < 10; i++) {
            caracteres[i] = scanner.next().charAt(0);
        }
        
        System.out.println("Consoantes encontradas:");
        for (int i = 0; i < 10; i++) {
            char c = Character.toLowerCase(caracteres[i]);
            if (c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                contConsoantes++;
                System.out.println(caracteres[i]);
            }
        }
        
        System.out.println("Total de consoantes: " + contConsoantes);
    }
}