import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BT1 {
    public static void main(String[] args) {
        int port = 2345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                Thread clientThread = new Thread(() -> {
                    try {
                        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                        for (int i = 1; i <= 1000; i++) {
                            writer.println(i);
                            Thread.sleep(1000);
                        }

                        socket.close();
                        System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}