import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
public class MAIN {
    public static void main(String[] args) throws IOException {

        InetAddress a = InetAddress.getByName("www.disney.co.kr");
        Socket socket = new Socket(a.getHostName(), 80);

        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        sendMessage(out);
        readResponse(in);

        out.close();
        in.close();

    }

    private static void sendMessage(BufferedWriter out) throws IOException {
        System.out.println(" * Request");

        List<String> contents = new ArrayList<>();
        contents.add("GET / HTTP/1.0");

        for (String content : contents) {
            System.out.println(content);
            out.write(content + "\r\n");
        }

        out.write("\r\n");
        out.flush();
    }

    private static void readResponse(BufferedReader in) throws IOException {
        System.out.println("\n * Response");

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static List<String> getContents(File file) throws IOException {
        List<String> contents = new ArrayList<String>();

        BufferedReader input = new BufferedReader(new FileReader(file));
        String line;
        while ((line = input.readLine()) != null) {
            contents.add(line);
        }
        input.close();

        return contents;
    }
}
