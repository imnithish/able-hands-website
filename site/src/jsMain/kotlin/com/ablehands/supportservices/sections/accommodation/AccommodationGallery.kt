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
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content.silAccommodationImages
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun AccommodationGallery() {

    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.fillMaxWidth().padding(leftRight = if (breakpoint < Breakpoint.MD) 32.px else 128.px)
    ) {
        H1(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint < Breakpoint.MD) 24.px else 24.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Black.rgb)
                .toAttrs()
        ) {
            Text("Gallery")
        }

        VerticalSpacer(if (breakpoint < Breakpoint.MD) 16f else 32f)

        Div(
            Modifier.styleModifier {
                display(DisplayStyle.Grid) // Set the container to use a grid layout
                gridTemplateColumns("repeat(auto-fit, minmax(350px, 1fr))") // Responsive column sizes
                gap(32.px) // Gap between grid items
            }.align(Alignment.CenterHorizontally).toAttrs()
        ) {
            silAccommodationImages.forEach { imageUrl ->
                Img(
                    src = imageUrl,
                    attrs = {
                        style {
                            width(100.percent)
                            borderRadius(8.px) // Optional: rounded corners
                            property("box-shadow", "0 2px 4px rgba(0, 0, 0, 0.05)") // Optional: shadow
                        }
                    }
                )
            }
        }
    }



}