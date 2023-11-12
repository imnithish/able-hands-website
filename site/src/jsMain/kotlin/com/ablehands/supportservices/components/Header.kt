package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.LogoStyle
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.styles.PhoneNumberStyle
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaPhone
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(onMenuClicked: (Boolean) -> Unit) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 85.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = if (breakpoint <= Breakpoint.MD) Arrangement.Center else Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD)
            LogoSideMD(onMenuClicked = onMenuClicked)
        else
            LogoSide()
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

@Composable
fun LogoSideMD(onMenuClicked: (Boolean) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        FaBars(
            modifier = Modifier
                .align(Alignment.TopStart)
                .margin(top = 20.px, left = 10.px)
                .onClick {
                    onMenuClicked(true)
                },
            size = IconSize.XL
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center).then(LogoStyle.toModifier()),
            src = Res.Image.logo
        )
    }
}

@Composable
fun LogoSide() {
    Image(
        modifier = LogoStyle.toModifier().margin(left = 32.px),
        src = Res.Image.logo
    )
}

@Composable
fun RightSide() {

    Column(horizontalAlignment = Alignment.End) {
        Row(
            modifier = PhoneNumberStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaPhone(
                modifier = Modifier.color(Theme.Red.rgb).rotateY(180.deg).margin(bottom = 10.px, right = 8.px),
                size = IconSize.LG
            )
            H1(
                attrs = Modifier
                    .fontFamily(FONT_FAMILY)
                    .fontSize(22.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Red.rgb)
                    .toAttrs()
            ) {
                Text("+91 8907471155")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth().margin(top = 16.px),
        ) {
            Section.entries.forEachIndexed { index, section ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Black)
                        .textDecorationLine(TextDecorationLine.None)
                        .margin(right = if (index != Section.entries.size - 1) 18.px else 0.px),
                    path = section.path,
                    text = section.title
                )
            }
        }
    }

}
