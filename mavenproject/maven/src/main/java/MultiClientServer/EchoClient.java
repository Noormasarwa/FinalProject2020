package MultiClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import DataToWrite.AReq;
import DataToWrite.ARes;
import JasonEditor.Jackson;
import TesttForDataToWrite.JsonWriterAndReader;
import TesttForDataToWrite.Test1;
 
public class EchoClient {
 
    public ARes RunClient(JTextArea  textField) {
    	String host = "127.0.0.1";
        int port = 32000;
        Test1 t =new Test1();
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mes = null;
            JsonWriterAndReader jwr= new JsonWriterAndReader();
            ARes ares ;
            Jackson jackson = new Jackson();
            AReq areq = t.returningAReqObject();
            System.out.println(areq);
            mes = jackson.fromAReqToJson(areq);
            out.println(mes);
            out.flush();
            textField.setText(textField.getText() +"\nMessage has been sent ... \nwaiting for the SERVER...");
            out.println("exit");
            out.flush();
            String line ;
            String j = "";
            while ((line= in.readLine()) != null) {
            	if("exit".equalsIgnoreCase(line)) {
            		break;
            	}
            	j+=line;
                System.out.printf("Sent from the SERVER: %s\n", line);
             
            }
            ares = jackson.fromJasonToAresObject(j);
            jwr.WriteIntoFileARes(jackson.fromAResToJson(ares));
            System.out.println("Server replied " + ares);
            textField.setText(textField.getText() +"Server replied:\n " + ares+"\n");
            return ares;
        } catch (IOException e) {
            e.printStackTrace();
            textField.setText(textField.getText() +"\nSERVER IS OFFLINE......Try Again");
        }
        return null;
    }
    
    public ARes RunClient(JTextArea textField , AReq areq) {
    	String host = "127.0.0.1";
        int port = 32000;
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mes = null;
            JsonWriterAndReader jwr= new JsonWriterAndReader();
            ARes ares ;
            Jackson jackson = new Jackson();
            System.out.println(areq);
            mes = jackson.fromAReqToJson(areq);
            out.println(mes);
            out.flush();
            textField.setText(textField.getText() +"\nMessage has been sent ... \nwaiting for the SERVER...");
            out.println("exit");
            out.flush();
            String line ;
            String j = "";
            while ((line= in.readLine()) != null) {
            	if("exit".equalsIgnoreCase(line)) {
            		break;
            	}
            	j+=line;
                System.out.printf("Sent from the SERVER: %s\n", line);
             
            }
            ares = jackson.fromJasonToAresObject(j);
            jwr.WriteIntoFileARes(jackson.fromAResToJson(ares));
            System.out.println("Server replied " + ares);
            textField.setText(textField.getText() +"Server replied:\n " + ares+"\n");
            return ares;
        } catch (IOException e) {
            e.printStackTrace();
            textField.setText(textField.getText() +"\nSERVER IS OFFLINE......Try Again");
        }
        return null;
    }


    
}	