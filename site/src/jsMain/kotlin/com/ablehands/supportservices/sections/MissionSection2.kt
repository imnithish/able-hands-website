/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content.aboutSub
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MissionSection2() {

    val breakpoint = rememberBreakpoint()

    val subImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(241, 167) else Pair(896, 435)
    }

    val iconImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(85, 80) else Pair(139, 131)
    }

    val contentSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 14.px else 20.px
    }

    val titleSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 24.px else 40.px
    }

    Box(
        modifier = Modifier
            .id(Section.Mission.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize().then(
                if (breakpoint < Breakpoint.MD)
                    Modifier.padding(bottom = 32.px)
                else
                    Modifier.padding(bottom = 85f.px)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Theme.AboutSecondaryLight.rgb)
            ) {
                Image(
                    src =if (breakpoint<Breakpoint.MD) Res.Image.image_5_small else Res.Image.image_5,
                    width = subImageSize.first,
                    height = subImageSize.second
                )

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Image(
                        src = Res.Image.logoT,
                        width = iconImageSize.first,
                        height = iconImageSize.second
                    )
                }
            }

            VerticalSpacer(if (breakpoint < Breakpoint.MD) 32f else 85f)

            SimpleGrid(
                modifier = Modifier.then(
                    if (breakpoint < Breakpoint.MD) Modifier.padding(leftRight = 20.px) else Modifier.padding(
                        leftRight = 67.px
                    )
                ),
                numColumns = numColumns(base = 1, md = 3)
            ) {
                aboutSub.forEachIndexed { i, it ->
                    Column(
                        modifier = Modifier.thenUnless(
                            breakpoint < Breakpoint.MD
                        ) {
                            if (i == 0 || i == 1)
                                Modifier.padding(right = 66.px)
                            else Modifier
                        }.thenIf(
                            breakpoint < Breakpoint.MD
                        ) {
                            if (i == 1 || i == 2)
                                Modifier.padding(top = 24.px)
                            else Modifier
                        },
                    ) {
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(titleSizes)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text(
                                it.heading
                            )
                        }

                        VerticalSpacer(if (breakpoint<Breakpoint.MD) 4f else 16f)

                        it.points.forEach {
                            P(
                                attrs = Modifier
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(contentSizes)
                                    .fontWeight(FontWeight.Normal)
                                    .color(Theme.Base.rgb)
                                    .toAttrs()
                            ) {
                                Text(
                                    it
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}