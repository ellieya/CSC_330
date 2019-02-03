package edu.cuny.csi.csc330.scratch;

//import java.util.Arrays;
import java.util.Random;


public class SlotGame {
	
	private int winCreadits=0;
	private boolean winState;
	static int slotMidPosition= 0;
	Random rand = new Random();	
	
	
	//wheel contains: "melon", "bell", "7", "lemon", "bar" (5 total icons)
	static String slotBand[] = {"melon", " bell", "    7", "lemon", "  bar"};
	
			
		// slotOut is used to store the output values for the slot machine
	static String slotOut[] = new String[]
			{
					"melon","melon","melon"	
			};
	
	
	
public SlotGame()
{
init();	
}

public void checkWin()
{
	checkConections();
	if(winState)
	{
		if (slotOut[1]=="melon")
		{
			winCreadits=1;
		}
		else if (slotOut[1]=="lemon")
		{
			winCreadits=1;
		}
		else if (slotOut[1]=="bell")
		{
			winCreadits=2;
		}
		else if (slotOut[1]=="bar")
		{
			winCreadits=3;
		}
		else if (slotOut[1]=="7")
		{
			winCreadits=5;
		}
		else 
		{
			winCreadits=0;
		}
	}
	
	
}

public int getWinAmount()
{
	return winCreadits;
}

public String[] returnWheel()
{
	return slotOut;
}

private void init()
{
	getSlot( );
	
}

public void getSlot()
{
	winState=false;
	for (int i=0;i<3;i++)
	{
		slotMidPosition = rand.nextInt(5);
		if (slotMidPosition==0)
		{
			slotOut[0]=slotBand[4];
		}
		else if(slotMidPosition>=0)
		{
			slotOut[0]=slotBand[slotMidPosition-1];
		}

		slotOut[1]=slotBand[slotMidPosition];

		slotOut[2]=slotBand[(slotMidPosition+1)%5];
	}
	checkWin();
}


private void outputArray(String[] slotOut)
{
	for(int i = 0;i<3;i++)
	{
		
		
			System.out.print(slotOut[i]);
			System.out.print(" ");
			
		
		
	}
}

public void checkConections()
{
	if(slotOut[0]==slotOut[1]&&slotOut[1]==slotOut[2])
		winState = true;
	else
		winState=false;
}



}
