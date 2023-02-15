package com.cecena.main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ipnet {
    public static void main(String[] args) {
        String host;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter host name: ");
        host = input.nextLine();
        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println("IP Address: " + address.toString() );
        } catch (UnknownHostException e){
            System.out.println("No se encontro el host: " + host );
        }
    }
}
