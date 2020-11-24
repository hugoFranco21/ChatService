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

    /*
        The client class represent someone trying to connect to the server to chat
    */
    private final int portNumber = 4444;
    private String userName;
    private String input;
    private String serverHost;
    private JTextArea messageIn;
    private JTextArea messagesOut;
    private JButton acceptInput;
    private ServerThread serverThread;

    /* Client receives UI components so it can update them */
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
            
            /* Listener gets added to the butto nso it waits for the input */
            acceptInput.addActionListener((e)->{
                sendMessage();
            });
            serverAccessThread.start();
            while (serverAccessThread.isAlive()) {
		/* Keep loooping */
		Thread.sleep(200);
            }


	} catch (IOException ex) {
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
	} catch (InterruptedException ex) {
            System.out.println("Interrupted");
	}
    }
    
    /* Message gets sent from the box to the server */
    public void sendMessage(){
        input = messageIn.getText();
        serverThread.addNextMessage(input);
        messageIn.setText("");
    }

    /* Need to be a runnable so the main animation method does not block itself */
    @Override
    public void run() {
        try{
             startClient();
        } catch(Exception e){
            
        }
      
    }
    
}