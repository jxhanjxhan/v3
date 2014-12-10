package test;


import static org.junit.Assert.*;

import org.junit.Test;

import receiver.*;

public class TestBuffer {


//	@Test
//	public final void testGetContentIntInt() {
//		Buffer buff = new Buffer();
//		String res;
//		int a, b;
//		StringBuffer t = new StringBuffer("");
//		a=0;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a et b nuls", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a > b, a > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a < b, b > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=5;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a et b > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=-5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=0;
//		b=-5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, b negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est vide, a et b negatifs", buff.getContent(a,b) == res);
//		
//		t = new StringBuffer("abc");
//		a=0;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a et b nuls", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a > b, a > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a < b, b > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=5;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a et b > t.length()", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=-5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=0;
//		b=-5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, b negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("abc");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a et b negatifs", buff.getContent(a,b) == res);
//		
//		t = new StringBuffer("abcdef");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a < b", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=0;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a et b nuls", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a > b", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=5;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a=b", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=-5;
//		b=0;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=0;
//		b=-5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, b negatif", buff.getContent(a,b) == res);
//		t = new StringBuffer("abcdef");
//		a=0;
//		b=5;
//		buff.setText(t);
//		res = "";
//		assertTrue("text est non vide, a et b negatifs", buff.getContent(a,b) == res);
//	}

//	@Test
//	public void testSetContent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetContent() {
		Buffer buff = new Buffer();
		String res;
		res = buff.getText().toString();
		assertEquals(buff.getContent(),res);
		StringBuffer t = new StringBuffer("abc");
		buff.setText(t);
		res = buff.getText().toString();
		assertEquals("text est non vide", buff.getContent(),res);	
	}

}
