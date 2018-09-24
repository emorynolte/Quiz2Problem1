package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {

	private int iSize;
	private int iSqrtSize;
	
	
	Sudoku(int iSize)
	{
		this.iSize = iSize;
		if (Math.sqrt(iSize) % 1  != 0)
		{
			//throw exception
		}
		else 
		{
			this.iSqrtSize = (int) Math.sqrt(iSize); 
		}
		
	}
	
	Sudoku(int[][] puzzle)
	{
		super.setLatinSquare(puzzle);
	}
	
	public int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int r)
	{
		int[] reg2arr = new int[super.getLatinSquare().length];
		
		 int i = (r % iSqrtSize) * iSqrtSize;
		 int j = (r / iSqrtSize) * iSqrtSize;
		 int iMax = i + iSqrtSize;
		 int jMax = j + iSqrtSize;
		 int iCount = 0;
		 
		 for (; j < jMax; j++)
		 {
			 for (i = (r % iSqrtSize) * iSqrtSize; i < iMax; i++)
			 {
				 reg2arr[iCount++] = super.getLatinSquare()[j][i];
			 }
		 }
		 
		 return reg2arr;
	
	}
	
	public int[] getRegion(int iCol, int iRow)
	{
		// find the region and run get region
		int reg = 0;
		reg = (((iRow/iSqrtSize)*iSqrtSize)+1) + (iCol/iSqrtSize);
		return getRegion(reg);
		
	}
	
	public boolean isPartialSudoku()
	{
		return false;
	}
	
	public boolean isSudoku()
	{
		boolean isSudoku = true;
		boolean isLatinSquare = super.isLatinSquare();
		for (int i =0; i < iSize; i++)
		{
			if (super.hasDuplicates(getRegion(i)))
			{
				isSudoku = false;
			}
			
			if (!super.hasAllValues(getRegion(0), getRegion(i)))
			{
				isSudoku = false;
			}
			
		}
		
		if (isSudoku && isLatinSquare)
		{
			return true;	
		}
		else
		{
			return false;
		}
		
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
