package kroger.odilonj.delayed_rest_product.resources;

import kroger.odilonj.delayed_rest_product.entities.Product;
import kroger.odilonj.delayed_rest_product.services.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/product")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getProduct(@PathParam("name") String name) {
        Product product = productService.getProduct(name);
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}/delayed/{time}")
    public Response getProduct(@PathParam("name") String name, @PathParam("time") int time) {
        Product product = productService.getProductWithDelay(name, time);
        return Response.ok(product).build();
    }

}
