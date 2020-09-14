package restdemo.reader;

import java.io.IOException;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ClientInterceptor;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyReaderContext;
import org.jboss.resteasy.spi.interception.MessageBodyReaderInterceptor;

import restdemo.model.Entity;

/**
 * Class called when the parameter to read is not the usual
 * */
@Provider
@ServerInterceptor
@ClientInterceptor
public class CustomReaderInterceptor implements MessageBodyReaderInterceptor{

	public Object read(MessageBodyReaderContext context) throws IOException, WebApplicationException {
		System.out.println("CustomReaderInterceptor read...");
		Entity newEntity = new Entity();
		newEntity.setId("newId");
		newEntity.setName("NewName");
		return newEntity;
	}

}
