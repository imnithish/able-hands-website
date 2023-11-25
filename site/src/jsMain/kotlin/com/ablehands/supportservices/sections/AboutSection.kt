package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Constants.SECTION_WIDTH
import com.ablehands.supportservices.util.Content.about_us
import com.ablehands.supportservices.util.Res
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
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection(onMenuClicked: (Boolean) -> Unit) {

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (breakpoint <= Breakpoint.MD) {
                AboutContentMD()
            } else
                AboutContent()
        }
    }
}

@Composable
fun AboutContentMD() {

    Column(
        Modifier
            .fillMaxWidth(90.percent)
    ) {
        SectionTitle(section = Section.About)
        Column(
            modifier = Modifier
                .margin(top = 6.px)
                .fillMaxWidth().backgroundColor(Theme.LightGray.rgb).borderRadius(8.px).padding(12.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(100.percent).objectFit(ObjectFit.ScaleDown).borderRadius(8.px),
                src = Res.Image.unnamed
            )

            P(
                attrs = Modifier
                    .weight(1f)
                    .fontFamily(Constants.FONT_FAMILY)
                    .margin(top = 12.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(about_us)
            }
        }

    }

}

@Composable
fun AboutContent() {
    Column(
        modifier = Modifier
            .margin(top=44.px)
            .fillMaxWidth(85.percent)
    ) {
        SectionTitle(section = Section.About, modifier = Modifier.padding(left = 32.px))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 32.px)
                .backgroundColor(Theme.LightBlue.rgb).borderRadius(8.px)
                .padding(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.borderRadius(8.px).weight(1f).scale(1.2f),
                src = Res.Image.unnamed
            )

            P(
                attrs = Modifier
                    .weight(1f)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .margin(left = 60.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(about_us)
            }
        }
    }
}