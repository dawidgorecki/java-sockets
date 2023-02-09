package pl.dawidgorecki.network;

import pl.dawidgorecki.model.dto.VehicleReadModel;
import pl.dawidgorecki.service.VehicleService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public void startServer(int port) {
        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ) {
            ExecutorService executorService = Executors.newCachedThreadPool();

            while (!serverSocket.isClosed()) {
                Socket client = serverSocket.accept();
                System.out.println("[!] Nowe połączenie " + client.getInetAddress().toString());
                executorService.execute(new ConnectionHandler(client));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static class ConnectionHandler implements Runnable {
        private final Socket socket;

        public ConnectionHandler(final Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    socket;
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                output.println("Wprowadź ID użytkownika: ");
                String response = input.readLine();

                VehicleService service = new VehicleService();
                List<VehicleReadModel> vehicles = service.findAllByUserId(Long.parseLong(response), true);

                vehicles.forEach(output::println);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}
