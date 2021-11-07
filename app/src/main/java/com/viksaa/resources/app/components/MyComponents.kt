package com.viksaa.resources.app.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viksaa.resources.app.R

@Preview
@Composable
fun UserCard(msg: User = User("Student", "Nafinki")) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .border(width = 1.dp, color = MaterialTheme.colors.error)
            .padding(
                dimensionResource(R.dimen.padding_card)
            )
    ) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondary
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.body,
                color = MaterialTheme.colors.primary
            )
        }
    }
}