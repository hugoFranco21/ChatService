/*
 * ITESM QRO
 * Hugo David Franco Ávila
 * A01654856
 */
package backend.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JTextArea;

public class ServerThread implements Runnable {
    private Socket socket;
    private String userName;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;
    private JTextArea textArea;

    public ServerThread(Socket socket, String userName, JTextArea textArea) {
	this.socket = socket;
	this.userName = userName;
	messagesToSend = new LinkedList<String>();
        this.textArea = textArea;
    }

    public void addNextMessage(String message) {
	synchronized (messagesToSend) {
            hasMessages = true;
            messagesToSend.push(message);
	}
    }

    @Override
    public void run() {
	textArea.append("Welcome :" + userName + "\n");
        textArea.append("Local Port :" + socket.getLocalPort() + "\n");
	textArea.append("Server = " + socket.getRemoteSocketAddress() + ":" + socket.getPort() + "\n");
	try {
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), false);
            InputStream serverInStream = socket.getInputStream();
            Scanner serverIn = new Scanner(serverInStream);
            /* Need to use to send media! */
            /* BufferedReader userBr = new BufferedReader(new
            // InputStreamReader(userInStream));
            / Scanner userIn = new Scanner(userInStream);*/
            while (!socket.isClosed()) {
                if (serverInStream.available() > 0) {
                    if (serverIn.hasNextLine()) {
			textArea.append(serverIn.nextLine());
                    }
		}
		if (hasMessages) {
                    String nextSend = "";
                    synchronized (messagesToSend) {
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty();
                    }
                    serverOut.println(userName + "> " + nextSend + "\n");
                    serverOut.flush();
		}
            }
	} catch (IOException ex) {
            ex.printStackTrace();
	}

    }
}