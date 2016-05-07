package resttest;

import java.io.StringReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Path("postureo")
public class Post {
	
	static ArrayList<String> posts = new ArrayList();

	Capcelera capcelera1;
	
	@POST
	public int insertMessage(String xml) {
		
		System.err.println("error: " + xml);
		
		posts.add(xml);
		System.out.println("Num posts: " + posts.size() + " ID post: " + (posts.size() - 1));

		StringReader reader = new StringReader(xml);
		
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Capcelera.class);
			Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
			capcelera1 = (Capcelera) jaxbUnmarshaller.unmarshal(reader);
			
			System.out.println("TOT OK" + capcelera1.getCtrlSum());
			
		} catch (JAXBException e) {
			System.out.println("MUY MAL");
			e.printStackTrace();
		}
		
		return (posts.size() - 1);
	}
	
	@GET
	public Response getMessage(@QueryParam("id") int id) {
		
			System.out.println("id " + id);
			if(id < posts.size()){ 
				posts.get(id);
				
				JsonObject value = Json.createObjectBuilder()
		                .add("xml", posts.get(id))
		                .build();
		        return Response.status(200).entity(value).build();
			} else {
				//ERROR
				return Response.status(400).build();
			}
	}
	
}
