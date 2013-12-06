package webservice;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import android.util.Log;
 
public class AplicacionWeb{
	private Coneccion coneccion;
	// WebServices URL
	String serverName = "www.informaticacurico.cl";
	String urlLogin = "/listas/login.php";
	
	public AplicacionWeb(){
		coneccion = new Coneccion(serverName);
	}
	
	/**
	 * Autentificar al usuario
	 * parametros	: usuario, password
	 * retorno		: boleano indicando el estado de la autentificacion
	 * @throws AppWebException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */

	public String loginUsuario(String usuario, String password) throws AppWebException {
		 // PRIMERO: Enviar el POST y obtener el string de retorno
		String str = "nada...";
		try {				
			str = coneccion.GET_generico(urlLogin);
			
			Log.i("INTERNET", "El servidor responde correctamente: "+str);
		} catch (ClientProtocolException e) {
			Log.i("INTERNET", "CPE "+e.toString() );
			throw new AppWebException("Problemas con el cliente web");
		} catch (IOException e) {
			Log.i("INTERNET", "EXC "+e.toString() );
			throw new AppWebException("Coneccion no disponible");
		}
		return str;
	}

	
	
	/**
	 * Obtiene todos los grupos que exisetn en el servidor
	 * retorno		: un arreglo con todos los grupos del servidor
	 */
	public void getGroups(){}

	
	/**
	 * Obtiene los ultimos N mensajes de un grupo
	 * parametros	: el id del grupo, la cantidad de mensajes
	 * retorno   	: un arreglo con los ultimos 10 mensajes del grupo
	 */
	public void getLastMessagesFromGroup(){}
	
	/**
	 * Obtiene los mensajes de todo los grupos en los que esta subscrito
	 * parametros	: conjunto de ID de los grupos a los que seta subscrito
	 * retorna		: los ultimos N mensajes de cada uno de los grupos
	 */
	public void getLastMessagesFromSubscribedGroups(){}
}
