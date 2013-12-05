package webservice;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Coneccion {
	public HttpClient httpclient;
	public HttpHost targetHost;

	public Coneccion(String serverName){
		// conecciones normales
		httpclient = new DefaultHttpClient();
		targetHost = new HttpHost(serverName);
	}

	// -------------------------- Funciones relacionadas con POST -------------------------- 
	public String POST_generico(String url_form, List<NameValuePair> parametros) throws ParseException, IOException{
		HttpPost httppost = new HttpPost( url_form );
		
		// parametros (throws UnsupportedEncodingException)
		if(parametros!=null)
			httppost.setEntity(new UrlEncodedFormEntity(parametros));
		
		HttpResponse response;
		response = httpclient.execute(targetHost, httppost);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}
	
	// Funciones relacionadas con GET 
	public String GET_generico(String urlToGet) throws ClientProtocolException, IOException{
		HttpGet httpGet = new HttpGet( urlToGet );
		HttpResponse response;

		response = httpclient.execute(targetHost, httpGet);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}
}
