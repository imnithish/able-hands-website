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
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.homeSupportServices
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
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
fun DailyPersonalCareSection2() {

    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        Content.servicesExpanded[1]
    }

    Box(
        modifier = Modifier
            .id(serviceSection.first)
            .fillMaxWidth()
            .padding(bottom = if (breakpoint < Breakpoint.MD) 117.px else 53.px)
            .background(Theme.Bg.rgb)
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DailyPersonalCareSection2Content(serviceSection.second, breakpoint)
        }
    }
}

@Composable
fun DailyPersonalCareSection2Content(title: String, breakpoint: Breakpoint) {
    if (breakpoint < Breakpoint.MD) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                src = Res.Image.image_7,
                width = 327,
                height = 235
            )
        }
        VerticalSpacer(36f)
        Column(modifier = Modifier.padding(left = 20.px)) {
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Black.rgb)
                    .toAttrs()
            ) {
                Text(title)
            }
            VerticalSpacer(16f)
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Black.rgb)
                    .fontStyle(FontStyle.Italic)
                    .toAttrs()
            ) {
                Text("Respectful support for your daily life.")
            }
            VerticalSpacer(24f)
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Black.rgb)
                    .toAttrs()
            ) {
                Text("Able Hands Support Services provides home-based care services for people who live with disabilities. We take pride in delivering you a choice of services and support to suit your needs and goals. Our dedicated, experienced, friendly staff will assist you with all aspects of daily living, personal care and home tasks.")
            }
            VerticalSpacer(49f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Black.rgb)
                    .toAttrs()
            ) {
                Text("Home support services")
            }
            VerticalSpacer(16f)
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Black.rgb)
                    .fontStyle(FontStyle.Italic)
                    .toAttrs()
            ) {
                Text("Assistance with day-to-day activities at home.")
            }
            VerticalSpacer(22f)

        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth().padding(
                left = 89.px
            ), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(right = 89.px)
            ) {
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(40.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Black.rgb)
                        .toAttrs()
                ) {
                    Text(title)
                }
                VerticalSpacer(16f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY2)
                        .fontSize(24.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Black.rgb)
                        .fontStyle(FontStyle.Italic)
                        .toAttrs()
                ) {
                    Text("Respectful support for your daily life.")
                }
                VerticalSpacer(24f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Black.rgb)
                        .toAttrs()
                ) {
                    Text("Able Hands Support Services provides home-based care services for people who live with disabilities. We take pride in delivering you a choice of services and support to suit your needs and goals. Our dedicated, experienced, friendly staff will assist you with all aspects of daily living, personal care and home tasks.")
                }
            }

            Image(
                src = Res.Image.image_7,
                width = 689,
                height = 495
            )
        }
        VerticalSpacer(89f)
        Column(
            modifier = Modifier.fillMaxWidth().padding(left = 89.px)
        ) {
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(40.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Black.rgb)
                    .toAttrs()
            ) {
                Text("Home support services")
            }
            VerticalSpacer(16f)
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Black.rgb)
                    .fontStyle(FontStyle.Italic)
                    .toAttrs()
            ) {
                Text("Assistance with day-to-day activities at home.")
            }
        }
        VerticalSpacer(26f)
    }

    SimpleGrid(
        modifier = Modifier.fillMaxWidth().thenIf(
            breakpoint < Breakpoint.MD
        ) { Modifier.padding(left = 20.px, right = 20.px) }
            .thenUnless(breakpoint < Breakpoint.MD) {
                Modifier.padding(left = 89.px, right = 89.px)
            },
        numColumns = numColumns(base = 1, md = 2)
    ) {
        homeSupportServices.forEachIndexed { i, it ->
            val broken = it.split("+")
            Column(
                modifier = Modifier
                    .width(if (breakpoint < Breakpoint.MD) 320.px else 519.px)
                    .thenIf(
                        breakpoint < Breakpoint.MD && i != homeSupportServices.size - 1
                    ) {
                        Modifier.margin(
                            bottom = 28.px
                        )
                    }.then(
                        if (breakpoint > Breakpoint.MD) {
                            Modifier.margin(
                                bottom = 32.px,
                            )
                        } else Modifier
                    )
            ) {
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint < Breakpoint.MD) 20.px else 24.px)
                        .fontWeight(FontWeight.SemiBold)
                        .color(Theme.Black.rgb)
                        .toAttrs()
                ) {
                    Text(broken[0])
                }
                VerticalSpacer(4f)

                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint < Breakpoint.MD) 20.px else 16.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Black.rgb)
                        .toAttrs()
                ) {
                    Text(broken[1])
                }
            }
        }
    }


}

