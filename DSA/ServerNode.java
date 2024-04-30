package DSA;

public class ServerNode {

    private String message; // Holds the message being brokered
    private ClientNode[] connectedClients; // Array of connected client nodes
    private int numClients; // Number of currently connected clients

    public ServerNode(int maxClients) {
        connectedClients = new ClientNode[maxClients];
        numClients = 0;
    }

    // Broker message sent by a client
    public void handleMessage(ClientNode sender, String message) {
        this.message = message;
        System.out.println("Server received message: " + message + " from " + sender.getName());
        // Loop through connected clients and send the message
        for (int i = 0; i < numClients; i++) {
            if (connectedClients[i] != sender) {
                connectedClients[i].receive(message, sender.getName());
            }
        }
    }

    // Option 1: Make server public (less secure)
    // public ServerNode server; // Uncomment if using this approach

    // Option 2: Provide a getter method (recommended)
    public ServerNode getServer() {
        return this;
    }

    // Add a client to the server
    public void addClient(ClientNode client) {
        if (numClients < connectedClients.length) {
            connectedClients[numClients++] = client;
        } else {
            System.out.println("Server reached maximum capacity");
        }
    }

    // Remove a client from the server
    public void removeClient(ClientNode client) {
        for (int i = 0; i < numClients; i++) {
            if (connectedClients[i] == client) {
                connectedClients[i] = connectedClients[numClients - 1];
                numClients--;
                break;
            }
        }
    }
}
