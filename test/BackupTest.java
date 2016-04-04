import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BackupTest
{
	public static MainPanel mp;
	
	@Before
	public void setUp()
	{
		int size = 15;
		mp = new MainPanel(size);
	}
	
	@Test
	public void testBackupCellsAllDead()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				mp.getCells()[i][j].setAlive(false);
			}
		}
		
		mp.backup();
		
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				assertFalse(mp.getBackupCells()[i][j].getAlive());
			}
		}
	}
	
	@Test
	public void testBackupCellsAllAlive()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				mp.getCells()[i][j].setAlive(true);
			}
		}
		
		mp.backup();
		
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				assertTrue(mp.getBackupCells()[i][j].getAlive());
			}
		}
	}
	
	@Test
	public void testBackupCellsOneAlive()
	{
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				mp.getCells()[i][j].setAlive(i==3 && j==6);
			}
		}
		
		mp.backup();
		
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				assertEquals(mp.getBackupCells()[i][j].getAlive(), i==3 && j==6);
			}
		}
	}
	
	@Test
	public void testBackupCellsSomeAlive()
	{
		Random rand = new Random(0);
		int size = mp.getCellsSize();
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				mp.getCells()[i][j].setAlive(rand.nextBoolean());
			}
		}
		
		mp.backup();
		
		rand.setSeed(0);
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				assertEquals(mp.getBackupCells()[i][j].getAlive(), rand.nextBoolean());
			}
		}
	}

}
