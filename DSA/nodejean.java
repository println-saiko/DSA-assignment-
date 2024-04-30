package DSA;

public class nodejean {

    public static void main(String[] args) {
        Star network = new Star(4); // Server with capacity for 4 clients

        ClientNode clientX = new ClientNode("X", network.server);
        ClientNode clientY = new ClientNode("Y", network.server);
        ClientNode clientZ = new ClientNode("Z", network.server);

        network.insertNode(clientX);
        network.insertNode(clientY);
        network.insertNode(clientZ);

        clientX.send("Hello everyone, how are you?");

        // Output:
        // Server received message: Hello everyone,
    }
}