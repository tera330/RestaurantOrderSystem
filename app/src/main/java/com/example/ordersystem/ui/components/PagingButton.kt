import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PagingButton(
    modifier: Modifier,
    isNext: Boolean,
    text: String,
    onClick: () -> Unit,
) {
    val buttonShape: CutCornerShape
    val buttonContentPadding: PaddingValues

    if (isNext) {
        buttonShape = CutCornerShape(topEnd = 45.dp, bottomEnd = 45.dp)
        buttonContentPadding = PaddingValues(start = 10.dp, end = 40.dp)
    } else {
        buttonShape = CutCornerShape(topStart = 45.dp, bottomStart = 45.dp) // 例として反対側を切り取る
        buttonContentPadding = PaddingValues(start = 40.dp, end = 10.dp)
    }

    Button(
        onClick = { onClick() },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            ),
        shape = buttonShape,
        contentPadding = buttonContentPadding,
        modifier = Modifier,
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                fontSize = 50.sp,
                fontFamily = FontFamily.Serif,
            )
        }
    }
}

@Preview
@Composable
fun PreviewPagingButton() {
    PagingButton(
        modifier = Modifier,
        isNext = true,
        text = "前へ",
        onClick = {},
    )
}
