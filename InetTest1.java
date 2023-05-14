import java.net.*;

public class InetTest1 {
public static void main(String[] args){
try{
   InetAddress testAddr = InetAddress.getLocalHost();
   System.out.println(testAddr.toString());
   System.out.println(testAddr.getHostAddress());
}catch(UnknownHostException e){
   System.out.println("could not create InetAddress object");
   System.exit(0);
}
}
}
