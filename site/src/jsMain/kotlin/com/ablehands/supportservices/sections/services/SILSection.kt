package com.ablehands.supportservices.sections.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.servicesExpanded
import com.ablehands.supportservices.util.Content.silDes
import com.ablehands.supportservices.util.Res
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
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SILSection() {
    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        servicesExpanded.first()
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
                SILContent(serviceSection)
        }
    }
}

@Composable
fun SILContent(serviceSection: Pair<String, String>) {
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
                        .fontFamily(Constants.FONT_FAMILY2)
                        .fontSize(26.px)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Respectful support for your daily life. \uD83E\uDDE1")
                }
                VerticalSpacer(8f)


                silDes.forEach {
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
                src = Res.Image.image5,
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
            Text("Our services:")
        }
        VerticalSpacer(16f)


        SimpleGrid(
            modifier = Modifier.fillMaxWidth()
                .margin(left = 12.px),
            numColumns = numColumns(base = 1, md = 2),
        ) {
            Content.silProvide.forEach {

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
//        Content.silProvide.forEach {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//            ) {
//                P(
//                    attrs = Modifier
//                        .fontFamily(Constants.FONT_FAMILY)
//                        .fontSize(15.px)
//                        .fontWeight(FontWeight.Medium)
//                        .color(Theme.Base.rgb)
//                        .toAttrs()
//                ) {
//                    Text(it)
//                }
//            }
//
//        }
    }
}