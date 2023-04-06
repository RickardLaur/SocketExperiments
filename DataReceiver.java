import java.net.*;

public class DataReceiver{
	
	public static void main(String[] args) throws Exception {
		DatagramSocket sock = new DatagramSocket(null);
		sock.bind(new InetSocketAddress(8887));
		
		byte[] buffer = new byte[1024];
		DatagramPacket paket = new DatagramPacket(buffer, 1024);
		sock.receive(paket);
		
		String receivedString = new String(paket.getData(), 0, paket.getLength());
		System.out.println("Received packet: \n" + receivedString + "[end]");
		
		sock.close();
	}
}