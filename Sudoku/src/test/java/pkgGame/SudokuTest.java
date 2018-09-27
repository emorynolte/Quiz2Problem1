package pkgGame;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class SudokuTest 
{
	@Test
	public void sudoku_test1()
	{
		
	}
	
	@Test
	public void sudoku_test2()
	{
		
	}
	
	
	
	@Test
	public void getPuzzle_test1() throws Exception
	{
		int twoDimArr[][] = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(Arrays.equals(twoDimArr, s.getPuzzle()));
	}
	
	@Test
	public void getPuzzle_test2() throws Exception
	{
		int twoDimArr1[][] = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
		int twoDimArr2[][] = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
		Sudoku s = new Sudoku(twoDimArr1);
		
		assertFalse(Arrays.equals(twoDimArr2, s.getPuzzle()));
	}
	
	
	
	@Test
	public void getRegion_test1() throws Exception //true using iCol iRow
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } };
		int oneDimArr[] = { 2, 4, 3, 1 }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(Arrays.equals(oneDimArr, s.getRegion(1, 2)));
	}
	
	@Test
	public void getRegion_test2() throws Exception //false using iCol iRow
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } };
		int oneDimArr[] = { 1, 1, 1, 1 }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(Arrays.equals(oneDimArr, s.getRegion(1, 2)));
	}
	
	@Test
	public void getRegion_test3() throws Exception //true using region index
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } };
		int oneDimArr[] = { 2, 4, 3, 1 }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(Arrays.equals(oneDimArr, s.getRegion(2)));
	}
	
	@Test
	public void getRegion_test4() throws Exception //false using region index
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } };
		int oneDimArr[] = { 1, 1, 1, 1 }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(Arrays.equals(oneDimArr, s.getRegion(2)));
	}
	
	
	
	@Test
	public void isPartialSudoku_test1() throws Exception //true
	{
		int twoDimArr[][] = { { 0, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } };
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(s.isPartialSudoku());
	}
	
	@Test
	public void isPartialSudoku_test2() throws Exception //false by no zeroes: full sudoku
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(s.isPartialSudoku());
	}
	
	
	
	@Test
	public void isSudoku_test1() throws Exception //true
	{
		int twoDimArr[][] = { { 1, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(s.isSudoku());
	}	
	
	@Test
	public void isSudoku_test2() throws Exception //false by duplicates
	{
		int twoDimArr[][] = { { 3, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(s.isSudoku());
	}
		
	@Test
	public void isSudoku_test3() throws Exception //false by hasAllValues == false
	{
		int twoDimArr[][] = { { 5, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(s.isSudoku());
	}
	
	
	
	@Test
	public void isValidValue_test1() throws Exception //true
	{
		int twoDimArr[][] = { { 0, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertTrue(s.isValidValue(0, 0, 1));
	}
	
	@Test
	public void isValidValue_test2() throws Exception //false by duplicates
	{
		int twoDimArr[][] = { { 0, 3, 4, 2 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 3, 1, 2, 4 } }; 
		Sudoku s = new Sudoku(twoDimArr);
		
		assertFalse(s.isValidValue(0, 0, 2));
	}
}