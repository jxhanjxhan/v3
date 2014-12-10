package test;

import static org.junit.Assert.*;

import memento.Recorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import receiver.Buffer;
import receiver.Clipboard;
import receiver.EditorEngine;
import receiver.Selection;
import commands.*;

public class TestCmdPaste {

	private static CmdPaste c;
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Recorder r;
	private static Buffer b;
	private static Clipboard clip;
	private static String res;
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
		c = new CmdPaste(ee);
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
		ee.setSelection(sel);
		ee.setRecorder(r);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("boooobeeee");
		ee.setClipboard(clip);
		res = str.substring(0,s)+clip.getContent()+str.substring(e);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
		e=s+clip.getContent().length();
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("boooobeeee");
		ee.setClipboard(clip);
		res = str.substring(0,s)+clip.getContent()+str.substring(e);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
		s=e;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("boooobeeee");
		ee.setClipboard(clip);
		res = str.substring(0,s)+clip.getContent()+str.substring(e);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
		
		s=0;
		e=10;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("");
		ee.setClipboard(clip);
		res = str.substring(0,s)+clip.getContent()+str.substring(e);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
		s=1;
		e=1;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("azesdgtfhjfnubqzvfd");
		ee.setClipboard(clip);
		res = str.substring(0,s)+clip.getContent()+str.substring(e);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
		s=8;
		e=5;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		clip.setContent("boooobeeee");
		ee.setClipboard(clip);
		res = str.substring(0,e)+clip.getContent()+str.substring(s);
		ee.paste();
		System.out.println("expected "+res);
		System.out.println("clip  "+clip.getContent());
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
	}

	@Test
	public void testToString() {
		res= "Coller";
		System.out.println(res);
		System.out.println(c.toString());
		assertEquals("fail5",res,c.toString());
		
	}

//	@Test
//	public void testCmdPaste() {
//	}

}
