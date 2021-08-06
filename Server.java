/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/**
 *
 * @author telecom
 */
public class Server 
{
    private static final int PUERTO = 3306;
    private static HashSet<String> ids = new HashSet<String>();
    private static HashSet<PrintWriter> mensajes = new HashSet<PrintWriter>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("El servidor char se esta ejecutando.");
        Socket skServer = null;
        
        try 
        {
            skServer = new Socket("localhost", PUERTO);            
            System.out.println("Prueba");
            System.out.println("Socket: " + skServer.isConnected());
            skServer.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            if(skServer == null)
            {
                System.out.println("Socket apagado");
            }
        } 


    }
    
    /*private static class CRecepcion extends Thread {
        private String nombre;
        private Socket sk;
        private BufferedReader in;
        private PrintWriter out;
        
        public CRecepcion(Socket s) {
            this.sk = s;
        }
        
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(
                    sk.getInputStream()));
                out = new PrintWriter(sk.getOutputStream(), true);
                while (true) {
                    out.println("NOMBREE");
                    nombre = in.readLine();
                    if (nombre == null) {
                        return;
                    }
                    synchronized (ids) {
                        if (!ids.contains(nombre)) {
                            ids.add(nombre);
                            break;
                        }
                    }
                }

                
                out.println("NOMBREA");
                mensajes.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : mensajes) {
                        writer.println("Mensaje " + nombre + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (nombre != null) {
                    ids.remove(nombre);
                }
                if (out != null) {
                    mensajes.remove(out);
                }
                try {
                    sk.close();
                } catch (IOException e) {
                }
            }
        }
    }   */ 
}
