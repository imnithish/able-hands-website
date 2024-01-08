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
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun DailyPersonalCareSection() {
    val breakpoint = rememberBreakpoint()

    val serviceSection = remember {
        Content.servicesExpanded[1]
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
            DailyPersonalCareContent(serviceSection)
        }
    }
}

@Composable
fun DailyPersonalCareContent(serviceSection: Pair<String, String>) {
    Column(
        modifier = Modifier
            .margin(top = 24.px)
            .fillMaxWidth(85.percent)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth().borderRadius(8.px)
                .padding(12.px),
            verticalAlignment = Alignment.Top
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
                    Text("Respectful support for your daily life. \uD83E\uDEE1")
                }
                VerticalSpacer(8f)


                P(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.dailyPerCareAndDomTasksDes.first())
                }
            }

            Image(
                modifier = Modifier.borderRadius(8.px).weight(1f).margin(left = 60.px),
                src = Res.Image.image4,
                width = 492,
                height = 321
            )
        }
    }
}

