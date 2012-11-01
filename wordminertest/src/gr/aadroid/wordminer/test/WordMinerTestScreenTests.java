package gr.aadroid.wordminer.test;

import gr.aadroid.framework.Screen;
import gr.aadroid.wordminer.LoadingScreen;
import gr.aadroid.wordminer.MainMenuScreen;
import gr.aadroid.wordminer.PlayModeScreen;
import gr.aadroid.wordminer.WordMinerGame;
import gr.aadroid.wordminer.model.Grid;
import android.app.Instrumentation;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class WordMinerTestScreenTests extends ActivityInstrumentationTestCase2<WordMinerGame> {

	private WordMinerGame mActivity; // the activity under test
	private SurfaceView mView; // the activity's TextView (the only view)
	private String resourceString;
	LoadingScreen screen;
	MainMenuScreen menuscreen;
	private Grid grid;
	private Instrumentation mInstrumentation;
	private PlayModeScreen playModeScreen;

	public WordMinerTestScreenTests() {
		super("gr.aadroid.wordminer", WordMinerGame.class);

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mInstrumentation =this.getInstrumentation();
		
		screen = (LoadingScreen) mActivity.getStartScreen();
		mView = (SurfaceView) mActivity.getCurrentFocus();
		
		Screen tempScreen = mActivity.getCurrentScreen();
		while(tempScreen.getClass()!=MainMenuScreen.class)
		{
			tempScreen = mActivity.getCurrentScreen();
		}
		menuscreen = (MainMenuScreen) tempScreen;
		
//		grid = wmscreen.world.grid;
		// resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);
	}

	public void testPreconditions() {
		assertNotNull(screen);
		assertNotNull(mView);
//		assertNotNull(grid);
	}

	public void testClickNewGame(){
		long downTime = SystemClock.uptimeMillis();
		// event time MUST be retrieved only by this way!
		long eventTime = SystemClock.uptimeMillis();
		long xStart = menuscreen.drawingHelper.newGameMenuItemRect.x - 50;
		long yStart = menuscreen.drawingHelper.newGameMenuItemRect.y - 50;
		
		MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, xStart, yStart, 0);
		mInstrumentation.sendPointerSync(event);
		mInstrumentation.waitForIdleSync();
		 
		eventTime = downTime = SystemClock.uptimeMillis() + 2000;
		
		event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, xStart, yStart, 0);
		mInstrumentation.sendPointerSync(event);
		
		Screen tempScreen =  mActivity.getCurrentScreen();
		while(tempScreen.getClass()!=PlayModeScreen.class)
		{
			tempScreen = mActivity.getCurrentScreen();
		}
		
		assertEquals(PlayModeScreen.class, mActivity.getCurrentScreen().getClass());
	}
//	public void testText() {
//		Cell cell = grid.getCells().get(0).get(0);
//		Position pos = cell.position;
//		MotionEvent e = MotionEvent.obtain( SystemClock.uptimeMillis(),
//                SystemClock.uptimeMillis(), 
//                MotionEvent.ACTION_DOWN, 
//                pos.getX(), pos.getY(), 0);
//
//		assertTrue(mView.dispatchTouchEvent(e));
////		assertEquals(1, wmscreen.world.wordChosen.size());
//	}
}
