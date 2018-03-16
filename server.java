import java.io.*;
import java.net.*;
public class server {
    public static void main(String args[]){
        
        try{
            ServerSocket s=new ServerSocket(4000);
            Socket cs;
            cs=s.accept();
            System.out.println("Accepted a client" ); 
            InputStream i=cs.getInputStream();
            DataInputStream d=new DataInputStream(i);
            String name=d.readUTF();
            System.out.println("File name entered by the client = "+name);
            FileReader f=new FileReader(name);
            String line;
            BufferedReader br=new BufferedReader(f);
          
            while((line=br.readLine())!=null)
            {   
                System.out.println(line);
                try{
                OutputStream o=cs.getOutputStream();
                DataOutputStream od=new DataOutputStream(o);
               od.writeUTF(line);
                }
                  catch(IOException e){
            System.out.println("Error while sending a file");
        }
            }
             s.close();
            cs.close();
        }
        catch(IOException e){
            System.out.println("Error while accepting a connection");
        }
       
    }
}

