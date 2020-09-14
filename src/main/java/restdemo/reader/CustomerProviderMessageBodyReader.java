package restdemo.reader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import restdemo.model.Entity;

/**
 * Class called when the parameter to read is not the usual
 * Ref:https://abhishek-gupta.gitbook.io/rest-assured-with-jaxrs/jax-rs-providers-part-i
 * */
@Provider
public class CustomerProviderMessageBodyReader  implements MessageBodyReader<Entity>{

	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("CustomerProviderMessageBodyReader isReadable... ");
        return true;
	}

	public Entity readFrom(Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
		System.out.println("CustomerProviderMessageBodyReader readFrom...");
		Entity entity = new Entity();
		entity.setId("1");
		entity.setName("New Name");
		return entity;
	}
}
