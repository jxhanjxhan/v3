package test;

import static org.junit.Assert.*;
import receiver.*;

import org.junit.Test;

public class TestSelection {
	
	Selection sel = new Selection();
	int s;
	int e;

	@Test
	public void testGetStart() {
		
		s=1;
		e=5;
		sel.setStartEnd(s, e);
		assertTrue(sel.getStart()==s);
		
		s=7;
		e=9;
		sel.setStartEnd(s, e);
		assertTrue(sel.getStart()==s);
		
		s=5;
		e=0;
		sel.setStartEnd(s, e);
		assertTrue(sel.getStart()==e);
	}

	@Test
	public void testGetEnd() {
		
		s=1;
		e=5;
		sel.setStartEnd(s, e);
		assertTrue(sel.getEnd()==e);
		
		s=7;
		e=9;
		sel.setStartEnd(s, e);
		assertTrue(sel.getEnd()==e);
		
		s=5;
		e=0;
		sel.setStartEnd(s, e);
		assertTrue(sel.getEnd()==s);
		
	}

	@Test
	public void testSetStartEnd() {
		
		s=1;
		e=5;
		sel.setStartEnd(s, e);
		assertTrue("fail11",sel.getStart()==s);
		assertTrue("fail12",sel.getEnd()==e);
		
		s=7;
		e=9;
		sel.setStartEnd(s, e);
		assertTrue("fail21",sel.getStart()==s);
		assertTrue("fail22",sel.getEnd()==e);
		
		s=5;
		e=0;
		sel.setStartEnd(s, e);
		assertTrue("fail31",sel.getStart()==e);
		assertTrue("fail32",sel.getEnd()==s);
		
		s=-5;
		e=1;
		sel.setStartEnd(s, e);
		assertTrue("fail41",sel.getStart()==0);
		assertTrue("fail44",sel.getEnd()==e);
		
		s=2;
		e=-8;
		sel.setStartEnd(s, e);
		assertTrue("fail51",sel.getStart()==0);
		assertTrue("fail55",sel.getEnd()==s);
	}
	

}
