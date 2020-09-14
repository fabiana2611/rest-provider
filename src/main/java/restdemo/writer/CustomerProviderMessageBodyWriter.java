package restdemo.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import restdemo.model.Entity;

/**
 * Classe called when the method (GET,POST...) return an entity.
 * Ref: https://abhishek-gupta.gitbook.io/rest-assured-with-jaxrs/jax-rs-providers-part-i
 * */
@Provider
public class CustomerProviderMessageBodyWriter implements MessageBodyWriter<Entity>{

	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("CustomerProviderMessageBodyWriter isWriteable ...");
        return true;
	}

	public long getSize(Entity t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("CustomerProviderMessageBodyWriter GetSize...");
		return 0;
	}

	public void writeTo(Entity t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		System.out.println("CustomerProviderMessageBodyWriter writeTo ...");
	}

}
