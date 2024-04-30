package DSA;

public class ClientNode {

    private String name; // Unique identifier for the client
    private ServerNode server; // Reference to the connected server

    public ClientNode(String name, ServerNode server) {
        this.name = name;
        // Option 1: Use server directly if public (less secure)
        // this.server = server; // Uncomment if using this approach

        // Option 2: Use getter method (recommended)
        this.server = server.getServer();
    }

    public String getName() {
        return name;
    }

    // Send a message to another client through the server
    public void send(String message) {
        server.handleMessage(this, message);
    }

    // Receive a message (simulates printing)
    public void receive(String message, String sender) {
        System.out.println(sender + " sent: " + message);
    }
}
