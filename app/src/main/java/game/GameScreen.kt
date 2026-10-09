package game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import game.model.Player

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
) {
    // Guarda al jugador; inicialmente todavía no existe.
    var player by remember {
        mutableStateOf<Player?>(null)
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        GameCanvas(
            player = player,
            onCanvasSizeChanged = { width, height ->

                // Crea al jugador solo cuando todavía no existe.
                if (player == null) {
                    val shipWidth = 60f
                    val shipHeight = 50f

                    // Coloca la nave en el centro del Canvas.
                    player = Player(
                        x = (width - shipWidth) / 2f,
                        y = (height - shipHeight) / 2f
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        // Muestra el título en la parte superior de la pantalla.
        Text(
            text = "Space Shooter",
            modifier = Modifier.align(Alignment.TopCenter),
            color = Color.White
        )
    }
}