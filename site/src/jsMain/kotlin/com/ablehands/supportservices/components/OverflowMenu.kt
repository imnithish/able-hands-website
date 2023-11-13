package com.ablehands.supportservices.components

import androidx.compose.runtime.*
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.styles.PhoneNumberStyle
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaPhone
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun OverflowMenu(onMenuClosed: (Boolean) -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed(false)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(CSSTransition(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = 25.px)
                .width(if (breakpoint < Breakpoint.MD) 90.percent else 55.percent)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(Colors.White)
                .translateX(tx = translateX)
                .transition(CSSTransition(property = "translate", duration = 500.ms))
        ) {
            Row(
                modifier = Modifier.margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaXmark(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .margin(right = 20.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed(false)
                            }
                        },
                    size = IconSize.LG
                )
                Image(
                    modifier = Modifier.size(80.px),
                    src = Res.Image.logo
                )
            }
            Section.entries.toTypedArray().take(6).forEach { section ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .margin(bottom = 10.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Black)
                        .textDecorationLine(TextDecorationLine.None)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed(false)
                            }
                        },
                    path = section.path,
                    text = section.title,
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                )
            }

            Row(
                Modifier.margin(top = 16.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaPhone(
                    modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 8.px, right = 8.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text("+91 8907471155")
                }
            }

            Row(
                Modifier.margin(top = 4.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaEnvelope(
                    modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 8.px, right = 8.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.email1)
                }
            }
            Row(
                Modifier.margin(top = 4.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaEnvelope(
                    modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 8.px, right = 8.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Black)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.email2)
                }
            }
        }
    }
}