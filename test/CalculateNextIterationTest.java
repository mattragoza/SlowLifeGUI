import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculateNextIterationTest
{
	private static MainPanel mp;
	
	@Before
	public void setUp()
	{
		mp = new MainPanel(15);
	}

	@Test
	public void testAllDead()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				mp.getCells()[i][j].setAlive(false);
		
		boolean[][] nextIter = mp.calculateNextIteration();
		
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				assertFalse(nextIter[i][j]);
	}
	
	@Test
	public void testAllAlive()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				mp.getCells()[i][j].setAlive(true);
		
		boolean[][] nextIter = mp.calculateNextIteration();
		
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				assertFalse(nextIter[i][j]);
	}
	
	@Test
	public void testXPattern()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				mp.getCells()[i][j].setAlive(false);
		
		mp.getCells()[6][6].setAlive(true);
		mp.getCells()[6][8].setAlive(true);
		mp.getCells()[7][7].setAlive(true);
		mp.getCells()[8][6].setAlive(true);
		mp.getCells()[8][8].setAlive(true);
		
		boolean[][] nextIter = mp.calculateNextIteration();
		
		assertFalse(nextIter[6][6]);
		assertFalse(nextIter[6][8]);
		assertFalse(nextIter[7][7]);
		assertFalse(nextIter[8][6]);
		assertFalse(nextIter[8][8]);
		
		assertTrue(nextIter[6][7]);
		assertTrue(nextIter[7][6]);
		assertTrue(nextIter[7][8]);
		assertTrue(nextIter[8][7]);
	}
	
	@Test
	public void testWalkerPattern()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				mp.getCells()[i][j].setAlive(false);
		
		mp.getCells()[7][6].setAlive(true);
		mp.getCells()[7][7].setAlive(true);
		mp.getCells()[7][8].setAlive(true);
		mp.getCells()[8][8].setAlive(true);
		mp.getCells()[9][7].setAlive(true);
		
		boolean[][] nextIter = mp.calculateNextIteration();
		
		assertTrue(nextIter[6][7]);
		assertFalse(nextIter[7][6]);
		assertTrue(nextIter[7][7]);
		assertTrue(nextIter[7][8]);
		assertTrue(nextIter[8][6]);
		assertFalse(nextIter[8][7]);
		assertTrue(nextIter[8][8]);
		assertFalse(nextIter[9][7]);
	}
}
