import java.util.Scanner;

public class Atividade10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite uma data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        
        String[] partes = data.split("/");
        int[] vetorData = new int[3];
        
        if (partes.length != 3) {
            System.out.println("Formato inválido!");
            return;
        }
        
        try {
            vetorData[0] = Integer.parseInt(partes[0]); // dia
            vetorData[1] = Integer.parseInt(partes[1]); // mês
            vetorData[2] = Integer.parseInt(partes[2]); // ano
            
            if (vetorData[0] < 1 || vetorData[0] > 31 ||
                vetorData[1] < 1 || vetorData[1] > 12 ||
                vetorData[2] < 1900) {
                System.out.println("Data inválida!");
                return;
            }
            
            System.out.println("Dia: " + vetorData[0]);
            System.out.println("Mês: " + vetorData[1]);
            System.out.println("Ano: " + vetorData[2]);
            
        } catch (NumberFormatException e) {
            System.out.println("Data inválida!");
        }
    }
}