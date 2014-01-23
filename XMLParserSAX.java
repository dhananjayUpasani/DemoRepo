package saxParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParserSAX {
	 public static void main(String[] args) {
		    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		    try {
		        SAXParser saxParser = saxParserFactory.newSAXParser();
		        Handler handler = new Handler();
		        System.out.println("hiiiiiii up");
		        saxParser.parse(new File("data.xml"), handler);
		        //Get Employees list
		        List<Employee> empList = handler.getEmpList();
		        //print employee information
		        System.out.println("hiiiiiii down");
		        for(Employee emp : empList)
		            System.out.println(emp);
		    } catch (ParserConfigurationException  e) {
		        e.printStackTrace();
		    }
		    catch(SAXException q ){
		    	
		    }catch(IOException w){
		    	
		    }
		    }
}
