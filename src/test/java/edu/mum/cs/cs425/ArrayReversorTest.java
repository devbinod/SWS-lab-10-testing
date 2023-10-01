package edu.mum.cs.cs425;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayReversorTest
{
	public ArrayReversor arrayReversor;
	public IArrayFlattenerService arrayFlattenerService=mock(IArrayFlattenerService.class);
	
	@Before
	public void setUp() throws Exception 
	{
		this.arrayReversor=new ArrayReversor(arrayFlattenerService);
	}
	

	@After
	public void tearDown() throws Exception 
	{
		this.arrayReversor=null;
	}

	@Test
	public void testReverseFlattenedArray() 
	{
		int[][] inputArray= {{1,2},{3},{4,5,6}};
		when(arrayFlattenerService.flattenArray(inputArray)).thenReturn(new int[] {1,2,3,4,5,6});
		int[] actual=arrayReversor.reverseFlattenedArray(inputArray);
		assertThat(actual,is(new int[] {6,5,4,3,2,1}));
	}
	
	@Test
	public void testReverseFlattenedArrayWhenInputNull() 
	{
		int[][] inputArray=null;
		arrayFlattenerService.flattenArray(null);
		Mockito.verify(arrayFlattenerService).flattenArray(ArgumentMatchers.isNull());
	}
}
