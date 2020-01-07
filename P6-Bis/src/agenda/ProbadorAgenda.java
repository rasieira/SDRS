package agenda;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import agenda.gen.*;

public class ProbadorAgenda {

	public static void main(String[] args)
	{	
		agenda.gen.TelephonList service = new TelephonList();
		AgendaTfno port = service.getAgendaTfnoPort();
		
		 Map<String, Object> reqCtx = ((BindingProvider) port).getRequestContext();
		 reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://localhost:8081/TelephonList"); 
		
		Persona p = new Persona();
		p.setNombre("Homer J Simpson");
		p.setTfno("555-555-555");
		
		//port.addPerson(p);
		
		System.out.println(port.getNumber("Homer Simpson"));
	}

}
