/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg = "Olá, DCOMP!!!";
            byte[] bufenvio = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(bufenvio);
            System.out.println("[OK] ]");
            
            byte[] buf = new byte[200]; // buffer de recepção

            is.read(buf);
            
            String recebida = new String(buf);
            System.out.println("Resposta do servidor: "+ recebida);

        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}