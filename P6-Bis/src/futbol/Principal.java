package futbol;
import java.io.IOException;
import java.io.PrintWriter;

import futbol.gen.*;

public class Principal
{
	public static void main(String[] args)
	{
		System.setProperty("javax.net.ssl.trustStore","C:\\Users\\pamendoz\\Desktop\\CA");
		
		Info service = new Info();
		InfoSoapType port = service.getInfoSoap();
		
		ArrayOftTeamPlayerGoalsRankInfo rank = port.playersWithGoalsRanked();
		ArrayOftPlayer players = port.teamPlayers("Spain", true);
		
		try(PrintWriter printer = new PrintWriter("src/TXT.txt"))
		{
			printer.println("----MAXIMOS GOLEADORES----");
			for(TTeamPlayerGoalsRankInfo P:rank.getTTeamPlayerGoalsRankInfo())
			{
				printer.println(P.getSName()+" "+P.getIGoals());
			}
			printer.println("----JUGADORES ESPAÑA----");
			for(TPlayer P :players.getTPlayer())
			{
				printer.println(P.getSFullName());
			}
			printer.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
