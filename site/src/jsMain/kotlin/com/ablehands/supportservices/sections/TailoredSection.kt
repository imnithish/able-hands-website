/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Res
import com.ablehands.supportservices.util.Res.Image.image_3_icon
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TailoredSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth()
                then (
                if (breakpoint < Breakpoint.MD)
                    Modifier.margin(top = 24.px)
                else
                    Modifier.margin(top = 64.px)
                )
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth() then (
                    if (breakpoint < Breakpoint.MD)
                        Modifier.padding(top = 55.px, left = 22.px, right = 22.px, bottom = 55.px)
                    else
                        Modifier.padding(
                            top = 64.px,
                            left = 108.px,
                            right = 108.px,
                            bottom = 100.px
                        )
                    ).background(Theme.Primary.rgb),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint < Breakpoint.MD) 24.px else 40.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Color.white)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                Text(
                    "Our support services are \n" +
                            "tailored to you."
                )
            }

            VerticalSpacer(if (breakpoint < Breakpoint.MD) 40f else 70f)

            SimpleGrid(
                modifier = Modifier.fillMaxWidth()
                    .margin(left = 12.px),
                numColumns = numColumns(base = 1, md = 3),
            ) {
                Content.tailoredPoints.forEachIndexed { i, it ->

                    Column(
                        modifier = Modifier.thenIf(
                            i != Content.tailoredPoints.size
                        ) { Modifier.margin(right = 32.px) },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .margin(bottom = if (breakpoint < Breakpoint.MD) 12.px else 15.px),
                            width = 46,
                            height = 48,
                            src = image_3_icon,
                        )
                        P(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(
                                    if (breakpoint < Breakpoint.MD) 14.px else 20.px
                                )
                                .thenIf(breakpoint<Breakpoint.MD){
                                    Modifier.margin(bottom = 32.px)
                                }
                                .fontWeight(FontWeight.Normal)
                                .color(Color.white)
                                .toAttrs()
                        ) {
                            Text(it)
                        }
                    }

                }
            }
        }
    }
}