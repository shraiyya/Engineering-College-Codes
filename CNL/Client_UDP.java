import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client_UDP
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
  
        // Step 1:Create the socket object for carrying the data.
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
  
        // while loop
        while (true)
        {
            String input_string= sc.nextLine();
  
            // convert String to byte array.
            buf = input_string.getBytes();
  
            // Step 2 : Create the datagramPacket for sending the data.
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
  
            // Step 3 : invoke the send call to actually send
            // the data.
            ds.send(DpSend);
  
            // break if user enters "bye"
            if (input_string.equals("bye"))
                break;
        }
    }
}