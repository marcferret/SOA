package almarProjectPackage;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import almarProjectPackage.Capcelera;

public class Marshaling {

	private static Capcelera capcelera = new Capcelera();
	
	public static void main(String args[]) {
		capcelera.setId(2);
		capcelera.setData("2010-06-10T08:35:30");
		capcelera.setNumOps(3452);
		capcelera.setCtrlSum(1324);
	
	
		try {
			//marshal
			//creem fitxer sortida i objecte Marshall
			File file = new File("iepale.xml");
			JAXBContext jaxbContent = JAXBContext.newInstance(Capcelera.class);
			
			marshall(file, jaxbContent);
			unmarshall(file, jaxbContent);
			//unmarshal
			
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void marshall(File file, JAXBContext jaxbContent) throws JAXBException {
		Marshaller jaxbMarshaller = jaxbMarshaller = jaxbContent.createMarshaller();
		
		//definim output
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(capcelera, file);
		jaxbMarshaller.marshal(capcelera, System.out);
	}
	
	public static void unmarshall(File file, JAXBContext jaxbContent) throws JAXBException {
		Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
		Capcelera capcelera1 = (Capcelera) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println("Capcelera: [");
		System.out.println("Id: " + capcelera1.getId());
		System.out.println("Data: " + capcelera1.getData());
		System.out.println("NumOps: " + capcelera1.getNumOps());
		System.out.println("CtrlSum: " + capcelera1.getCtrlSum() + " ]");
	}
	
}
