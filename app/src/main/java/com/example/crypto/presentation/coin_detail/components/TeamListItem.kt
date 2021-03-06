package com.example.crypto.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.crypto.data.remote.dto.CoinDetailDto

@Composable
fun TeamListItem(
    team: CoinDetailDto.TeamMember,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center
        ) {
        Text(text = team.name ?: "", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = team.position ?: "", style = MaterialTheme.typography.body2, fontStyle = FontStyle.Italic)
    }
}