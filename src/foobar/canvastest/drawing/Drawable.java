package foobar.canvastest.drawing;

import android.graphics.Canvas;

/**
 * An interface for things that can be drawn on a canvas.
 * An implementation might be as simple as a shape or text field,
 * or may be a large complex scene possibly filled with other 
 * Drawable objects.
 * 
 * This is a pattern I found useful in OpenGL drawing and may also
 * be helpful in a 2D canvas context.
 */
public interface Drawable {
	public void draw(Canvas canvas);
}
