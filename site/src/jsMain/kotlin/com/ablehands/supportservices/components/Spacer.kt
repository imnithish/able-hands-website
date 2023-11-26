package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import org.jetbrains.compose.web.css.px


@Composable
fun VerticalSpacer(height: Float) {
    Box(
        modifier = Modifier.height(height.px)
    )
}