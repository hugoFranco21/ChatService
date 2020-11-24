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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Client implements Runnable{

    /* Future versions could change host to an ip
 * instead of localhost */    
    private final int portNumber = 4444;

    private String userName;
    private String input;
    private String serverHost;
    private int serverPort;
    private JTextArea messageIn;
    private JTextArea messagesOut;
    private JButton acceptInput;
    private ServerThread serverThread;

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

    public Client(String userName, JTextArea messageIn, JButton acceptInput, JTextArea messagesOut) {
	this.userName = userName;
	this.serverHost = "localhost";
        this.messageIn = messageIn;
        this.acceptInput = acceptInput;
        this.messagesOut = messagesOut;
    }

    public void startClient() throws IOException, InterruptedException {
	try {
            Socket socket = new Socket(serverHost, portNumber);
            Thread.sleep(1000); // waiting for network communicating.
            serverThread = new ServerThread(socket, userName, messagesOut);
            Thread serverAccessThread = new Thread(serverThread);
            acceptInput.addActionListener((e)->{
                sendMessage();
            });
            serverAccessThread.start();
            while (serverAccessThread.isAlive()) {
		
                
		// NOTE: scan.hasNextLine waits input (in the other words block this thread's
		// process).
		// NOTE: If you use buffered reader or something else not waiting way,
		// NOTE: I recommends write waiting short time like following.
		// else {
		Thread.sleep(200);
		// }
            }


	} catch (IOException ex) {
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
	} catch (InterruptedException ex) {
            System.out.println("Interrupted");
	}
    }
    
    public void sendMessage(){
        input = messageIn.getText();
        serverThread.addNextMessage(input);
        messageIn.setText("");
    }

    public class MyClass implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent e) {
            input = messageIn.getText();
        }
        
    }
    
    @Override
    public void run() {
        try{
             startClient();
        } catch(Exception e){
            
        }
      
    }
    
}