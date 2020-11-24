/* 
 * ITESMQ QRO
 * Hugo David Franco Ávila
 * A01654856
 * 
 */
package backend.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import backend.server.ServerThread;

public class Client {

    /* Future versions could change host to an ip
 * instead of localhost */    
    private final int portNumber = 4444;

    private String userName;
    private String serverHost;
    private int serverPort;

    /*public static void main(String[] args) {
	String readName = null;
	Scanner scan = new Scanner(System.in);
	System.out.println("Please input username:");
	/* Small validator so users dont use an empty name 
	while (readName == null || readName.trim().equals("")) {
            // null, empty, whitespace(s) not allowed.
            readName = scan.nextLine();
            if (readName.trim().equals("")) {
		System.out.println("Invalid. Please enter again:");
            }
	}
		
	/* Client creating functionality can be delegated to a factory 
	Client client = new Client(readName);
		
		/* The function below connects the user with the server 
	client.startClient(scan);
    }*/

    public Client(String userName) {
	this.userName = userName;
	this.serverHost = "localhost";
    }

    private void startClient(Scanner scan) {
	try {
            Socket socket = new Socket(serverHost, portNumber);
            Thread.sleep(1000); // waiting for network communicating.
            ServerThread serverThread = new ServerThread(socket, userName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while (serverAccessThread.isAlive()) {
		if (scan.hasNextLine()) {
                    serverThread.addNextMessage(scan.nextLine());
		}
		// NOTE: scan.hasNextLine waits input (in the other words block this thread's
		// process).
		// NOTE: If you use buffered reader or something else not waiting way,
		// NOTE: I recommends write waiting short time like following.
		// else {
		// Thread.sleep(200);
		// }
            }
	} catch (IOException ex) {
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
	} catch (InterruptedException ex) {
            System.out.println("Interrupted");
	}
    }
}