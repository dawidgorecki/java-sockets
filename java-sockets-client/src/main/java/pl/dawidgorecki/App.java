package pl.dawidgorecki;

import pl.dawidgorecki.network.Client;

public class App {
    public static final String IP = "127.0.0.1";
    public static final int PORT = 9988;

    public static void main(String[] args) {
        Client client = new Client();
        client.startConnection(IP, PORT);
    }
}