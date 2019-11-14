//client for server int JavaIO1114
import java.net.*;
import java.io.*;

public class DaytimeClient {

	public static void main(String[] args) {

		String hostname = args.length > 0 ? args[0] : "localhost";
		Socket socket = null;
		try {
			socket = new Socket(hostname, 13);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			StringBuilder time = new StringBuilder();
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char) c);
			}
			System.out.println(time);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ex) {
					// ignore
				}
			}
		}
	}
}
