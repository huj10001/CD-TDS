package testweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyContextListener implements ServletContextListener {
    private ServletContext context = null;
    private int a = 1;
    static Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) { 
    	context = servletContextEvent.getServletContext();
//      context.setAttribute("b", 100);
//      context.setAttribute("c", 200);
//      Thread t1 = new Thread(new Runnable(){
//
//			public void run() {
////				int a = 1;;
//				// TODO Auto-generated method stub
//				a++;
//				context.setAttribute("a", a);
//				try {
//					Thread.sleep(1000);
////					a++;
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//      	
//      });
//      ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
//      exec.scheduleAtFixedRate(new Runnable() {
//        public void run() {
//          // do stuff
//      	  a++;
//      	  context.setAttribute("a", a);
//        }
//      }, 0, 5, TimeUnit.SECONDS);
      
      		
      
//      context.setAttribute("key", "value");
    	final String host1 = "169.254.87.47";
		final String host2 = "137.99.252.209";
    	final String host3 = "127.0.0.1";//local
		final int port1 = 9200;
		final int port2 = 9201;
		final int port3 = 9202;
		final int port4 = 9203;
		final int port5 = 1231;//local
		final int port6 = 1232;//local
		final int port7 = 1233;//local
		final int port8 = 1234;//local
		
//		Thread t1 = new Thread(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Socket clientsocket = new Socket(host2,port5);
//					char[] buffer = new char[2048*10];
//				    int charsRead = 0;
//				    String line = null;
//				    BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
//				    String asn_curr = null;
//				    while ((line = in.readLine()) != null) 	
//				    {
//				    	line = line.replaceAll("0>", "").trim();
//				    	String key = line.split(",")[0];
//				    	String value;
//				    	if(line.split(",").length > 1){
//				    	value = line.split(",")[1];
//				    	}
//				    	else{
//				    		value = "n/a";
//				    	}
//				       context.setAttribute(key, value);
//				       try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				    }
////				    clientsocket.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
//		
//		t1.start();
		
		/* device 1 */
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Socket clientsocket = new Socket(host1,port1);
//					Socket clientsocket = new Socket(host2,port5);
//					Socket clientsocket = new Socket(host3,port5);
					char[] buffer = new char[2048*10];
				    int charsRead = 0;
				    String line = null;
				    BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				    String asn_curr = null;
//				    checkSchedule(in);
				    while ((line = in.readLine()) != null) 	
				    {
//				        String message = new String(buffer).substring(0, charsRead);
//				        System.out.println(line);
//				        System.out.println("current asn is " + asn_curr);
				        asn_curr = textAnalyze(line, asn_curr, 0, context);
//				        if(asn_curr != null){
//				        textAlign(ht, line, asn_curr);
//				        }
//				        textPrint();
//				        Thread.sleep(0);
				        sleep();
				    }
//				    clientsocket.close();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		/* device 2 */
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Socket clientsocket = new Socket(host1,port2);
//					Socket clientsocket = new Socket(host2,port6);
//					Socket clientsocket = new Socket(host3,port6);
					char[] buffer = new char[2048*10];
				    int charsRead = 0;
				    String line = null;
				    BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				    String asn_curr = null;
				    while ((line = in.readLine()) != null) 	
				    {
//				        String message = new String(buffer).substring(0, charsRead);
//				        System.out.println(line);
//				        System.out.println("current asn is " + asn_curr);
				        asn_curr = textAnalyze(line, asn_curr, 1, context);
//				        if(asn_curr != null){
//				        textAlign(ht, line, asn_curr);
//				        }
//				        Thread.sleep(0);
				        sleep();
//				        textPrint();
				    }
//				    clientsocket.close();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		/* device 3 */
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Socket clientsocket = new Socket(host1,port3);
//					Socket clientsocket = new Socket(host3,port7);
					char[] buffer = new char[2048*10];
				    int charsRead = 0;
				    String line = null;
				    BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				    String asn_curr = null;
				    while ((line = in.readLine()) != null) 	
				    {
//				        String message = new String(buffer).substring(0, charsRead);
//				        System.out.println(line);
//				        System.out.println("current asn is " + asn_curr);
				        asn_curr = textAnalyze(line, asn_curr, 2, context);
//				        if(asn_curr != null){
//				        textAlign(ht, line, asn_curr);
//				        }
//				        textPrint();
//				        Thread.sleep(0);
				        sleep();
				    }
//				    clientsocket.close();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		/* device 4 */
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Socket clientsocket = new Socket(host1,port4);
//					Socket clientsocket = new Socket(host3,port8);
					char[] buffer = new char[2048*10];
				    int charsRead = 0;
				    String line = null;
				    BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				    String asn_curr = null;
				    while ((line = in.readLine()) != null) 	
				    {
//				        String message = new String(buffer).substring(0, charsRead);
//				        System.out.println(line);
//				        System.out.println("current asn is " + asn_curr);
				        asn_curr = textAnalyze(line, asn_curr, 3, context);
//				        if(asn_curr != null){
//				        textAlign(ht, line, asn_curr);
//				        }
//				        textPrint();
//				        Thread.sleep(0);
				        sleep();
				    }
//				    clientsocket.close();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		/* data flow */
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				char send_flow = ' ';
				char recv_flow = ' ';
				int sender = 0, receiver = 0;
				Enumeration<String> attributeNames = context.getAttributeNames();
				while (attributeNames.hasMoreElements()) {
		            String nextElement = attributeNames.nextElement();
		            ArrayList al = (ArrayList) context.getAttribute(nextElement);
		            for(int i=0;i<al.size();i++){
		            	if(((Hashtable<String, ArrayList<String>>) al.get(i)).contains("RADIOSEND")){
		    				send_flow = ((String) al.get(i)).charAt(((String) al.get(i)).indexOf("flow=")+5);
		    				sender = i+1;
		    			}
		            	if(((Hashtable<String, ArrayList<String>>) al.get(i)).contains("RADIORECV")){
		    				send_flow = ((String) al.get(i)).charAt(((String) al.get(i)).indexOf("flow=")+5);
		    				sender = i+1;
		    			}
		            }
		            if(send_flow != ' ' && recv_flow != ' ' && send_flow == recv_flow){
						String flow_info = "flow="+send_flow+": "+"Device"+sender+"->"+"Device"+receiver;
		            	al.set(4, flow_info);
		            	System.out.println("flow="+send_flow+": "+"Device"+sender+"->"+"Device"+receiver);
		            }
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		t5.start();
  }
  

	protected boolean checkSchedule(BufferedReader in) throws NumberFormatException, IOException {
		String line;
		int numOp = 0;
//		Queue<String[]> queue = new LinkedList<String[]>();
		ArrayList<String[]> queue = new ArrayList<String[]>();
//		return br.readLine() != null;
		while((line = in.readLine()) != null){
			if(!line.contains("SEGGER") && !line.contains("JLinkExe")){
			line = line.replace("0>", "").trim();
			String[] info = line.split(",");
			
//			stack.push("3");
			if(Integer.valueOf(info[0],16) == 45){
				numOp++;
				if(Integer.valueOf(info[3],16)==1){
					queue.add(info);
				}
				
				else if(Integer.valueOf(info[3],16)==2){
					queue.add(info);
				}
				else if(Integer.valueOf(info[3],16)==4){
					queue.add(info);
				}
				else if(Integer.valueOf(info[3],16)==6){
					queue.add(info);
				}
			}
			else if(Integer.valueOf(info[0],16) == 48){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 1){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "TX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 1){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 49){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 2){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "RX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 2){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 50){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 6){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "SERIALTX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 6){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 51){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 4){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "SERIALRX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 4){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
		}
		if(queue.isEmpty()){
			System.out.println("is running on schedule."+"\n");
		}
		else{
			System.out.println("has " + queue.size() + "/"+numOp +" missing operations by schedule: ");
		for(String[] s : queue){
			if(Integer.valueOf(s[3],16) == 1){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" TX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 2){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" RX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 4){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" SERIALRX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 6){
				System.out.println("slotOffset=" +Integer.valueOf(s[1],16)+" SERIALTX FAIL.");
			}
		}
		System.out.println();
		}
		}
		return queue.isEmpty();
		
	}


	protected void sleep() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0);
	}


	private static void textAlign(Hashtable<String, ArrayList<String>> ht, String message, String asn, ServletContext context) {
		Object[] keys = ht.keySet().toArray();
		Arrays.sort(keys);
		
//		for(Object key : keys){
		Object key;
		message = message.replace("0>", "").trim();
		String temp_message = ApiConv(message);
		if(temp_message.contains("ASN")){
			key = message.split(",")[2];
		}
		else{
			key = asn;
		}
			char send_flow = ' ';
			char recv_flow = ' ';
			int sender = 0, receiver = 0;
			
			System.out.println(key+"\t");
			for(int i  = 0; i<ht.get(key).size(); i++){
			if(ht.get(key).get(i) != ""){
			System.out.println("Device"+(i+1)+":"+"\t"+ht.get(key).get(i));}
			if(ht.get(key).get(i).contains("RADIOSEND")){
				send_flow = ht.get(key).get(i).charAt(ht.get(key).get(i).indexOf("flow=")+5);
				sender = i+1;
			}
			if(ht.get(key).get(i).contains("RADIORECV")){
				recv_flow = ht.get(key).get(i).charAt(ht.get(key).get(i).indexOf("flow=")+5);
				receiver = i+1;
			}
			}
				if(send_flow != ' ' && recv_flow != ' ' && send_flow == recv_flow){
					System.out.println("flow="+send_flow+": "+"Device"+sender+"->"+"Device"+receiver);
				}
//		}
		
	}
  
  protected static String textAnalyze(String message, String asn, int seq, ServletContext context) {
		int index = 0;
		String asn_new = null ;
		index++;
		message = message.replace("0>", "").trim();
		String temp_line = ApiConv(message);
//		System.out.println(temp_line);
//		if(temp_line != null){
		if(temp_line.contains("ASN")){
			asn_new  = message.split(",")[2];
			temp_line = temp_line.replace("ASN="+asn_new, ""); //eliminate asn info in event
//			if(ht.get(asn_new) != null){
			if(context.getAttribute(asn_new) != null){
//				ht.get(asn_new).set(seq, temp_line);
				ArrayList al = (ArrayList) context.getAttribute(asn_new);
				al.set(seq, temp_line);
			}
			else{
				switch(seq){
//				case 0: ht.put(asn_new, new ArrayList<String>(Arrays.asList(temp_line,"","","")));
				case 0: context.setAttribute(asn_new, new ArrayList<String>(Arrays.asList(temp_line,"","","")));
						break;
//				case 1: ht.put(asn_new, new ArrayList<String>(Arrays.asList("",temp_line,"","")));
				case 1: context.setAttribute(asn_new, new ArrayList<String>(Arrays.asList("",temp_line,"","")));		
						break;
//				case 2: ht.put(asn_new, new ArrayList<String>(Arrays.asList("","",temp_line,"")));
				case 2: context.setAttribute(asn_new, new ArrayList<String>(Arrays.asList("","",temp_line,"")));
						break;
//				case 3: ht.put(asn_new, new ArrayList<String>(Arrays.asList("","","",temp_line)));
				case 3: context.setAttribute(asn_new, new ArrayList<String>(Arrays.asList("","","",temp_line)));
						break;
				}
//			ht.put(asn_new, new ArrayList<String>(Arrays.asList(temp_line,"","","")));
			}
		}
		else{
			if(asn != null){
//				String prev = ht.get(asn).get(seq);
				ArrayList al = (ArrayList) context.getAttribute(asn);
				String prev = (String) al.get(seq);
				temp_line = prev + " | " + temp_line; // string concatenation
//				ht.get(asn).set(seq, temp_line);
				if(temp_line.contains("| EDF")){ // remove edf
					temp_line = temp_line.replace("| EDF", "");
				}
				al.set(seq, temp_line);
				asn_new = asn;
			}
//		}
		}
//		System.out.println("Parsing is finished.");
		return asn_new;
	}

	private static String ApiConv(String token) {
		// TODO Auto-generated method stub
		String result = "EDF"; //undefined
		String[] info = token.split(",");
		switch(info[0]){
		case "21":
			return result = String.format("FRAME");
		case "22":
			return result = String.format("SLOT	slotOffset=%d ASN="+info[2], Integer.valueOf(info[1],16));
		case "23":
			return result = String.format("FSM	state="+stateConv(info[1]));
		case "2B":
			return result = String.format("TASK	id=%d v=%d slotOffset=%d", Integer.valueOf(info[1],16), Integer.valueOf(info[2],16), Integer.valueOf(info[3],16));
		case "2C":
			return result = String.format("EDF");
		case "2D":
			return result = String.format("ADDSLOT	slotOffset=%d flow=%d type="+celltypeConv(info[3]), Integer.valueOf(info[1],16), Integer.valueOf(info[2],16));
		case "2E":
			return result = String.format("RMSLOT	slotOffset=%d", Integer.valueOf(info[1],16));
		case "2F":
			return result = String.format("ACTIVESLOT	slotOffset=%d ASN="+info[2], Integer.valueOf(info[1],16));
		case "30":
			return result = String.format("RADIOSEND	flow=%d", Integer.valueOf(info[1],16));
		case "31":
			return result = String.format("RADIORECV	flow=%d", Integer.valueOf(info[1],16));
		case "32":
			return result = String.format("BRSEND	flow=%d", Integer.valueOf(info[1],16));
		case "33":
			return result = String.format("BRRECV	flow=%d", Integer.valueOf(info[1],16));
		}
		return result;
	}

	private static String stateConv(String string) {
		String result = "";
		switch(string){
		case "0":
			return result = "S_SLEEP";
		case "1":
			return result = "S_SYNCLISTEN";
		case "2":
			return result = "S_SYNCRX";
		case "3":
			return result = "S_SYNCPROC";
		case "4":
			return result = "S_TXDATAOFFSET";
		case "5":
			return result = "S_TXDATAPREPARE";
		case "6":
			return result = "S_TXDATAREADY";
		case "7":
			return result = "S_TXDATADELAY";
		case "8":
			return result = "S_TXDATA";
		case "9":
			return result = "S_RXACKOFFSET";
		case "10":
			return result = "S_RXACKPREPARE";
		case "11":
			return result = "S_RXACKREADY";
		case "12":
			return result = "S_RXACKLISTEN";
		case "13":
			return result = "S_RXACK";
		case "14":
			return result = "S_TXPROC";
		case "15":
			return result = "S_RXDATAOFFSET";
		case "16":
			return result = "S_RXDATAPREPARE";
		case "17":
			return result = "S_RXDATAREADY";
		case "18":
			return result = "S_RXDATALISTEN";
		case "19":
			return result = "S_RXDATA";
		case "20":
			return result = "S_TXACKOFFSET";
		case "21":
			return result = "S_TXACKPREPARE";
		case "22":
			return result = "S_TXACKREADY";
		case "23":
			return result = "S_TXACKDELAY";
		case "24":
			return result = "S_TXACK";
		case "25":
			return result = "S_RXPROC";
		}
		return result;
	}

	private static Object celltypeConv(String string) {
		String result = "";
		switch(string){
		case "0":
			return result = "OFF";
		case "1":
			return result = "TX";
		case "2":
			return result = "RX";
		case "3":
			return result = "TXRX";
		case "4":
			return result = "SERIALRX";
		case "5":
			return result = "MORESERIALRX";
		case "6":
			return result = "SERIALTX";	
		}
		return result;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context = null;
    }
}
