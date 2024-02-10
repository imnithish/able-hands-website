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
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun CommunityNursingSection() {
    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        Content.servicesExpanded[5]
    }
    Box(
        modifier = Modifier
            .id(serviceSection.first)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommunityNursingContent(serviceSection)
        }
    }
}

@Composable
fun CommunityNursingContent(serviceSection: Pair<String, String>) {
    Column(
        modifier = Modifier
            .margin(top = 4.px)
            .fillMaxWidth(85.percent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().borderRadius(8.px)
                .padding(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Column {
                SectionTitle(section = serviceSection.second)
                VerticalSpacer(8f)

                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Professional community nursing in your own home.")
                }
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY2)
                        .fontSize(26.px)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Our nursing services are offered by experienced registered nurses \uD83D\uDC69\u200D⚕\uFE0F")
                }
                VerticalSpacer(8f)


                Content.nursing.forEach {
                    P(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(16.px)
                            .fontWeight(FontWeight.Medium)
                            .color(Theme.Base.rgb)
                            .toAttrs()
                    ) {
                        Text(it)
                    }
                }
            }

            Image(
                modifier = Modifier.borderRadius(8.px).weight(1f).margin(left = 60.px),
                src = Res.Image.image11,
                width = 512,
                height = 341
            )
        }

        H1(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(17.px)
                .margin(left = 12.px)
                .fontWeight(FontWeight.SemiBold)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("Various nursing assessments and planning which includes:")
        }
        VerticalSpacer(16f)


        SimpleGrid(
            modifier = Modifier.fillMaxWidth()
                .margin(left = 12.px),
            numColumns = numColumns(base = 1, md = 2),
        ) {
            Content.nursingPoints.forEach {

                P(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(15.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(it)
                }

            }
        }


        H1(
            attrs = Modifier
                .margin(top = 16.px, leftRight = 32.px)
                .textAlign(TextAlign.Center)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Medium)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("If you have been involved in an accident, suffered an injury or have been in hospital for an illness, you may need some support at home for a period of time whilst you get back on your fee.")
        }

        H1(
            attrs = Modifier
                .margin(top = 16.px, leftRight = 32.px)
                .textAlign(TextAlign.Center)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Medium)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("We work with a number of healthcare providers to support their clients or patients to get back on the road to recovery as quickly as possible.")
        }

        H1(
            attrs = Modifier
                .margin(top = 12.px, leftRight = 32.px)
                .textAlign(TextAlign.Center)
                .fontFamily(Constants.FONT_FAMILY2)
                .fontSize(32.px)
                .fillMaxWidth()
                .fontWeight(FontWeight.Black)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text("Our support services are tailored to you.")
        }

        H1(
            attrs = Modifier
                .margin(top = 16.px, leftRight = 32.px)
                .textAlign(TextAlign.Center)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Medium)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("If you need help transitioning from the hospital to your home, you may need to access our short-term support services. From help with cleaning your home to attending appointments, we can support you.")
        }
    }
}