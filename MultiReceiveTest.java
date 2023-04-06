import java.net.*;

public class MultiReceiveTest{
	public static int receivedPackets = 0;
	
	public static void main(String[] args) throws Exception {
		DatagramSocket sock = new DatagramSocket(null);
		sock.bind(new InetSocketAddress(8887));
		
		byte[] buffer = new byte[1024];
		while(true){
			DatagramPacket paket = new DatagramPacket(buffer, 1024);
			sock.receive(paket);
		
			receivedPackets += 1;
			String receivedString = new String(paket.getData(), 0, paket.getLength());
			System.out.println("Received packet: \n" + receivedString + "\nReceived packets: " + Integer.toString(receivedPackets));
			if(receivedPackets == 20){
				break;
			}
		}
		sock.close();
	} 
}