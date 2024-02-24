package com.orimous.weather.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.orimous.weather.R

@SuppressLint("ResourceAsColor")
@Composable
fun IconButtonComponent(
    onClick: () -> Unit,
    imageValue: ImageVector
) {
    IconButton(
        onClick = { onClick },
        colors = IconButtonDefaults.filledIconButtonColors(colorResource(R.color.primary))
    ) {
        IconComponent(
            imageValue = imageValue,
            colorValue = Color.White
        )
    }
}

@Composable
fun IconComponent(
    modifier: Modifier = Modifier,
    imageValue: ImageVector,
    colorValue: Color = MaterialTheme.colorScheme.primary
) {
    Icon(
        imageVector = imageValue,
        contentDescription = null,
        modifier = modifier,
        tint = colorValue
    )
}

@Composable
fun TextCenterComponent(
    text: String
) {
    Text(
        text = text,
        color = colorResource(R.color.primary),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun TextDefaultComponent(
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    typographyStyle: TextStyle = MaterialTheme.typography.headlineSmall
) {
    Text(
        text = text,
        color = colorResource(R.color.primary),
        fontWeight = fontWeight,
        style = typographyStyle
    )
}

@Composable
fun PointsGroupComponent() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconComponent(
            imageValue = Icons.Filled.RadioButtonChecked,
            modifier = Modifier.size(8.dp)
        )
        IconComponent(
            imageValue = Icons.Filled.RadioButtonUnchecked,
            modifier = Modifier.size(8.dp)
        )
        IconComponent(
            imageValue = Icons.Filled.RadioButtonUnchecked,
            modifier = Modifier.size(8.dp)
        )
        IconComponent(
            imageValue = Icons.Filled.RadioButtonUnchecked,
            modifier = Modifier.size(8.dp)
        )
    }
}