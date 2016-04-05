import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IterateCellTest
{
	private static MainPanel mp;

	@Before
	public void setUp()
	{
		mp = new MainPanel(15);
	}
	
	@Test
	public void testAliveTooFewNeighbors()
	{
		boolean alive = true;
		int numNeighbors = 1;
		assertFalse(mp.iterateCell(alive, numNeighbors));
	}
	
	@Test
	public void testAliveEnoughNeighbors()
	{
		boolean alive = true;
		int numNeighbors = 2;
		assertTrue(mp.iterateCell(alive, numNeighbors));
	}
	
	@Test
	public void testAliveTooManyNeighbors()
	{
		boolean alive = true;
		int numNeighbors = 4;
		assertFalse(mp.iterateCell(alive, numNeighbors));;
	}

	@Test
	public void testDeadTooFewNeighbors()
	{
		boolean alive = false;
		int numNeighbors = 2;
		assertFalse(mp.iterateCell(alive, numNeighbors));
	}

	@Test
	public void testDeadEnoughNeighbors()
	{
		boolean alive = false;
		int numNeighbors = 3;
		assertTrue(mp.iterateCell(alive, numNeighbors));
	}
	
	@Test
	public void testDeadTooManyNeighbors()
	{
		boolean alive = false;
		int numNeighbors = 4;
		assertFalse(mp.iterateCell(alive, numNeighbors));
	}
}
