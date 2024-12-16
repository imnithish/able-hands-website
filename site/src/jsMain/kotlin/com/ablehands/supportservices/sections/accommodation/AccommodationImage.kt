/*
 * Created by Nitheesh AG on 16, 12, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections.accommodation

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun AccommodationImage() {

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (breakpoint < Breakpoint.MD) Alignment.BottomStart else Alignment.CenterStart
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .objectFit(ObjectFit.Cover),
            src = if (breakpoint < Breakpoint.MD) Res.Image.accommodationmobile else
                Res.Image.accommodationmain,
        )

        Column(
            modifier = Modifier
                .margin(
                    bottom = if (breakpoint < Breakpoint.MD) 36.px else 14.px,
                    left = if (breakpoint < Breakpoint.MD) 18.px else 128.px
                ),
        ) {
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 18.px else 24.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("SIL ACCOMMODATION")
            }
            VerticalSpacer(24f)
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 44.px else 54.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("Brisbane Bayside")
            }
        }
    }
}