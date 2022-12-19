import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client=new Client("localhost",115);
        Scanner scanner=new Scanner(System.in);
        while (true)
        {
            System.out.print("Requete>> ");
            client.sendRequete(scanner.nextLine());
            String reponse=client.afficherReponse();
            System.out.print("Reponse:\t"+reponse+"\n");
            if(reponse.equals("sortie")){break;}
        }
    }
}
