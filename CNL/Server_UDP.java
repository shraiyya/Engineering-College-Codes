import java.net.*;
import java.io.*;
public class Server_UDP
{
	public static void main(String[] args) throws IOException
    {
        // Step 1 : Create a socket to listen at port 1234
        DatagramSocket datagram_socket = new DatagramSocket(1234);
        byte[] receive = new byte[65535];
  
        DatagramPacket received_datagram = null;
        while (true)
        {
  
            // Step 2 : create a DatgramPacket to receive the data.
            received_datagram = new DatagramPacket(receive, receive.length);
  
            // Step 3 : receive the data in byte buffer.
            datagram_socket.receive(received_datagram);
  
            System.out.println("Client:-" + data(receive));
  
            // Exit if the client sendatagram_socket "bye"
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
  
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
    }
  
    // A utility method to convert the byte array data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}