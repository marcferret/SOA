package almarProjectPackage;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "GrpHdr")
public class Capcelera {
	
	private int id, numOps, ctrlSum;
	private String data;

	@XmlAttribute ( name = "MsgId")
	public void setId( int newId){
		id = newId;
	}
	
	@XmlElement ( name = "CreDtTm")
	public void setData( String newData) {
		data = newData;
	}
	
	@XmlElement ( name = "NbOfTxs")
	public void setNumOps( int newOps) {
		numOps = newOps;
	}
	
	@XmlElement ( name = "CtrlSum")
	public void setCtrlSum(int newCtrlSum) {
		ctrlSum = newCtrlSum;
	}

	public String getData() {
		return data;
	}

	public int getId() {
		return id;
	}

	public int getNumOps() {
		return numOps;
	}

	public int getCtrlSum() {
		return ctrlSum;
	}
	
	
}
