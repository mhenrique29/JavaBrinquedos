package com.exemplo.rsaclientserver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class Server {
    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    public static void main(String[] args) {
        try {
            // Criando o servidor socket na porta 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servidor aguardando conexão...");

            // Aceitando a conexão do cliente
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            // Geração de chaves RSA
            generateKeys();

            // Comunicar-se com o cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Recebendo mensagem do cliente
            String message = input.readLine();
            System.out.println("Mensagem recebida do cliente: " + message);

            // Criptografar mensagem
            String encryptedMessage = encrypt(message, publicKey);
            System.out.println("Mensagem criptografada enviada ao cliente: " + encryptedMessage);

            // Enviando a mensagem criptografada de volta ao cliente
            output.println(encryptedMessage);

            // Fechar os recursos
            input.close();
            output.close();
            socket.close();  // Fechando a conexão com o cliente
            serverSocket.close();  // Fechando o servidor

            // Log de encerramento
            System.out.println("Conexão encerrada com o cliente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para gerar chaves RSA
    private static void generateKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        privateKey = pair.getPrivate();
        publicKey = pair.getPublic();

        System.out.println("Chave Pública (modulus e exponent):");
        System.out.println(publicKey.toString());
        System.out.println("Chave Privada:");
        System.out.println(privateKey.toString());
    }

    // Método para criptografar a mensagem
    private static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        return new String(encryptedMessage);
    }
}
