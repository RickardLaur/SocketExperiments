import java.net.*;
import java.io.*;
public class DataSender {
	public static void main(String[] args) throws Exception{ //eftersom sockets throwar SocketExceptions så måste det deklareras att exceptions throwas.

		DatagramSocket sock = new DatagramSocket(null);
		sock.bind(new InetSocketAddress(8888));
		
		String message = "RikkardsDataPaket";
		InetAddress ip = InetAddress.getByName("192.168.1.2");//127.0.0.1");
		
		DatagramPacket paket = new DatagramPacket(message.getBytes(), message.length(), ip, 8887);// 3000);
		sock.send(paket);
		sock.close();
		System.out.println("Sent a package! Contained string is: \n RikkardsDataPaket");
		
	}
}