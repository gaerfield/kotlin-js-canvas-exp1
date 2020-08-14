import de.kramhal.js.handson.Color
import kotlinx.html.dom.append
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.js.canvas
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val width = 1000
    val height = 1000
    document.getElementById("app")
            ?.also { it.innerHTML = "" }
            ?.append {
                h1 { +"Hallo Welt" }
                canvas {
                    id = "canvas"
                    this.width = "$width"
                    this.height = "$height"
                }
            }
    val canvas = document.getElementById("canvas") as HTMLCanvasElement
    canvas.draw { ColorGradientRenderer(width, height).plot(it) }
}


fun HTMLCanvasElement.draw(
        renderingFunction: (Image) -> Unit
) {
    val ctx = getContext("2d") as CanvasRenderingContext2D
    ctx.clearRect(0.0, 0.0, ctx.canvas.width.toDouble(), ctx.canvas.height.toDouble())

    val imageData = ctx.createImageData(
            ctx.canvas.width.toDouble(),
            ctx.canvas.height.toDouble())

    val image = object : Image {
        override val height: Int
            get() = ctx.canvas.height
        override val width: Int
            get() = ctx.canvas.width

        override fun draw(x: Int, y: Int, color: Color) {
            if( x > height || y > height )
                return
            val base = 4 * (x + imageData.width * y)
            val image : dynamic = imageData.data
            image[base + 0] = color.r
            image[base + 1] = color.g
            image[base + 2] = color.b
            image[base + 3] = 255
        }
    }

    renderingFunction(image)
    ctx.putImageData(imageData, 0.0, 0.0)
}