package sample;

import java.io.StringReader;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@WebService
public class Weeeb {
	
	String correctesa;
	Capcelera capcelera1;
	Boolean isCorrect;
	
	@WebMethod
	public String MyMethod(String xml) throws JAXBException {
		
		
		StringReader reader = new StringReader(xml);
		JAXBContext jaxbContent = JAXBContext.newInstance(Capcelera.class);
		Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
		capcelera1 = (Capcelera) jaxbUnmarshaller.unmarshal(reader);
		
		correctesa = "false";
		System.out.println(correctesa);
		isCorrect = true;
		
		if(Integer.toString(capcelera1.getId()).length() > 35)
			isCorrect = false;
		if(capcelera1.getData().length() > 19)
			isCorrect = false;
		
		System.out.println(Integer.toString(capcelera1.getNumOps()).length());
		if(Integer.toString(capcelera1.getNumOps()).length() > 15)
			isCorrect = false;
		if(Integer.toString(capcelera1.getCtrlSum()).length() > 18)
			isCorrect = false;
		
		if(isCorrect)
			correctesa = "true";
		
		return correctesa;
	}
}
