package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.example.Server.PORT;

public class Client {
    public static void main(String[] args) {
        final String host = "localhost";
        try (Socket socket = new Socket(host, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите строку для отправки на сервер:");
            String userInput = stdIn.readLine();
            out.println(userInput);

            String response = in.readLine();
            System.out.println("Ответ сервера: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


