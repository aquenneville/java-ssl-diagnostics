import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SslDiagnostics {

	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * https://sslanalyzer.comodoca.com
		 * -Djava.net.debug=all or ssl
		 * -Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2
		 * Download from: http://www.oracle.com/technetwork/java/javase/downloads/index.html
		 * java cryptography extension (jce) unlimited strength jurisdiction policy files for jdk/jre8
		 * replace the jars in the %java_home%/jre/lib/security
		 */
		
		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(null,  null,  new java.security.SecureRandom());
		String[] scs = sc.getServerSocketFactory().getSupportedCipherSuites();
		Arrays.sort(scs);
		System.out.println("Supported cypher suites");
		for (String s: scs) {
			System.out.println(s);
		}
		
		//SSLContext context = SSLContext.getInstance("TLS");
		//sc.init(null, null, null);
		SSLSocketFactory factory = (SSLSocketFactory)sc.getSocketFactory();
		SSLSocket socket = (SSLSocket)factory.createSocket();
		
		String[] protocols = socket.getSupportedProtocols();
		System.out.println("Supported protocols");
		for(String p: protocols) {
			System.out.println(p);
		}
		
		protocols = socket.getEnabledProtocols();
		System.out.println("Enabled protocols");
		for(String p: protocols) {
			System.out.println(p);
		}
		
		
	}

}
