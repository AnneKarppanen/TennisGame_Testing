import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test 
	public void testTennisGame_Player1ScoringIncreasesPlayer1Points() throws TennisGameException {
		
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored();
		// Assert
		assertEquals("15 - love is incorrect", "15 - love", game.getScore());	
		// Act
		game.player1Scored();
		//Assert
		assertEquals("30 - love is incorrect", "30 - love", game.getScore());
		//Act
		game.player1Scored();
		//Assert
		assertEquals("40 - love is incorrect", "40 - love", game.getScore());	
		
	}
		
		
		@Test 
		public void testTennisGame_Player2ScoringIncreasesPlayer2Points() throws TennisGameException {
			
		// Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		// Assert
		assertEquals("love - 15 is incorrect", "love - 15", game.getScore());	
		// Act
		game.player2Scored();
		//Assert
		assertEquals("love - 30 is incorrect", "love - 30", game.getScore());
		//Act
		game.player2Scored();
		//Assert
		assertEquals("love - 40 is incorrect", "love - 40", game.getScore());	
		
	}
		
		@Test 
		public void testTennisGame_Player1WinsScoring4love() throws TennisGameException {
			// Arrange
			TennisGame game = new TennisGame();
			
			// Act
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			// Assert
			assertEquals("player1 does not win after scoring 4 - 0", "player1 wins", game.getScore());
			
		}
			
		@Test 
		public void testTennisGame_Player2WinsScoring4love() throws TennisGameException {
			// Arrange
			TennisGame game = new TennisGame();
			
			// Act
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			// Assert
			assertEquals("player2 does not win after scoring 4 - 0", "player2 wins", game.getScore());
			
		}
		
		@Test
		public void testTennisGame_Player1Wins4to2() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			//Act
			game.player2Scored();
			game.player2Scored();
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			// Assert
			assertEquals("player1 does not win after scoring 4 - 2", "player1 wins", game.getScore());
						
			
		}
		
		@Test
		public void testTennisGame_Player2Wins4to2() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			//Act
			game.player2Scored();
			game.player2Scored();
			game.player1Scored();
			game.player1Scored();
			game.player2Scored();
			game.player2Scored();
			
			// Assert
			assertEquals("player2 does not win after scoring 4 - 2", "player2 wins", game.getScore());
						
			
		}
		
		@Test
		public void testTennisGame_PlayerHasAdvantage() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			//Act
			game.player2Scored();
			game.player2Scored();
			game.player1Scored();
			game.player1Scored();
			game.player2Scored();
			game.player1Scored();
			game.player1Scored();
			
			// Assert
			assertEquals("player1 should have advantage", "player1 has advantage", game.getScore());
			
			//Act
			game.player2Scored();
			game.player2Scored();
			
			// Assert
			assertEquals("player2 should have advantage", "player2 has advantage", game.getScore());				
			
			//Act
			game.player1Scored();
			game.player1Scored();
			
			// Assert
			assertEquals("player1 should have advantage", "player1 has advantage", game.getScore());				
			
		}
			
			
		@Test
		public void testTennisGame_EahcPlayerWin3Points_Score_Deuce() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "deuce", score);		
		}
			
		
		
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Player2WinsAfterAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		// Assert
		assertEquals("player2 should win", "player2 wins", game.getScore());
					
		
	}
	
	@Test
	public void testTennisGame_Player1WinsAfterAdvantage() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		
		// Assert
		assertEquals("player1 should win", "player1 wins", game.getScore());
					
		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
}
