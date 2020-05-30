import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class UsersDatabase {

   
    
    
   public void createXML(){
       try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element Users = doc.createElement("Users");
            Element user = doc.createElement("user");
            Element username = doc.createElement("username");
            Element password = doc.createElement("password");
            
            user.appendChild(username);
            user.appendChild(password);
            Users.appendChild(user);
            doc.appendChild(Users);

            Source s = new DOMSource(doc);
            StreamResult r = new StreamResult("Users.xml");
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(s, r);
       }catch (Exception e) {
            System.out.print(e.toString());
       }
   }

 /*  public void newUser(String un, String pwdsha){
       String[] x = doc.getElementsByTagName("user");
   }

}*/