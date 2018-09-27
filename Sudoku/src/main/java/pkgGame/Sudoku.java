package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare
{
	private int iSize;
	private int iSqrtSize;
	
	
	
	public Sudoku(int iSize) throws Exception
	{
		try
		{
			this.iSize = iSize;
			this.iSqrtSize = (int)Math.sqrt(iSize);
			
			if(iSize % 1 != 0)
			{
				throw new Exception();
			}
		}
		catch (Exception e)
		{
			throw e; 
		}
	}
	
	
	public Sudoku(int[][] puzzle) throws Exception
	{
		super(puzzle);
		
		try
		{
			this.iSize = puzzle.length;
			this.iSqrtSize = (int)Math.sqrt(iSize);
			
			if(iSize % 1 != 0)
			{
				throw new Exception();
			}
		}
		catch (Exception e)
		{
			throw e; 
		}
	}
	
	
	
	public int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	
	
	public int[] getRegion(int r)
	{
		int i = (r % iSqrtSize) * iSqrtSize;
		int j = (r / iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize; 
		int jMax = j + iSqrtSize;
		int iCnt = 0; 
		int reg[] = new int[super.getLatinSquare().length];
		
		for (; j < jMax; j++)
		{
			for ( i = (r % iSqrtSize) * iSqrtSize; i < iMax; i++)
			{
				reg[iCnt++] = super.getLatinSquare()[j][i];
			}
		}
		return reg; 
	}
	
	
	public int[] getRegion(int iCol, int iRow)
	{
		int add = iCol / iSqrtSize;
		int mult = iRow / iSqrtSize;
		
		return getRegion(iSqrtSize * mult + add);
	}
	
	
	public boolean isPartialSudoku()
	{
		boolean isPartialSudoku = true;
		
		if (!ContainsZero())
		{
			return false;
		}
		
		return isPartialSudoku;
	}
		
		
		
	
	
	public boolean isSudoku()
	{
		boolean isPartialSudoku = true;
		
		if (!super.isLatinSquare()) //checks for latinsquare
		{
			isPartialSudoku = false;
		}
		
		for (int i = 0; i < iSize; i++) //checks for duplicates and has all values
		{
			if (super.hasDuplicates(getRegion(i)))
			{
				isPartialSudoku = false;
			}
			
			if (!super.hasAllValues(super.getRow(0), getRegion(i)))
			{
				isPartialSudoku = false;
			}
		}
		
		if (isPartialSudoku && !super.ContainsZero()) //checks for zeroes
		{
			return true;
		}
		
		return false;
	}
	
	
	public boolean isValidValue(int iCol, int iRow, int iValue)
	{
		boolean isValidValue = true;
		
		if ((super.doesElementExist(super.getColumn(iCol), iValue)) || (super.doesElementExist(super.getRow(iRow), iValue)))
		{
			isValidValue = false;
		}
		return isValidValue;
	}
}

