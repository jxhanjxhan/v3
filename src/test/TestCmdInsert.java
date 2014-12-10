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

public class TestCmdInsert {
	
	private static CmdInsert c;
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Recorder r;
	private static Buffer b;
	private static Clipboard clip;
	private static String res;
	private static String insert;
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
		c = new CmdInsert(ee);
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
		clip.setContent("");
		ee.setClipboard(clip);
		insert =  "booooooooob";
		res = str.substring(0,s)+insert+str.substring(e);
		ee.insert(insert);
		System.out.println("expected "+res);
		System.out.println("insert "+insert);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
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
		insert =  "";
		res = str.substring(0,s)+insert+str.substring(e);
		ee.insert(insert);
		System.out.println("expected "+res);
		System.out.println("insert "+insert);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
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
		insert =  "taaaaaaaaaaaaaaat";
		res = str.substring(0,s)+insert+str.substring(e);
		ee.insert(insert);
		System.out.println("expected "+res);
		System.out.println("insert "+insert);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
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
		insert =  "eeeeeeeeeeeeee";
		res = str.substring(0,e)+insert+str.substring(s);
		ee.insert(insert);
		System.out.println("expected "+res);
		System.out.println("insert "+insert);
		System.out.println("actual "+ee.getBuffer().getContent());
		assertEquals("fail1",res,ee.getBuffer().getContent());
		
	}

	@Test
	public void testToString() {
		res = "Insérer caractère";
		System.out.println("expected "+res);
		System.out.println("actual "+c.toString());
		assertEquals("fail5",res,c.toString());
	}

//	@Test
//	public void testCmdInsert() {
//	}

}
