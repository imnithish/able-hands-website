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
import com.ablehands.supportservices.sections.*
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.silAccommodationFeatures
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun AccommodationContent() {

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
            Text("Property details")
        }

        VerticalSpacer(if (breakpoint < Breakpoint.MD) 16f else 32f)

        H1(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint < Breakpoint.MD) 16.px else 20.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.GrayVariant.rgb)
                .toAttrs()
        ) {
            Text("This home offers the perfect location for Supported Independent Living. Situated near Victoria Point Shopping Centre, Medicross Victoria Point, and local beaches, this spacious and comfortable home is designed to support your independence and lifestyle. Contact us today to learn more!")
        }

        VerticalSpacer(if (breakpoint < Breakpoint.MD) 32f else 42f)

        H1(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint < Breakpoint.MD) 24.px else 24.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Black.rgb)
                .toAttrs()
        ) {
            Text("Features")
        }

        VerticalSpacer(if (breakpoint < Breakpoint.MD) 16f else 32f)

        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 80.percent
                else 90.percent
            ),
            numColumns = numColumns(base = 2, md = 2),
        ) {
            silAccommodationFeatures.forEachIndexed { _, s ->
                P(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint < Breakpoint.MD) 16.px else 20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.GrayVariant.rgb)
                        .toAttrs()
                ) {
                    Text(s)
                }
            }
        }
    }
}