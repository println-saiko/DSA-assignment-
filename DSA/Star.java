package DSA;

public class Star {

    public ServerNode server; // Central server node

    public ServerNode getServer() {
        return server;
    }

    public Star(int maxClients) {
        server = new ServerNode(maxClients);
    }

    // Add a client node to the star network
    public void insertNode(ClientNode client) {
        server.addClient(client);
    }

    // Delete a client node from the star network
    public void deleteNode(ClientNode client) {
        server.removeClient(client);
    }
}
