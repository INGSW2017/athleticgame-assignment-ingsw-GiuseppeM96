package it.unical.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameBasicTest {

	//testare il metodo addArrival(String participant, Instant arrival). 
	//verificare che, aggiungendo un nuovo arrivo, la taglia della mappa arrivals diventi pari ad 1
	@Test
	public void addArrivalWorks(){
		AthleticGame games=new AthleticGame("run");
		games.addArrival("peppe", Instant.now());
		Assert.assertEquals(1, games.getArrivals().size());
	}
	//verificare che getParecipiantTime(String participant) lanci un'eccezione in caso di partecipante non valido
	
	@Test(expected=IllegalArgumentException.class)
	public void getParticipantWorks(){
		AthleticGame games=new AthleticGame("soccer");
		games.getParecipiantTime("ciao");
	}
}
