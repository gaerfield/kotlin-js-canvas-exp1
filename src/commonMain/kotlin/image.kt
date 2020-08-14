import de.kramhal.js.handson.Color
import de.kramhal.js.handson.Colors
import de.kramhal.js.handson.newColor
import kotlin.math.roundToInt
import kotlin.math.sqrt

interface Image {
    val height: Int
    val width: Int
    fun draw(x: Int, y: Int, color: Color)
}

open class Renderer(val drawLogic: (Int, Int) -> Color) {
    fun plot(image: Image) {
        (0 .. image.width).forEach {x ->
            (0 .. image.height).forEach { y ->
                image.draw(x, y, drawLogic(x,y))
            }
        }
    }
}

class ColorGradientRenderer(val maxX: Int, val maxY: Int) : Renderer({ x,y ->
    val _x = x.toDouble()
    val _y = y.toDouble()
    val r = ((_x/maxX)*255).roundToInt()
    val g = ((_y/maxY)*255).roundToInt()
    val b = sqrt(_x*_x + _y*_y).roundToInt()
    Colors.newColor(r,g,b)
})