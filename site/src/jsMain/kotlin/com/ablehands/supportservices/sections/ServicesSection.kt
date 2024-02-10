/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.PText
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.dailyPerCareAndDomTasksDes
import com.ablehands.supportservices.util.Content.homeSupportServices
import com.ablehands.supportservices.util.Content.nursing
import com.ablehands.supportservices.util.Content.nursingPoints
import com.ablehands.supportservices.util.Content.silDes
import com.ablehands.supportservices.util.Content.socialActivitiesAndCommunityAccess
import com.ablehands.supportservices.util.Content.transportArrangements
import com.ablehands.supportservices.util.Res.Image.image11
import com.ablehands.supportservices.util.Res.Image.image24
import com.ablehands.supportservices.util.Res.Image.image4
import com.ablehands.supportservices.util.Res.Image.image5
import com.ablehands.supportservices.util.Res.Image.image8
import com.varabyte.kobweb.compose.css.FontWeight
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
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServicestSection2() {
    Box(
        modifier = Modifier
            .id(Section.Services.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        ServicesContent()
    }


}

@Composable
fun ServicesContent() {

    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = if (breakpoint <= Breakpoint.MD) 24.px else 112.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(
            section = Section.Services,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 32.px)
                .backgroundColor(Theme.LightBlue.rgb),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Supported Independent Living (SIL)")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("Helping you to meet your goals and maximize your independence.")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {
                ServiesImage(image5)
                ServiesText(breakpoint = breakpoint, silDes)
            }

            H1(
                attrs = Modifier
                    .margin(top = 24.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("We provide")
            }

            VerticalSpacer(16f)
            Content.silProvide.forEach {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = if (breakpoint >= Breakpoint.MD) Alignment.CenterHorizontally else Alignment.Start
                ) {
                    P(
                        attrs = Modifier
                            .textAlign(TextAlign.Start)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .margin(leftRight = 16.px)
                            .fontWeight(FontWeight.SemiBold)
                            .color(Theme.Base.rgb)
                            .toAttrs()
                    ) {
                        Text(it)
                    }
                }

            }

            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Daily personal care and domestic tasks")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("Respectful support for your daily life.")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {
                ServiesImage(image4)
                ServiesText(breakpoint = breakpoint, dailyPerCareAndDomTasksDes)
            }


            // home support services

            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Home Support services")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("Assistance with day-to-day activities at home.")
            }

            homeSupportServices.forEach {
                val broken = it.split("+")
                Row(Modifier.flexWrap(FlexWrap.Wrap).padding(leftRight = 32.px).margin(top = 16.px)) {

                    SpanText(
                        modifier = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Bold),
                        text = "${broken[0]}: "
                    )

                    SpanText(
                        modifier = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.SemiBold),
                        text = broken[1]
                    )

                }
            }

            // Support in social activities and community access
            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Support in social activities and community access")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("To connect with your community in your own way.")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {
                ServiesImage(image24)
                ServiesText(breakpoint = breakpoint, socialActivitiesAndCommunityAccess)
            }

            // Assistance with travel and transport arrangements
            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Assistance with travel and transport arrangements")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("We are here to help you. To maximize your independence and meet your goals.")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {
                ServiesImage(image8)
                ServiesText(breakpoint = breakpoint, transportArrangements)
            }


            // Community Nursing care
            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))

            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Community Nursing care")
            }

            H1(
                attrs = Modifier
                    .margin(top = 16.px, leftRight = 32.px)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(28.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("Professional community nursing in your own home.")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {
                ServiesImage(image11)
                ServiesText(breakpoint = breakpoint, nursing)
            }

            VerticalSpacer(32f)

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(20.px)
                    .margin(leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Our nursing services are offered by experienced Registered Nurses")
            }

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .margin(leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("Various nursing assessments and planning which includes:")
            }

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ).margin(top = 32.px),
                numColumns = numColumns(base = 1, md = 2),
            ) {

                nursingPoints.forEach {
                    PText(it)
                }
            }

            // Community Nursing care
            Box(modifier = Modifier.fillMaxWidth().background(Color.lightgray).height(2.px).margin(topBottom = 16.px))


            H1(
                attrs = Modifier
                    .margin(top = 32.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("If you have been involved in an accident, suffered an injury or have been in hospital for an illness, you may need some support at home for a period of time whilst you get back on your fee.")
            }

            H1(
                attrs = Modifier
                    .margin(top = 12.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.SemiBold)
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
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Our support services are tailored to you.")
            }

            H1(
                attrs = Modifier
                    .margin(top = 12.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("If you need help transitioning from the hospital to your home, you may need to access our short-term support services. From help with cleaning your home to attending appointments, we can support you.")
            }


            VerticalSpacer(32f)

        }
    }
}

@Composable
fun ServiesImage(image: String) {
    Column(
        modifier = Modifier.fillMaxSize(80.percent).fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().borderRadius(8.px),
            src = image,
        )
    }
}

@Composable
fun ServiesText(
    breakpoint: Breakpoint,
    content: List<String>
) {

    Column(modifier = Modifier.fillMaxHeight().thenIf(breakpoint < Breakpoint.MD) {
        Modifier.margin(top = 32.px)
    }, verticalArrangement = Arrangement.Center) {
        content.forEachIndexed { _, s ->
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.SemiBold)
                    .toAttrs()
            ) {
                Text(s)
            }
        }
    }
}