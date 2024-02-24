package com.orimous.weather.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orimous.weather.components.IconButtonComponent
import com.orimous.weather.components.IconComponent
import com.orimous.weather.components.PointsGroupComponent
import com.orimous.weather.components.TextCenterComponent
import com.orimous.weather.components.TextDefaultComponent

@Composable
fun HomeScreen(
    date: String,
    city: String,
    onClick: () -> Unit,
    tempC: String,
    maxTempC: String,
    minTempC: String,
    feelsLikeC: String,
    weatherIcon: ImageVector = Icons.Default.Report
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp, 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtonComponent(
                onClick = { onClick },
                imageValue = Icons.Default.Refresh
            )
            TextCenterComponent(text = date)
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                TextDefaultComponent(
                    text = "\u2103",
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                TextDefaultComponent(text = city)
                Spacer(modifier = Modifier.height(10.dp))
                PointsGroupComponent()
                TextDefaultComponent(
                    text = tempC,
                    typographyStyle = MaterialTheme.typography.displayLarge
                )
            }
            IconComponent(
                imageValue = weatherIcon,
                modifier = Modifier.size(170.dp)
            )
        }
        TextDefaultComponent(
            text = "Ощущается как: $feelsLikeC",
            typographyStyle = MaterialTheme.typography.titleMedium
        )
        Divider(
            modifier = Modifier.padding(0.dp, 10.dp ),
            thickness = 1.5.dp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconComponent(
                imageValue = Icons.Rounded.KeyboardArrowUp,
                modifier = Modifier.size(35.dp)
            )
            TextDefaultComponent(text = "$maxTempC \u2103")
            Spacer(modifier = Modifier.width(8.dp))
            IconComponent(
                imageValue = Icons.Rounded.KeyboardArrowDown,
                modifier = Modifier.size(35.dp)
            )
            TextDefaultComponent(text = "$minTempC \u2103")
        }
        TextDefaultComponent(
            text = "Сила ветра: км/ч",
            typographyStyle = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        HomeScreen(
            date = "Mon, 25 may",
            city = "London",
            onClick = { /*TODO*/ },
            tempC = "-15",
            maxTempC = "-10",
            minTempC = "-20",
            feelsLikeC = "-20"
        )
    }
}