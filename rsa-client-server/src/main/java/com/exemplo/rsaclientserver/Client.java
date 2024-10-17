package com.exemplo.rsaclientserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            // Conectar ao servidor
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Conectado ao servidor!");

            // Enviar mensagem ao servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "Olá servidor, aqui é o cliente!";
            System.out.println("Mensagem enviada ao servidor: " + message);
            output.println(message);

            // Receber resposta do servidor (criptografada)
            String encryptedMessage = input.readLine();
            System.out.println("Mensagem criptografada recebida do servidor: " + encryptedMessage);

            // Fechar os recursos
            input.close();
            output.close();
            socket.close();  // Fechando a conexão com o servidor

            // Log de encerramento
            System.out.println("Conexão encerrada com o servidor.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
