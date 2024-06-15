package com.mathboy11;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class SocketIOModule {
    private SocketIOServer server;

    public SocketIOModule(SocketIOServer server) {
        this.server = server;

        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("sendMessage", SocketIOMessage.class, this.sendMessage());
    }

    private DataListener<SocketIOMessage> sendMessage() {
        return ((client, data, ackSender) -> {
           System.out.println("Got message: " + data.getMessage());
        });
    }

    private ConnectListener onConnected() {
        return (client -> {
           System.out.println("New connection!");
        });
    }

    private DisconnectListener onDisconnected() {
        return (client -> {
           System.out.println("Disconnected!");
        });
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop();
    }
}
