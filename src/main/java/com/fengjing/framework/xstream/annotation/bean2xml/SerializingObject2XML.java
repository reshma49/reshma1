package com.fengjing.framework.xstream.annotation.bean2xml;

import org.junit.Test;

import com.fengjing.framework.xstream.annotation.Person;
import com.fengjing.framework.xstream.annotation.PhoneNumber;
import com.thoughtworks.xstream.XStream;

/**
 * @see http://xstream.codehaus.org/annotations-tutorial.html
 * @author scott
 *
 */
public class SerializingObject2XML {

	@Test
	public void test() {
		
		XStream xstream = new XStream();
		//XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
		//XStream xstream = new XStream(new StaxDriver()); // does not require XPP3 library starting with Java 6
		
		xstream.processAnnotations(Person.class);
		
		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));
		
		String xml = xstream.toXML(joe);
		
		System.out.println(xml);
	}
	
}
