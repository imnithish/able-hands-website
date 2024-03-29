/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PText(text: String) {
    P(
        attrs = Modifier
            .fontFamily(Constants.FONT_FAMILY)
            .fontSize(18.px)
            .fillMaxWidth()
            .textAlign(TextAlign.Center)
            .fontWeight(FontWeight.SemiBold)
            .toAttrs()
    ) {
        Text(text)
    }
}