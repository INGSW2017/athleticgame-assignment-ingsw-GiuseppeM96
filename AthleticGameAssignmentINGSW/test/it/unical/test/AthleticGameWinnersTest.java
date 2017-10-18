package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {

	private static AthleticGame game;
	
	@BeforeClass
	public static void initialize(){
		game=new AthleticGame("run");
	}
	
	@After 
	public void resetGame(){
		game.reset();
		System.out.println("Istance reset");
	}
	
	@Before
	public void startGame(){
		game.start();
		System.out.println("Instance start");
	}
	
	@Test
	public void getWinnerWorks(){
		game.addArrival("ciccio", Instant.now());
		game.addArrival("peppe", Instant.now().plusMillis(2000));
		game.addArrival("zav", Instant.now().minusMillis(3000));
		game.addArrival("nich", Instant.now().minusMillis(5000));
		Assert.assertEquals("nich", game.getWinner());
	}
	
	@Test
	public void getWinnerWorks2(){
		Instant arrival=Instant.now();
		game.addArrival("ciccio", arrival);
		game.addArrival("peppe", arrival.plusMillis(2000));
		game.addArrival("zav", arrival.plusMillis(3000));
		game.addArrival("nich", arrival);
		Assert.assertNotEquals("peppe", game.getWinner());
		Assert.assertNotEquals("zav", game.getWinner());
	}
}
