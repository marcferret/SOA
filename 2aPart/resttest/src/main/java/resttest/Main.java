package resttest;
import com.wordnik.swagger.jaxrs.config.BeanConfig;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ext.ContextResolver;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

    private static final URI BASE_URI
            = URI.create("http://localhost:8092/");

    public static void main(String[] args) {
        try {
            BeanConfig beanConfig = new BeanConfig();
            beanConfig.setVersion("1.0");
            beanConfig.setScan(true);
            beanConfig.setResourcePackage(
                    HelloResource.class.getPackage().getName());
            beanConfig.setBasePath(BASE_URI.toString());
            beanConfig.setDescription("Hello resources");
            beanConfig.setTitle("Hello API");

            final HttpServer server
                    = GrizzlyHttpServerFactory.createHttpServer(
                            BASE_URI, createApp());

            System.out.println(
                    String.format(
                            "Application started.%nHit enter to stop it..."));
            System.in.read();
            server.shutdownNow();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResourceConfig createApp() {
        return new ResourceConfig().
                packages(HelloResource.class.getPackage().getName(),
                        "com.wordnik.swagger.jaxrs.listing").
                register(createMoxyJsonResolver());
    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper
                = new HashMap<String, String>(1);
        namespacePrefixMapper.put(
                "http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper)
                .setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }
}