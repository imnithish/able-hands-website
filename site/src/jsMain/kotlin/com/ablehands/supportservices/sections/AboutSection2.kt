/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.*
import com.ablehands.supportservices.components.ReadMoreButton
import com.ablehands.supportservices.components.SectionTitle2
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection2() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth()
            .background(Theme.Bg.rgb)
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize().then(
                if (breakpoint < Breakpoint.MD)
                    Modifier.padding(top = 42.px, bottom = 39.px)
                else
                    Modifier.padding(top = 109.px, bottom = 103.px)
            ),
        ) {
            AboutSection2Content(breakpoint)
        }
    }
}

@Composable
fun AboutSection2Content(breakpoint: Breakpoint) {

    var expanded by remember { mutableStateOf(false) }

    val titleSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 24.px else 40.px
    }

    val contentSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 14.px else 20.px
    }

    val mainImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(320, 239) else Pair(640, 467)
    }

    SimpleGrid(
        modifier = Modifier.then(
            if (breakpoint < Breakpoint.MD) Modifier.padding(left = 20.px) else Modifier.padding(
                left = 89.px
            )
        ),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        Column(modifier = Modifier.thenIf(breakpoint < Breakpoint.MD) {
            Modifier.padding(
                bottom = 29.px
            )
        })
        {
            SectionTitle2(title = Section.About.titleVariant, fontSize = titleSizes)
            Column(
                modifier = Modifier.fillMaxWidth().then(
                    if (breakpoint < Breakpoint.MD) Modifier.padding(right = 20.px) else Modifier.padding(
                        right = 89.px
                    )
                ),
            ) {
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(contentSizes)
                        .margin(top = 24.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Caption.rgb)
                        .textAlign(TextAlign.Justify)
                        .toAttrs()
                ) {
                    Text(
                        "Able Hands Support Services is a registered NDIS provider with a team of dedicated registered nurses and experienced disability support workers based in Queensland, Australia.\n" +
                                "We provide a range of disability and aged care services across Brisbane and surrounding regions. AHS aims to empower our participants to live happily and independently by providing a range of capacity and skill-building programs and individual supports that are bespoke to meet the unique needs of our participants."
                    )
                }

                if (expanded)
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(contentSizes)
                            .margin(top = if (breakpoint < Breakpoint.MD) 14.px else 24.px)
                            .fontWeight(FontWeight.Normal)
                            .textAlign(TextAlign.Justify)
                            .color(Theme.Caption.rgb)
                            .toAttrs()
                    ) {
                        Text(
                            "Our approach is centred around understanding and meeting the unique needs of each person we support. We believe in the power of person-centred care and work closely with our participants to develop personalised support plans that address their specific goals and aspirations.\n" +
                                    "\n" +
                                    "Our friendly, professional staff listen to your concerns, collaborate, and plan programs and services that foster growth, skill building and overall well-being."
                        )
                    }

                ReadMoreButton(
                    modifier = Modifier.margin(top = if (breakpoint < Breakpoint.MD) 16.px else 60.px),
                    expanded = expanded,
                    textSize = if (breakpoint < Breakpoint.MD) 16.px else 24.px,
                    onClick = {
                        expanded = !expanded
                    })
            }

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Box { }
            AboutUsImage(mainImageSize)
        }

    }

}

@Composable
fun AboutUsImage(mainImageSize: Pair<Int, Int>) {
    Image(
        modifier = Modifier.objectFit(ObjectFit.Cover),
        src = Res.Image.image_4,
        width = mainImageSize.first,
        height = mainImageSize.second
    )
}