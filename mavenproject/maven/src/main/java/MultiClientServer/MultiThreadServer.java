package MultiClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Random;

import ConnectToMySQl.Sql;
import DataToWrite.AReq;
import DataToWrite.ARes;
import DataToWrite.CReq;
import FrictionlessFlow.CheckingAReq;
import JasonEditor.Jackson;
import TesttForDataToWrite.Httpsend;
import TesttForDataToWrite.sendSMS;

public class MultiThreadServer {
    public static void Server() {

        ServerSocket server = null;
        try {
            server = new ServerSocket(32000);
            server.setReuseAddress(true);
            // The main thread is just accepting new connections
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected " + client.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(client);
                // The background thread will handle each client separately
                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            Sql sql = new Sql();
            ARes ares = null;
            AReq areq= null;
            int key = 0;
            CheckingAReq ca = new CheckingAReq();
            Jackson jk =new Jackson();
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line = "";
                String j = "";
                
                while ((line = in.readLine()) != null) {
                	if("exit".equalsIgnoreCase(line)) {
                		break;
                	}
                	j+=line;
                    System.out.printf("Sent from the client: %s\n", line);
                }
                areq = jk.fromJasonToAReqObject(j);
                ares = ca.checkAReq(areq);
                key = sql.addARes(ares);
                ares.setAcsReferenceNumber(Integer.toString(key));
                out.println(jk.fromAResToJson(ares));
                out.flush();
                out.println("exit");
                out.flush();
                if(ares.getTransStatus().contains("C")) {
                	Random rand = new Random(); 
                	int pass = rand.nextInt(10000);
                	try {
                		sendSMS s = new sendSMS();
						s.send(areq.getHomePhone(),pass);
						Httpsend h = new Httpsend();
						CReq creq = ca.returnCreq(ares);
						sql.addCReq(creq);
						h.sendinformationtohttp(Integer.toString(pass), jk.fromCReqToJson(creq));
					} catch (Exception e) {
						
						e.printStackTrace();
					}
                	
                }
                
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			} finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null)
                        in.close();
                    clientSocket.close();
                    System.out.println("Client Disconnected .... ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}