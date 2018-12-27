package com.github.afrikannerd;
/**
 * 
 * @author  nerd <https://github.com/afrikannerd>
 * 
 *
 * @param <E> generic type
 */
public class CircularBuffer<E> {
	int base = -1;
	int top = -1;
	int queueSize;
	E [] Queue;
	E popped;
	/**initializes the array
	 * 
	 * @param size the array size
	 */
	public CircularBuffer(int size) {
		this.queueSize = size;
		Queue = (E[]) new Object[this.queueSize];
	}

	/**Adds value to the rear of the array
	 * 
	 * @param element value to be enqueued
	 */
	void enqueue(E element)
	{
		
		
		if(isFull())
		{
			System.out.println("Queue full");
			return;
		}
		if(base == -1)
		{
			base = top = 0;
			Queue[top] = (E) element;
		}else if(top == (queueSize - 1) && base != 0)
		{
			 top = 0;
			 Queue[top] = (E) element;
		}else
		{
			
			Queue[++top] = (E) element;
		}
		
		
	}
	/**Deletes value at the {@link #base}.
	 * increments {@link #base}
	 * 
	 * @return value of generic type E
	 */
	E dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue Empty");
			
			return (E) null;
		}
		if(top == queueSize - 1)top = 0;
		if (top == base)
		{
			popped  = Queue[base];
			Queue[base] = (E)"";
			top = base = -1;
			
		}else
		{
		popped  = Queue[base];
		Queue[base] = (E)"";
		base++;
		}
		
		return popped;
	}
	/**Check if array is empty
	 * 
	 * @return boolean
	 */
	boolean isEmpty()
	{
		return (base == -1);
	}
	
	/**Check if array is full
	 * 
	 * @return boolean
	 */
	boolean isFull()
	{
		return (base == 0 && top == (queueSize - 1)  || top == (base - 1));
	}
	/**
	 * display array contents
	 */
	void peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue Empty");
			return;
		}
		for(int x = 0; x < queueSize*8;x++)
			System.out.print("+");
		System.out.println();
		System.out.print("|");
		for(int x = 0; x < queueSize; x++)
			System.out.print("   " + x + "\t|");
		System.out.println();
		for(int x = 0; x < queueSize*8;x++)
			System.out.print("+");
		System.out.println();
		System.out.print("|");
		for(int x = 0; x < queueSize; x++)
			System.out.print("  " + Queue[x] + "\t|");
		System.out.println();
		for(int x = 0; x < queueSize*8;x++)
			System.out.print("+");
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularBuffer<Integer> array = new CircularBuffer<>(10);
		array.enqueue(20);
		array.enqueue(17);
		array.enqueue(1);
		array.enqueue(109);
		array.enqueue(34);
		array.dequeue();
		array.enqueue(1);
		array.enqueue(109);
		array.enqueue(34);
		array.dequeue();
		array.enqueue(222);
		array.enqueue(223);
		array.enqueue(224);
		array.enqueue(1);
		array.dequeue();
		array.dequeue();
		array.dequeue();
		array.peek();
		/*
		 * ==================================================================================
		 * 							OUTPUT
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * |   0	|   1	|   2	|   3	|   4	|   5	|   6	|   7	|   8	|   9	|
         * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         * |  224	|  1	|  	    |  	    |  	    |  1	|  109	|  34	|  222	|  223	|
         * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 
		 */

	}
}
