package foobar.canvastest;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import foobar.canvastest.drawing.scenes.ExampleScene;

/**
 * This is the main "Activity", the Android equivalent of a page or form.
 * 
 * Its UI corresponds to what is given in res/layout/main.xml
 * One of the elements, the actual MySurfaceView we draw on, is created
 * programatically as opposed to being in the xml. This is because it is a
 * custom class without any XML binding
 */
public class MainCanvasActivity extends Activity {
	MySurfaceView mSurfaceView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ViewGroup containerView = (ViewGroup)findViewById(R.id.containerView);
		mSurfaceView = new MySurfaceView(this, new ExampleScene());

		containerView.addView(mSurfaceView);
	}
}
