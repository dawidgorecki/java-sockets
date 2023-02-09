package pl.dawidgorecki.network;

import pl.dawidgorecki.utils.ConsoleInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            long userId = ConsoleInput.getLong("Wprowadź ID użytkownika: ");

            // send user id to the server
            output.println(userId);

            // proceed server response
            String response;
            while ((response = input.readLine()) != null) {
                if (response.equals("/q")) {
                    break;
                }

                // ...otherwise print response
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println("[!] Nie można połączyć z serwerem");
        } finally {
            closeConnection();
        }
    }

    public void closeConnection() {
        try {
            if (input != null) input.close();
            if (output != null) output.close();
            if (clientSocket != null && clientSocket.isConnected()) clientSocket.close();
        } catch (IOException e) {
            // error when closing
        }
    }
}
