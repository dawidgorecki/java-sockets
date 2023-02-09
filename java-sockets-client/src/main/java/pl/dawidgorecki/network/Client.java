package pl.dawidgorecki.network;

import pl.dawidgorecki.utils.ConsoleInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public void startConnection(String ip, int port) {
        try (
                Socket clientSocket = new Socket(ip, port);
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader input = new BufferedReader(in)
        ) {
            String welcomeMessage = input.readLine();
            System.out.println(welcomeMessage);

            long userId = ConsoleInput.getLong();
            output.println(userId);

            String response;
            while ((response = input.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println("[!] Nie można połączyć z serwerem");
        }
    }
}
