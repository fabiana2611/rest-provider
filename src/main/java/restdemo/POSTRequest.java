package restdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp
public class POSTRequest {
	
	public static void main(String[] args) throws IOException {
//	    execute("noreturn");
	    execute("withreturn");
	}

	public static void execute(String path) throws IOException {
	    final String POST_PARAMS = "{\n   \"id\": 101,\r\n  \"name\": \"Test Name\" \n}";
	    System.out.println(POST_PARAMS);
	    URL obj = new URL("http://localhost:8080/MyRESTDemoApp/rest/post/"+path);
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	}
}
