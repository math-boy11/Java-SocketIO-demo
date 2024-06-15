package com.mathboy11;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(8080);

        SocketIOServer server = new SocketIOServer(config);

        SocketIOModule module = new SocketIOModule(server);
        module.start();
    }
}