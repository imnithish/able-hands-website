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
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun HomeServices() {
    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        Content.servicesExpanded[2]
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
            if (breakpoint <= Breakpoint.MD) {
                // TODO: implement md
            } else
                HomeServicesContent(serviceSection)
        }
    }
}

@Composable
fun HomeServicesContent(serviceSection: Pair<String, String>) {
    Column(
        modifier = Modifier
            .margin(top = 18.px)
            .fillMaxWidth(85.percent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Column {
                SectionTitle(section = serviceSection.second)
                VerticalSpacer(8f)

                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY2)
                        .fontSize(26.px)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Assistance with day-to-day activities at home. \uD83C\uDFE0")
                }
                VerticalSpacer(8f)


                SimpleGrid(
                    modifier = Modifier.fillMaxWidth(),
                    numColumns = numColumns(base = 1, md = 2),
                ) {
                    Content.homeSupportServices.forEachIndexed {i,j->
                        val broken = j.split("+")

                        Column(Modifier.flexWrap(FlexWrap.Wrap).padding(right = 32.px, top = if (i>1)12.px else 0.px)) {


                            SpanText(
                                modifier = Modifier
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(17.px)
                                    .fontWeight(FontWeight.SemiBold),
                                text = "${broken[0]}: "
                            )

                            SpanText(
                                modifier = Modifier
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(16.px)
                                    .fontWeight(FontWeight.Medium),
                                text = broken[1]
                            )

                        }
                    }
                }
            }


//            Image(
//                modifier = Modifier.borderRadius(8.px).weight(1f).margin(left = 60.px),
//                src = Res.Image.image6,
//                width = 400,
//                height = 250
//            )

        }
    }
}