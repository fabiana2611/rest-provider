package restdemo.writer;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ClientInterceptor;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

/**
 * Classe called when the method (GET,POST...) return an entity.
 * Ref: https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html/development_guide/sect-resteasy_interceptors
 * */
@Provider
@ServerInterceptor
@ClientInterceptor
public class CustomWriterInterceptor implements MessageBodyWriterInterceptor{

	 public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException{
		 System.out.println("CustomWriterInterceptor writer... (method return an entity)");
		 context.getHeaders().add("My-Header", "custom");
	     context.proceed();
	 }
}
