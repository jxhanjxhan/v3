package test;

import static org.junit.Assert.*;

import memento.Recorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import commands.CmdCut;
import receiver.Buffer;
import receiver.Clipboard;
import receiver.EditorEngine;
import receiver.Selection;

public class TestCmdCut {

	private static CmdCut c;
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Buffer b;
	private static Clipboard clip;
	private static String res;
	private static Recorder r;
	private static String res2;
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
		c = new CmdCut(ee);
		
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
		res = str.substring(s,e);
		res2 = str.substring(0, s)+str.substring(e);
		ee.cut();
		System.out.println("expected "+res);
		System.out.println("expected2 "+res2);
		System.out.println("actual "+ee.getClipboard().getContent());
		System.out.println("actual2 "+ee.getBuffer().getContent());
		assertEquals("fail11",res,ee.getClipboard().getContent());
		assertEquals("fail12",res2,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=0;
		e=1;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(s,e);
		res2 = str.substring(0, s)+str.substring(e);
		ee.cut();
		System.out.println("expected "+res);
		System.out.println("expected2 "+res2);
		System.out.println("actual "+ee.getClipboard().getContent());
		System.out.println("actual2 "+ee.getBuffer().getContent());
		assertEquals("fail21",res,ee.getClipboard().getContent());
		assertEquals("fail22",res2,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=0;
		e=0;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);		
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(s,e);
		res2 = str.substring(0, s)+str.substring(e);
		ee.cut();
		System.out.println("expected "+res);
		System.out.println("expected2 "+res2);
		System.out.println("actual "+ee.getClipboard().getContent());
		System.out.println("actual2 "+ee.getBuffer().getContent());
		assertEquals("fail31",res,ee.getClipboard().getContent());
		assertEquals("fail32",res2,ee.getBuffer().getContent());
		
		str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		s=4;
		e=2;		
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		clip.setContent("");
		res = str.substring(e,s);
		res2 = str.substring(0, e)+str.substring(s);
		ee.cut();
		System.out.println("expected "+res);
		System.out.println("expected2 "+res2);
		System.out.println("actual "+ee.getClipboard().getContent());
		System.out.println("actual2 "+ee.getBuffer().getContent());
		assertEquals("fail41",res,ee.getClipboard().getContent());
		assertEquals("fail42",res2,ee.getBuffer().getContent());
		
	}

	@Test
	public void testToString() {
		res = "Couper";
		System.out.println("expected "+res);
		System.out.println("actual "+c.toString());
		assertEquals("fail5",res,c.toString());
	}

//	@Test
//	public void testCmdCut() {
//		
//	}

}
