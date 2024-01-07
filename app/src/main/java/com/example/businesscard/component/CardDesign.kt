package com.example.businesscard.component

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardDesign(modifier: Modifier = Modifier) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width = 350.dp, height = 212.dp),
    ) {
        Column {
            // 会社名を表示します。
            Text(text = "株式会社〇〇")
            // 名前を表示します。
            Text(text = "山田 太郎")
            // 肩書きを表示します。
            Text(text = "システムエンジニア")
            // 連絡先情報を表示します。
            Column {
                // 電話番号を表示します。
                Text(text = "090-1234-5678")
                // メールアドレスを表示します。
                Text(text = "taro.yamada@example.com")
            }
        }
    }
}