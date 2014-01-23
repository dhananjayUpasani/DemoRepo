package saxParser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{

	
	boolean eid=false;
	boolean eage=false;
	boolean ename=false;
	boolean egender=false;
	boolean erole=false;
	
	private List<Employee> emplist=null;
	private Employee emp=null;
	
	 public List<Employee> getEmpList() {
	        return emplist;
	    }
	
	@Override
	public void startElement(String uri, String localName, String sname,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub("Employee"))
		{
			System.out.println("hi handlerSSS");
			String id=attributes.getValue("id");
			emp=new Employee();
			emp.setId(Integer.parseInt("id"));
			
			if(emplist==null)
			{
				emplist=new ArrayList<Employee>();
			}
			
			else if(sname.equalsIgnoreCase("name"))
			{
				ename=true;
			}
			
			else if(sname.equalsIgnoreCase("role"))
			{
				erole=true;
			}
			
			else if(sname.equalsIgnoreCase("gender"))
			{
				egender=true;
			}
			
			else if(sname.equalsIgnoreCase("age"))
			{
				eage=true;
			}
		}
			
		super.startElement(uri, localName, sname, attributes);
	}
	
	@Override
	public void endElement(String uri, String localName, String sname)
			throws SAXException {
		// TODO Auto-generated method stub
		
			if(sname.equalsIgnoreCase("Employee"))
			{
				emplist.add(emp);
			}
		super.endElement(uri, localName, sname);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
		if(eage)
		{
			emp.setAge(Integer.parseInt(new String(ch,start,length)));
		}
		
		if(egender)
		{
			emp.setGender(new String(ch,start,length));
		}
		
		if(ename)
		{
			emp.setName(new String(ch,start,length));
		}
		
		if(erole)
		{
			emp.setRole(new String(ch,start,length));
		}
		
		super.characters(ch, start, length);
	}
	

}
