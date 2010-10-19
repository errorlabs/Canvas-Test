package foobar.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import foobar.canvastest.drawing.Drawable;

/**
 * An on-screen UI element that contains the Canvas that we draw on
 * 
 * Created using this guide:
 * http://developer.android.com/guide/topics/graphics/index.html#on-surfaceview
 * 
 * Modeled after and snipping code from:
 * http://developer.android.com/resources/samples/LunarLander/src/com/example/android/lunarlander/LunarView.html
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	private MyDrawingThread mDrawingThread;

	public MySurfaceView(Context context, Drawable scene) {
		super(context);
		SurfaceHolder holder = this.getHolder();
		holder.addCallback(this);

		mDrawingThread = new MyDrawingThread(holder, context);
		mDrawingThread.setScene(scene);
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
		mDrawingThread.setRunning(true);
		mDrawingThread.start();
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
		// we have to tell thread to shut down & wait for it to finish, or else
		// it might touch the Surface after we return and explode
		boolean retry = true;
		mDrawingThread.setRunning(false);
		while (retry) {
			try {
				mDrawingThread.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	public void setScene(Drawable newScene) {
		mDrawingThread.setScene(newScene);
	}

	class MyDrawingThread extends Thread {
		private SurfaceHolder mSurfaceHolder;
		private boolean mRun;

		private Drawable scene;

		MyDrawingThread(SurfaceHolder holder, Context context) {
			// get handles to some important objects
			mSurfaceHolder = holder;
		}

		/**
		 * Used to signal the thread whether it should be running or not.
		 * Passing true allows the thread to run; passing false will shut it
		 * down if it's already running. Calling start() after this was most
		 * recently called with false will result in an immediate shutdown.
		 * 
		 * @param b true to run, false to shut down
		 */
		public void setRunning(boolean b) {
			mRun = b;
		}

		@Override
		public void run() {
			while (mRun) {
				Canvas c = null;
				try {
					c = mSurfaceHolder.lockCanvas(null);
					synchronized (mSurfaceHolder) {
						doDraw(c);
					}
				} finally {
					// do this in a finally so that if an exception is thrown
					// during the above, we don't leave the Surface in an
					// inconsistent state
					if (c != null) {
						mSurfaceHolder.unlockCanvasAndPost(c);
					}
				}
			}
		}

		private void doDraw(Canvas canvas) {
			scene.draw(canvas);
		}

		public Drawable getScene() {
			return scene;
		}

		public void setScene(Drawable mScene) {
			this.scene = mScene;
		}
	}
}
