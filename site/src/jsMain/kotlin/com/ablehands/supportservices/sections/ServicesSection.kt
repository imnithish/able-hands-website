package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.dailyPerCareAndDomTasksDes
import com.ablehands.supportservices.util.Content.homeSupportServices
import com.ablehands.supportservices.util.Content.silDes
import com.ablehands.supportservices.util.Res
import com.ablehands.supportservices.util.Res.Image.image4
import com.ablehands.supportservices.util.Res.Image.image5
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
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
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServicestSection() {

    val breakpoint = rememberBreakpoint()
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
            .margin(top = 112.px),
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
                            .fontFamily(Constants.FONT_FAMILY2)
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

            homeSupportServices.windowed(2, 2).forEach {
                it.forEach {

                    Row {
                        val broken = it.split("+")
                        Row(Modifier.flexWrap(FlexWrap.Wrap)) {

                            SpanText(
                                modifier = Modifier
                                    .fontFamily(Constants.FONT_FAMILY2)
                                    .fontSize(18.px)
                                    .fontWeight(FontWeight.Bold),
                                text = "${broken[0]}: "
                            )

                            SpanText(
                                modifier = Modifier
                                    .fontFamily(Constants.FONT_FAMILY2)
                                    .fontSize(18.px)
                                    .fontWeight(FontWeight.SemiBold),
                                text = broken[1]
                            )

                        }
                    }

                }



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

    Column {
        content.forEachIndexed { index, s ->
            P(
                attrs = Modifier
                    .thenIf(index == 0) {
                        Modifier.margin(top = if (breakpoint < Breakpoint.MD) 32.px else 0.px)
                    }
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.SemiBold)
                    .toAttrs()
            ) {
                Text(s)
            }
        }
    }
}