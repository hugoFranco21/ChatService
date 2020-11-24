/* 
 * ITESMQ QRO
 * Hugo David Franco Ávila
 * A01654856
 * 
 */
package backend.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import backend.client.ClientThread;
import javax.swing.JTextArea;

public class Server implements Runnable{

	private final int portNumber = 4444;

	private String password;
        private JTextArea textArea;
	private List<ClientThread> clients; // or "protected static List<ClientThread> clients;"

	/*public static void main(String[] args) {
		Server server = new Server(portNumber, password);
		server.startServer();
	}*/

	public Server(String password, JTextArea textArea) {
		this.password = password;
                this.textArea = textArea;
	}

	public List<ClientThread> getClients() {
		return clients;
	}

	public void startServer() {
		clients = new ArrayList<ClientThread>();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(portNumber);
			acceptClients(serverSocket);
		} catch (IOException e) {
			textArea.append("Could not listen on port: " + portNumber);
			System.exit(1);
		}
	}

	private void acceptClients(ServerSocket serverSocket) {
		textArea.append("server starts port = " + serverSocket.getLocalSocketAddress() + "\n");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				textArea.append("accepts : " + socket.getRemoteSocketAddress() + "\n");
				ClientThread client = new ClientThread(this, socket);
				Thread thread = new Thread(client);
				thread.start();
				clients.add(client);
			} catch (IOException ex) {
				textArea.append("Accept failed on : " + portNumber);
			}
		}
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setClients(List<ClientThread> clients) {
		this.clients = clients;
	}

    @Override
    public void run() {
        startServer();
        
    }
	
	
}