package agenda;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "TelephonList")
public class AgendaTfno
{
	private ConcurrentMap<String,String> agenda = new ConcurrentHashMap<>();
	
	@WebMethod(operationName = "addPerson")
	public void aniadeTfno(@WebParam(name = "person") Persona p)
	{
		agenda.put(p.getNombre(), p.getTfno());
	}
	
	@WebMethod(operationName = "getNumber")
	public String getTfno(@WebParam(name = "name")String nombre)
	{
		return agenda.get(nombre);
	}
}