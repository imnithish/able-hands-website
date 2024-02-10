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
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.socialActivitiesAndCommunityAccess
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
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun SupportInSocialActivitiesSection2() {
    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        Content.servicesExpanded[3]
    }
    Box(
        modifier = Modifier
            .id(serviceSection.first)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.CenterStart
    ) {
        SupportInSocialActivitiesContent2(serviceSection, breakpoint)
    }
}

@Composable
fun SupportInSocialActivitiesContent2(
    serviceSection: Pair<String, String>,
    breakpoint: Breakpoint
) {
    if (breakpoint < Breakpoint.MD) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    leftRight = 20.px,
                    top = 29.px
                ),
        ) {
            Column(
                modifier = Modifier.background(Theme.AboutSecondaryLight.rgb)
                    .padding(bottom = 37.px)
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        src = Res.Image.image_9,
                        width = 292,
                        height = 231
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().padding(leftRight = 18.px, top = 31.px)
                ) {
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(24.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Black.rgb)
                            .toAttrs()
                    ) {
                        Text(serviceSection.second)
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
                        Text("To connect with your community in your own way.")
                    }
                    VerticalSpacer(20f)

                    socialActivitiesAndCommunityAccess.forEachIndexed { i, it ->
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(14.px)
                                .fontWeight(FontWeight.Normal)
                                .color(Theme.Black.rgb)
                                .toAttrs()
                        ) {
                            Text(it)
                        }
                        if (i != socialActivitiesAndCommunityAccess.size - 1)
                            VerticalSpacer(24f)
                    }
                }

            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    leftRight = 64.px,
                    top = 59.px
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.background(Theme.AboutSecondaryLight.rgb)
                    .padding(bottom = 80.px)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(leftRight = 71.px, top = 64.px)
                ) {
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(40.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Black.rgb)
                            .toAttrs()
                    ) {
                        Text(serviceSection.second)
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
                        Text("To connect with your community in your own way.")
                    }
                    VerticalSpacer(51f)

                    socialActivitiesAndCommunityAccess.forEachIndexed { i, it ->
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(20.px)
                                .fontWeight(FontWeight.Normal)
                                .color(Theme.Black.rgb)
                                .toAttrs()
                        ) {
                            Text(it)
                        }
                        if (i != socialActivitiesAndCommunityAccess.size - 1)
                            VerticalSpacer(24f)
                    }
                }

                Image(
                    src = Res.Image.image_9,
                    width = 630,
                    height = 497
                )
            }
        }
    }

}