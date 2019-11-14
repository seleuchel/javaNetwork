package javaio1114;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

public class JavaIO1114 {

////	//this is socket server
////	public final static int PORT = 13;
////
////	public static void main(String[] args) {
////		try (ServerSocket server = new ServerSocket(PORT)) {
////			while (true) {
////				try (Socket connection = server.accept()) {
////					Writer out = new OutputStreamWriter(connection.getOutputStream());
////					Date now = new Date();
////					out.write(now.toString() + "seleuchel server"+ "\r\n");
////					out.flush();
////					connection.close();
////				} catch (IOException ex) {
////				}
////			}
////		} catch (IOException ex) {
////			System.err.println(ex);
////		}
////	}
//
//	  
//	  public Date getDateFromNetwork() throws IOException, ParseException {
//	    try (Socket socket = new Socket("time.nist.gov", 13)) {
//	      socket.setSoTimeout(15000);
//	      InputStream in = socket.getInputStream();
//	      StringBuilder time = new StringBuilder();
//	      InputStreamReader reader = new InputStreamReader(in, "ASCII");
//	      for (int c = reader.read(); c != -1; c = reader.read()) {
//	        time.append((char) c);
//	      }
//	      return parseDate(time.toString());
//	    }
//	  }
//
//	  static Date parseDate(String s) throws ParseException {
//	    String[] pieces = s.split(" ");
//	    String dateTime = pieces[1] + " " + pieces[2] + " UTC";
//	    DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
//	    return format.parse(dateTime);
//	  }
//	
//		// TimeZone
//		TimeZone tz = TimeZone.getTimeZone("GMT+9");
//		// show Available Area
//		//for (String i : TimeZone.getAvailableIDs())
//			//System.out.println(i);
//		Calendar k= Calendar.getInstance();
//		
//		System.out.println(k.getTime());
//		
//		System.out.println(k.get(Calendar.MONTH));

		//time server

		  public static void main(String[] args) throws IOException, ParseException {
		    Date d = Time.getDateFromNetwork();
		    System.out.println("It is " + d);
		  }
		  
		  public static Date getDateFromNetwork() throws IOException, ParseException {
		    // The time protocol sets the epoch at 1900,
		    // the Java Date class at 1970. This number 
		    // converts between them.
		    
		    long differenceBetweenEpochs = 2208988800L;
		    
		    // If you'd rather not use the magic number, uncomment 
		    // the following section which calculates it directly.
		    /*    
		    TimeZone gmt = TimeZone.getTimeZone("GMT");
		    Calendar epoch1900 = Calendar.getInstance(gmt);
		    epoch1900.set(1900, 01, 01, 00, 00, 00);
		    long epoch1900ms = epoch1900.getTime().getTime();
		    Calendar epoch1970 = Calendar.getInstance(gmt);
		    epoch1970.set(1970, 01, 01, 00, 00, 00);
		    long epoch1970ms = epoch1970.getTime().getTime();
		    
		    long differenceInMS = epoch1970ms - epoch1900ms;
		    long differenceBetweenEpochs = differenceInMS/1000;
		    */    
		    
		    Socket socket = null;
		    try {
		      socket = new Socket(HOSTNAME, 37);
		      socket.setSoTimeout(15000);

		      InputStream raw = socket.getInputStream();
		      
		      long secondsSince1900 = 0;
		      for (int i = 0; i < 4; i++) {
		        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
		      }

		      long secondsSince1970 
		                = secondsSince1900 - differenceBetweenEpochs;       
		      long msSince1970 = secondsSince1970 * 1000;
		      Date time = new Date(msSince1970);
		      
		      return time;
		    } finally {
		      try {
		        if (socket != null) socket.close(); 
		      }
		      catch (IOException ex) {}
		    }
		
		
	}

}
