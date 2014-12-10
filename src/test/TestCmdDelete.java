package test;

import static org.junit.Assert.*;

import memento.Recorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import commands.*;
import receiver.Buffer;
import receiver.Clipboard;
import receiver.EditorEngine;
import receiver.Selection;

public class TestCmdDelete {

	private static CmdDelete c;
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Buffer b;
	private static Clipboard clip;
	private static String res;
	private static Recorder r;
	private static String clear;
	private static int s;
	private static int e;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ee = new EditorEngine();
		sel = new Selection ();
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		b = new Buffer();
		r = new Recorder();
		clip = new Clipboard();
		c = new CmdDelete(ee);
		System.out.println(str.toString());
		
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
		s=1;
		e=6;
		sel.setStartEnd(s,e);
		ee.setRecorder(r);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(0, s)+str.substring(e);
		clear = str.substring(s,e);
		ee.cut();
		System.out.println("clear "+clear);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail11",res,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=0;
		e=1;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(0, s)+str.substring(e);
		clear = str.substring(s,e);
		ee.cut();
		System.out.println("clear "+clear);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail2",res,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=0;
		e=0;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);		
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(0, s)+str.substring(e);
		clear = str.substring(s,e);
		ee.cut();
		System.out.println("clear "+clear);		
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail3",res,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=4;
		e=2;		
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		clip.setContent("");
		res = str.substring(0, e)+str.substring(s);
		clear = str.substring(e,s);
		ee.cut();
		System.out.println("clear "+clear);		
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail4",res,ee.getBuffer().getContent());
	}

	@Test
	public void testToString() {
		res = "Effacer";
		System.out.println("expected "+res);
		System.out.println("actual "+c.toString());
		assertEquals("fail5",res,c.toString());
	}

//	@Test
//	public void testCmdDelete() {
//		fail("Not yet implemented");
//	}

}
