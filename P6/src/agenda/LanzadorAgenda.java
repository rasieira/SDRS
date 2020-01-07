package agenda;

import javax.xml.ws.Endpoint;

public class LanzadorAgenda
{
	public static void main(String[] args)
	{
		AgendaTfno agenda = new AgendaTfno();
		Endpoint.publish("http://localhost:8080/TelephonList", agenda);
	}
}
