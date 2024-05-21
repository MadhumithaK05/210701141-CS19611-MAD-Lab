package org.rajalakshmi.graphicalprimitives
import android.content.Context import android.graphics.Canvas import android.graphics.Color import android.graphics.Paint import android.util.AttributeSet import android.view.View
class SampleCanvas @JvmOverloads constructor(
context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) { override fun onDraw(canvas: Canvas?) {
super.onDraw(canvas)
val paint : Paint = Paint() paint.setColor(Color.YELLOW) canvas?.drawPaint(paint)
paint.setTextSize(50f); paint.setColor(Color.RED); canvas?.drawText("Circle", 120f, 150f, paint); canvas?.drawCircle(200f, 350f, 150f, paint); paint.setColor(Color.GREEN); canvas?.drawText("Rectangle", 420f, 150f, paint); canvas?.drawRect(400f, 200f, 650f, 700f, paint); paint.setColor(Color.BLUE); canvas?.drawText("Square", 120f, 800f, paint); canvas?.drawRect(50f, 850f, 350f, 1150f, paint); paint.setColor(Color.BLACK); canvas?.drawText("Line", 480f, 800f, paint); canvas?.drawLine(520f, 850f, 520f, 1150f, paint);
} }
