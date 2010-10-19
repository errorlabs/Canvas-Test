package foobar.canvastest;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import foobar.canvastest.drawing.scenes.ExampleScene;

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
