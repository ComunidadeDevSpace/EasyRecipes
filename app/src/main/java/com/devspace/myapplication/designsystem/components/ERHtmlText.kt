package com.devspace.myapplication.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.google.android.material.textview.MaterialTextView

@Composable
fun ERHtlmText(
    text: String,
    maxLine:Int? = null,
) {

    // parsing html string using the HtmlCompat class
    val spannedText = HtmlCompat.fromHtml(text, 0)

    // getting onSurface text color
    val textColor = MaterialTheme.colorScheme.onSurface.toArgb()

    // Using MaterialTextView to display HTML text
    AndroidView(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        factory = {
            MaterialTextView(it).apply {
                setTextColor(textColor)
                maxLine?.let {
                    maxLines = it
                }
            }
        },
        update = { it.text = spannedText }
    )

}