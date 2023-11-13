package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.Header
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
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
import org.jetbrains.compose.web.dom.Th

@Composable
fun MissionSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Mission.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (breakpoint <= Breakpoint.MD) {
                MissionContentMD()
            } else
                MissionContent()
        }
    }
}

@Composable
fun MissionContentMD() {
    Column(
        Modifier
            .fillMaxWidth(90.percent)
            .margin(top = 54.px)
    ) {
        SectionTitle(section = Section.Mission, color = Theme.Primary.rgb, anim = false)
        Column(
            modifier = Modifier
                .margin(top = 6.px)
                .fillMaxWidth().backgroundColor(Theme.LightGray.rgb).borderRadius(8.px).padding(12.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(100.percent).objectFit(ObjectFit.ScaleDown).borderRadius(8.px),
                src = Res.Image.mission,
                width = 512,
                height = 341
            )

            Column {
                P(
                    attrs = Modifier
                        .weight(2f)
                        .margin(top = 12.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[0])
                }
                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[1])
                }
                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[2])
                }

                H1(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Our Vision")
                }

                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[3])
                }

                H1(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Our Values")
                }

                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[4])
                }
            }
        }

    }
}


@Composable
fun MissionContent() {
    Column(
        modifier = Modifier
            .margin(top = 128.px)
            .fillMaxWidth(85.percent),
        horizontalAlignment = Alignment.End
    ) {
        SectionTitle(
            section = Section.Mission,
            color = Theme.Primary.rgb,
            anim = true,
            modifier = Modifier.padding(right = 32.px)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 32.px)
                .backgroundColor(Theme.LightGray.rgb).borderRadius(8.px)
                .padding(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[0])
                }
                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[1])
                }
                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[2])
                }

                H1(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Our Vision")
                }

                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[3])
                }

                H1(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("Our Values")
                }

                P(
                    attrs = Modifier
                        .weight(2f)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.missions[4])
                }
            }


            Image(
                modifier = Modifier.borderRadius(8.px).scale(1.2f).margin(left = 60.px),
                src = Res.Image.mission,
                width = 512,
                height = 341
            )
        }
    }
}