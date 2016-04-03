import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GetNumNeighborsTest
{
	public static MainPanel mp;
	
	@Before
	public void setUp()
	{
		int size = 15;
		mp = new MainPanel(size);
	}
	
	@Test
	public void testCornerZeroNeighbors()
	{
		assertEquals(mp.getNumNeighbors(0, 0), 0);
	}
	
	@Test
	public void testEdgeZeroNeighbors()
	{
		assertEquals(mp.getNumNeighbors(0, 1), 0);
	}
	
	@Test
	public void testInteriorZeroNeighbors()
	{
		assertEquals(mp.getNumNeighbors(1, 1), 0);
	}
	
	@Test
	public void testCornerOneNeighbors()
	{
		mp.getCells()[0][1].setAlive(true);
		assertEquals(mp.getNumNeighbors(0, 0), 1);
	}
	
	@Test
	public void testEdgeOneNeighbors()
	{
		mp.getCells()[0][2].setAlive(true);
		assertEquals(mp.getNumNeighbors(0, 1), 1);
	}
	
	@Test
	public void testInteriorOneNeighbors()
	{
		mp.getCells()[1][2].setAlive(true);
		assertEquals(mp.getNumNeighbors(1, 1), 1);
	}
	
	@Test
	public void testCornerEightNeighbors()
	{
		int size = mp.getCellsSize();
		mp.getCells()[size-1][size-1].setAlive(true);
		mp.getCells()[size-1][0].setAlive(true);
		mp.getCells()[size-1][1].setAlive(true);
		mp.getCells()[0][size-1].setAlive(true);
		mp.getCells()[0][1].setAlive(true);
		mp.getCells()[1][size-1].setAlive(true);
		mp.getCells()[1][0].setAlive(true);
		mp.getCells()[1][1].setAlive(true);
		assertEquals(mp.getNumNeighbors(0, 0), 8);
	}
	
	@Test
	public void testEdgeEightNeighbors()
	{
		int size = mp.getCellsSize();
		mp.getCells()[size-1][0].setAlive(true);
		mp.getCells()[size-1][1].setAlive(true);
		mp.getCells()[size-1][2].setAlive(true);
		mp.getCells()[0][0].setAlive(true);
		mp.getCells()[0][2].setAlive(true);
		mp.getCells()[1][0].setAlive(true);
		mp.getCells()[1][1].setAlive(true);
		mp.getCells()[1][2].setAlive(true);
		assertEquals(mp.getNumNeighbors(0, 1), 8);
	}
	
	@Test
	public void testInteriorEightNeighbors()
	{
		mp.getCells()[0][0].setAlive(true);
		mp.getCells()[0][1].setAlive(true);
		mp.getCells()[0][2].setAlive(true);
		mp.getCells()[1][0].setAlive(true);
		mp.getCells()[1][2].setAlive(true);
		mp.getCells()[2][0].setAlive(true);
		mp.getCells()[2][1].setAlive(true);
		mp.getCells()[2][2].setAlive(true);
		assertEquals(mp.getNumNeighbors(1, 1), 8);
	}
}
