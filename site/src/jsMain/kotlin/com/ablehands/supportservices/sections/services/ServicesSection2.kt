/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content.silPoints
import com.ablehands.supportservices.util.Res.Image.image_6
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenUnless
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServicesSection2() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Services.id)
            .fillMaxWidth()
            .then(
                if (breakpoint > Breakpoint.MD)
                    Modifier.padding(top = 91.px, bottom = 108.px)
                else
                    Modifier.padding(top = 34.px, bottom = 54.px)
            )
            .background(Theme.Primary.rgb)
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ServicesSection2Content(breakpoint)
        }
    }
}

@Composable
fun ServicesSection2Content(breakpoint: Breakpoint) {
    val mainImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(324, 274) else Pair(692, 586)
    }

    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2)
    ) {
        Image(
            src = image_6,
            width = mainImageSize.first,
            height = mainImageSize.second
        )
        Column(
            modifier = Modifier.then(
                if (breakpoint < Breakpoint.MD)
                    Modifier.margin(top = 34.px, left = 20.px, right = 20.px)
                else Modifier.padding(leftRight = 54.px)
            )
        ) {
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 24.px else 40.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("Our Services")
            }
            if (breakpoint < Breakpoint.MD)
                VerticalSpacer(12f)
            else
                VerticalSpacer(10f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 16.px else 24.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("Supported Independent Living (SIL)")
            }

            if (breakpoint < Breakpoint.MD)
                VerticalSpacer(8f)
            else
                VerticalSpacer(10f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(if (breakpoint < Breakpoint.MD) 16.px else 24.px)
                    .fontWeight(FontWeight.Medium)
                    .fontStyle(FontStyle.Italic)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("Respectful support for your daily life.")
            }
            VerticalSpacer(24f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 14.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("We provide support and care in SIL that helps you with daily life in your own house or supported house. We can help you with personal care activities like showering and dressing, help with cooking meals, shopping for groceries, medication management and administration, keeping your home safe and tidy or helping to get to and from appointments.")
            }

            if (breakpoint < Breakpoint.MD)
                VerticalSpacer(12f)
            else
                VerticalSpacer(22f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 14.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Color.white)
                    .toAttrs()
            ) {
                Text("AHSS provides participants with higher support needs, such as overnight support, 24/7 care, person-to-person work provided by a support worker, or significant help throughout the day. We provide help and supervision of day-to-day tasks to develop the skills of an individual so they can live as independently as possible. These are supports provided to an NDIS participant in their home and can be in a shared or individual living arrangement.")
            }
        }
    }


    val silPointsIconSize: Int = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            24 else 64
    }

    SimpleGrid(
        modifier = Modifier.thenIf(
            breakpoint < Breakpoint.MD
        ) { Modifier.padding(left = 20.px, right = 20.px, top = 39.px, bottom = 0.px) }
            .thenUnless(breakpoint < Breakpoint.MD) {
                Modifier.padding(left = 89.px, right = 111.px, top = 76.px, bottom = 0.px)
            },
        numColumns = numColumns(base = 2, md = 3)
    ) {
        silPoints.forEachIndexed { i, it ->
            Column(
                modifier = Modifier.thenIf(breakpoint < Breakpoint.MD) {
                    if (i in 0..3)
                        Modifier.margin(bottom = 32.px) else Modifier
                    if (i == 0 || i == 2 || i == 4)
                        Modifier.margin(right = 20.px) else Modifier
                }.thenUnless(
                    breakpoint < Breakpoint.MD
                ) {
                    if (i in 0..2)
                        Modifier.margin(bottom = 42.px) else Modifier
                }.thenUnless(breakpoint < Breakpoint.MD) {
                    if (i == 0 || i == 1 || i == 3 || i == 4)
                        Modifier.margin(right = 170.px) else Modifier
                }
            ) {
                Image(
                    src = it.first,
                    width = silPointsIconSize,
                    height = silPointsIconSize
                )
                VerticalSpacer(16f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint < Breakpoint.MD) 14.px else 20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Color.white)
                        .toAttrs()
                ) {
                    Text(it.second)
                }
            }
        }
    }

}
