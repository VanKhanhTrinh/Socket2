import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientBT1 {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 2345;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String number;
            while ((number = reader.readLine()) != null) {
                System.out.println("Received number: " + number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}