package test;

import static org.junit.Assert.*;

import memento.Recorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import receiver.Buffer;
import receiver.EditorEngine;
import receiver.Selection;
import commands.*;

public class TestCmdSelect {
	
	private static CmdSelect c;
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Buffer b;
	private static String res;
	private static Recorder r;
	private static int ress;
	private static int rese;
	private static int s;
	private static int e;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ee = new EditorEngine();
		sel = new Selection ();
		r = new Recorder();
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		b = new Buffer();
		c = new CmdSelect(ee);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		ee.setSelection(sel);
		ee.setRecorder(r);
		b.setText(str);
		ee.setBuffer(b);
		s=-10;
		e=5;
		ress = Math.min(ee.getBuffer().getContent().length(),Math.max(s, 0));
		rese = Math.min(ee.getBuffer().getContent().length(),Math.max(e, 0));
		ee.select(s,e);
		System.out.println("expected s: "+ress);
		System.out.println("expected e: "+rese);
		System.out.println("actual s: "+ee.getSelection().getStart());
		System.out.println("actual e: "+ee.getSelection().getEnd());
		assertEquals("fail11",ress,ee.getSelection().getStart());
		assertEquals("fail12",rese,ee.getSelection().getEnd());
		
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		s=1;
		e=1;
		ress = Math.min(ee.getBuffer().getContent().length(),Math.max(s, 0));
		rese = Math.min(ee.getBuffer().getContent().length(),Math.max(e, 0));
		ee.select(s,e);
		System.out.println("expected s: "+ress);
		System.out.println("expected e: "+rese);
		System.out.println("actual s: "+ee.getSelection().getStart());
		System.out.println("actual e: "+ee.getSelection().getEnd());
		assertEquals("fail21",ress,ee.getSelection().getStart());
		assertEquals("fail22",rese,ee.getSelection().getEnd());
		
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		s=5;
		e=-5;
		ress = Math.min(ee.getBuffer().getContent().length(),Math.max(s, 0));
		rese = Math.min(ee.getBuffer().getContent().length(),Math.max(e, 0));
		ee.select(s,e);
		System.out.println("expected s: "+rese);
		System.out.println("expected e: "+ress);
		System.out.println("actual s: "+ee.getSelection().getStart());
		System.out.println("actual e: "+ee.getSelection().getEnd());
		assertEquals("fail31",rese,ee.getSelection().getStart());
		assertEquals("fail32",ress,ee.getSelection().getEnd());
		
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		s=6;
		e=10000;
		ress = Math.min(ee.getBuffer().getContent().length(),Math.max(s, 0));
		rese = Math.min(ee.getBuffer().getContent().length(),Math.max(e, 0));
		ee.select(s,e);
		System.out.println("expected s: "+ress);
		System.out.println("expected e: "+rese);
		System.out.println("actual s: "+ee.getSelection().getStart());
		System.out.println("actual e: "+ee.getSelection().getEnd());
		assertEquals("fail41",ress,ee.getSelection().getStart());
		assertEquals("fail42",rese,ee.getSelection().getEnd());
		}

	@Test
	public void testToString() {
		res= "Sélectionner";
		System.out.println(res);
		System.out.println(c.toString());
		assertEquals("fail5",res,c.toString());
	}

//	@Test
//	public void testCmdSelect() {
//	}

}
