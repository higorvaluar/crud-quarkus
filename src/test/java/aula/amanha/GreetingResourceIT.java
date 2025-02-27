package aula.amanha;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@QuarkusIntegrationTest
class GreetingResourceIT extends GreetingResourceTest {
    @Path("/hello")
    @GET
    public String hello() {
        return "Hello, world!";
    }
}
