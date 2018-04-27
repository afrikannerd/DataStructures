package Struct;

import java.util.Arrays;

public class Stack implements Structures
{

	
	private String [] stackList;
	private int top = -1;
	private int stackSize;
	public Stack(int size)
	{
		stackSize = size;
		stackList = new String[stackSize];
	}

	public static void main(String[] args)
	{  
		try {
		int num [] = new int[] {33,54,12,56,78,22,45,77 ,743,22,467};
		Stack st = new Stack(10);
		st.push(10);
		st.push(56);
		st.push(num);
		System.out.println(Arrays.toString(st.popAll()) + " were popped");
		
		
		
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Outta bounds ");
		}
	}

	@Override
	public void push(int item) throws ArrayIndexOutOfBoundsException
	{
		if(top <= stackSize - 1)
		{	
			stackList[++top] = String.valueOf(item);
		}else
		{
			System.out.printf("The stack is full with %d items",stackSize);
		}
		
	}
	
	void push(int [] item) throws ArrayIndexOutOfBoundsException
	{
		for(int i = 0; i <  item.length; i++)
		{
			if(top <= stackSize - 2)
			{	
				stackList[++top] = String.valueOf(item[i]);
			}else
			{
				System.out.printf("The stack is full with %d items\n last %d items not added\n",stackSize,(item.length - i));
				break;
			}
		}
	}

	@Override
	public String pop()
	{
		String popped;
		if(top >= 0) 
		{
			display();
			
			popped = stackList[top];
			stackList[top] = "";
			top--;
			return popped;
			
		}
		
		return "Stack empty";
	}
	
	String [] popAll()
	{
		String [] popped = new String[top + 1];
		while(top >= 0) 
		{
			display();
			
			popped[top] = stackList[top];
			stackList[top] = "";
			top--;
			
			
		}
		
		return  popped;
	}

	@Override
	public void display()
	{
		for(int i = 0; i < 61; i++)
			System.out.print("+");
		System.out.println();
		for(int i = 0; i < stackSize; i++)
			System.out.format("| %2s "+" ", i);
		System.out.println("|");
		for(int i = 0; i < 61; i++)
			System.out.print("+");
		System.out.println();
		for(int i = 0; i < stackSize; i++)
		{
			if(i <= top)
				System.out.print(String.format("| %2s "+" ", stackList[i]));
			else
				System.out.print("|     ");
				
			
		}
		System.out.println("|");
		for(int i = 0; i < 61; i++)
			System.out.print("+");
		System.out.println();
	}

	@Override
	public void peek()
	{
		display();
		
	}

}
