package foobar.canvastest.drawing.scenes;

import android.graphics.Canvas;
import android.graphics.Paint;
import foobar.canvastest.drawing.Drawable;

/**
 * An example of a scene you can draw. Although some android projects like to put
 * this code in the SurfaceView, for me it is convenient to put all the drawing 
 * code in its own class. It hides all that boilerplate code, and gives the added
 * bonus of being able to switch out the scene being drawn while reusing the same view.
 * 
 * To make your own scene, create a new class that implements Drawable. Then, call 
 * MySurfaceView.setScene(new YourSceneClass());
 * You can do this, for example, when a button is clicked, or when the surface is created
 * by MainCanvasActivity.
 */
public class ExampleScene implements Drawable {
	//A few "paint brushes" to draw with
	private Paint mPaint1 = new Paint();
	private Paint mPaintText = new Paint();
	private Paint mPaintBg = new Paint();

	public void draw(Canvas c) {
		//Save the basic matrix state. This is the state of all rotations, translations, scale operations, etc.
		c.save();

		c.drawColor(0xff000000);

		//Draw a blue background
		c.drawPaint(mPaintBg);

		c.drawText("Hello Drawing!", 20f, 100f, mPaintText);

		c.drawLine(100, 200, 200, 350, mPaint1);
		c.drawLine(100, 350, 200, 200, mPaint1);

		//Restore the basic matrix state.
		c.restore();
	}

	public ExampleScene() {
		//Initialize paint styles
		mPaintText.setColor(0xffffffff);
		mPaintText.setAntiAlias(true);
		mPaintText.setStrokeWidth(1);
		mPaintText.setStrokeCap(Paint.Cap.ROUND);
		mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaintText.setTextAlign(Paint.Align.LEFT);
		mPaintText.setTextSize(50);

		mPaint1.setColor(0xbb33bbff);
		mPaint1.setAntiAlias(true);
		mPaint1.setStrokeWidth(10);
		mPaint1.setStrokeCap(Paint.Cap.ROUND);
		mPaint1.setStyle(Paint.Style.FILL_AND_STROKE);

		mPaintBg.setColor(0x990099ff);
	}
}
