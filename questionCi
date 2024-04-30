import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class MessageCompressor {
    public static void main(String[] args) throws Exception {
        String message = "This is a sample message sent between two nodes in the network. It contains some redundant text to demonstrate compression.";

        // Compress the message
        byte[] compressedMessage = compress(message);
        System.out.println("Compressed message size: " + compressedMessage.length + " bytes");

        // Decompress the message
        String decompressedMessage = decompress(compressedMessage);
        System.out.println("Decompressed message: " + decompressedMessage);
    }

    private static byte[] compress(String message) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterStream = new DeflaterOutputStream(baos);

        deflaterStream.write(message.getBytes());
        deflaterStream.close();

        return baos.toByteArray();
    }

    private static String decompress(byte[] compressedData) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
        InflaterInputStream inflaterStream = new InflaterInputStream(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inflaterStream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        inflaterStream.close();
        baos.close();

        return new String(baos.toByteArray());
    }
}
