import java.io.*;
import java.net.*;
public class client {
    public static void main(String args[]){
        
        try{
            
            Socket c=new Socket("127.0.0.1",4000);
            System.out.println("Connected to a server");
File file=new File("/home/user/uniq.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a name of a file to be  downloaded ");
            String name=br.readLine();
            OutputStream o=c.getOutputStream();
            DataOutputStream d=new DataOutputStream(o);
            d.writeUTF(name);
            System.out.println("Server should start sending the file");
            InputStream i=c.getInputStream();
            DataInputStream di=new DataInputStream(i);
            String line;

         while((line=di.readUTF())!=null){
             System.out.println(line);
	FileWriter fw=new FileWriter(file);
BufferedWriter bw=new BufferedWriter(fw);
		bw.write(line);
bw.flush();
fw.close();
bw.close();
         }
     
          
            c.close();
        }
        catch(IOException e){
             }
  //       
         //   
}
}
