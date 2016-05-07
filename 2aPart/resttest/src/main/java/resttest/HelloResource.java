package resttest;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("hello")
@Api(value = "/hello", description = "Say Hello!")
public class HelloResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Say Hello World",
            notes = "Anything Else?")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OKAY"),
        @ApiResponse(code = 500, message = "Something wrong in Server")})
    public Response sayHello() {
        JsonObject value = Json.createObjectBuilder()
                .add("firstName", "Jeremy")
                .add("lastName", "Chung")
                .add("message", "Hello World!")
                .build();
        return Response.status(200).entity(value).build();
    }
}