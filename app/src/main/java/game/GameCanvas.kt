package game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import game.model.Player

@Composable
fun GameCanvas(
    player: Player?,
    modifier: Modifier = Modifier,
    onCanvasSizeChanged: (Float, Float) -> Unit
) {
    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        // Dibuja el fondo blanco del área del juego.
        drawRect(
            color = Color.White,
            size = size
        )

        // Informa el ancho y el alto disponibles del Canvas.
        onCanvasSizeChanged(size.width, size.height)

        // Dibuja la nave solamente si el jugador existe.
        player?.let {
            val shipWidth = 60f
            val shipHeight = 40f

            // Construye la forma triangular de la nave.
            val shipPath = Path().apply {
                moveTo(
                    x = it.x + shipWidth / 2f,
                    y = it.y
                )

                lineTo(
                    x = it.x + shipWidth,
                    y = it.y + shipHeight
                )

                lineTo(
                    x = it.x,
                    y = it.y + shipHeight
                )

                close()
            }

            // Dibuja la nave de color azul.
            drawPath(
                path = shipPath,
                color = Color.Blue
            )
        }
    }
}