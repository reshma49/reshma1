package com.fengjing.framework.xstream.xml2bean;

import com.fengjing.framework.xstream.Person;
import com.fengjing.framework.xstream.PhoneNumber;
import com.thoughtworks.xstream.XStream;

/**
 * @see http://xstream.codehaus.org/tutorial.html
 * @author scott
 *
 */
public class DeserializingXM2Object {
	
	public static void main(String[] args) {
		
		XStream xstream = new XStream();
		//XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
		//XStream xstream = new XStream(new StaxDriver()); // does not require XPP3 library starting with Java 6
		
		xstream.alias("person", Person.class);
		xstream.alias("phonenumber", PhoneNumber.class);
		
		String xml="<person><firstname>Joe</firstname><lastname>Walnes</lastname><phone><code>123</code><number>1234-456</number></phone><fax><code>123</code><number>9999-999</number></fax></person>";
		
		Person person = (Person)xstream.fromXML(xml);
		
		System.out.println(person);
	}
}
