package foobar.canvastest;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created using this guide:
 * http://developer.android.com/guide/topics/graphics/index.html#on-surfaceview
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	public MySurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		SurfaceHolder holder = this.getHolder();
		holder.addCallback(this);
	}

	/**
	 * A method from SurfaceHolder.Callback
	 * 
	 * From the Android documentation:
	 * This is called immediately after any structural changes
	 * (format or size) have been made to the surface. This method
	 * is always called at least once, after surfaceCreated().
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
	}

	/**
	 * A method from SurfaceHolder.Callback
	 * 
	 * From the Android documentation:
	 * This is called immediately after the surface is first created.
	 *  Implementations of this should start up whatever rendering code 
	 *  they desire.
	 */
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
	}

	/**
	 * A method from SurfaceHolder.Callback
	 * 
	 * From the Android documentation:
	 * This is called immediately before a surface is being destroyed.
	 * After returning from this call, you should no longer try to
	 * access this surface. If you have a rendering thread that directly
	 * accesses the surface, you must ensure that thread is no longer
	 * touching the Surface before returning from this function.
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
	}
}
