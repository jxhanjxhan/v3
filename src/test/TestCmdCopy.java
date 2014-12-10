
package test;

import static org.junit.Assert.*;

import memento.Recorder;

import org.junit.Test;

import commands.*;
import receiver.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Test;

/**
 * @author Archibald Jego & Johan Moreira
 */

public class TestCmdCopy {

	/**
	 * Test method for {@link commands.CmdCopy#execute()}.
	 */
	private static EditorEngine ee;
	private static Selection sel;
	private static StringBuffer str;
	private static Buffer b;
	private static Clipboard clip;
	private static Recorder r;
	private static String res;
	private static int s;
	private static int e;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
		ee = new EditorEngine();
		sel = new Selection ();
		r = new Recorder();
		str = new StringBuffer("abcdefghij");
		b = new Buffer();
		clip = new Clipboard();
		System.out.println("avant tout");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("après tout");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("après un test");
		
	}
	
	@Test
	public void testExecute() {
		s=1;
		e=5;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		ee.setRecorder(r);
		ee.copy();
		res = str.substring(s,e);
		ee.copy();
		res = str.substring(s,e);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getClipboard().getContentStrBuff());
		assertEquals("fail1",res,ee.getClipboard().getContent());
		
		s=8;
		e=9;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		ee.copy();
		res = str.substring(s,e);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getClipboard().getContentStrBuff());
		assertEquals("fail2",res,ee.getClipboard().getContent());
		
		s=0;
		e=6;
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		ee.copy();
		res = str.substring(s,e);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getClipboard().getContentStrBuff());
		assertEquals("fail2",res,ee.getClipboard().getContent());
		
		s=4;
		e=2;		
		sel.setStartEnd(s,e);
		ee.setSelection(sel);
		b.setText(str);
		ee.setBuffer(b);
		ee.setClipboard(clip);
		ee.copy();
		res = str.substring(e,s);
		System.out.println("expected "+res);
		System.out.println("actual "+ee.getClipboard().getContentStrBuff());
		assertEquals("fail trop grand",res,ee.getClipboard().getContent());
		
	}

	/**
	 * Test method for {@link commands.CmdCopy#toString()}.
	 */
	@Test
	public void testToString() {
		EditorEngine ee = new EditorEngine();
		CmdCopy cp = new CmdCopy(ee); 
		String res = "Copier";
		assertEquals("fail3",res,cp.toString());
	}

	/**
	 * Test method for {@link commands.CmdCopy#CmdCopy(receiver.EditorEngine)}.
	 */
//	@Test
//	public void testCmdCopy() {
//		fail("Not yet implemented2");
//	}

}
