package pl.dawidgorecki;

import pl.dawidgorecki.network.Server;
import pl.dawidgorecki.utils.ConfigurationLoader;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties config = ConfigurationLoader.loadProperties();
        int port = Integer.parseInt(config.getProperty("server.port"));

        Server server = new Server();
        server.startServer(port);
    }
}
