import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {


    Socket socket;
    DataInputStream lecture;
    DataOutputStream envoi;
    public Client(String adresse,int port) throws IOException {
        this.setSocket(new Socket(adresse,port));
        this.setEnvoi(new DataOutputStream(this.getSocket().getOutputStream()));
        this.setLecture(new DataInputStream(this.getSocket().getInputStream()));
    }

    public void sendRequete(String requete) throws IOException {
        this.getEnvoi().writeUTF(requete);
        this.getEnvoi().flush();
    }

    public String afficherReponse() throws IOException {
        return this.getLecture().readUTF();
    }

    public void exit() throws IOException {
        this.getLecture().close();
        this.getEnvoi().close();
        this.getSocket().close();
    }


    //get and set
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public DataInputStream getLecture() {
        return lecture;
    }

    public void setLecture(DataInputStream lecture) {
        this.lecture = lecture;
    }

    public DataOutputStream getEnvoi() {
        return envoi;
    }

    public void setEnvoi(DataOutputStream envoi) {
        this.envoi = envoi;
    }

}
