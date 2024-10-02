/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.components

import androidx.compose.runtime.*
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.ablehands.supportservices.util.Content.servicesExpanded
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.init.KobwebConfig
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.toOpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun OverflowMenu(onMenuClosed: (Boolean) -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    val ctx = rememberPageContext()

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

    var expanded by remember {
        mutableStateOf(false)
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
                    modifier = Modifier.height(58.px).width(180.px),
                    src = Res.Image.logo
                )
            }
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .margin(bottom = 24.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Medium)
                    .textDecorationLine(TextDecorationLine.None)
                    .onClick {
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            delay(500)
                            onMenuClosed(false)
                        }
                    },
                path = "#about",
                text = "About US",
                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
            )

            Link(
                modifier = NavigationItemStyle.toModifier()
                    .margin(bottom = 24.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Medium)
                    .textDecorationLine(TextDecorationLine.None)
                    .onClick {
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            delay(500)
                            onMenuClosed(false)
                        }
                    },
                path = "#mission",
                text = "Our Mission",
                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
            )

            Row(modifier = Modifier.onClick {
                expanded = !expanded
            }) {
                H1(
                    attrs = Modifier
                        .margin(bottom = 24.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Medium).toAttrs(),
                ) {
                    Text("Our Services")
                }

                Image(
                    modifier = Modifier.margin(left = 10.px).thenIf(expanded) {
                        Modifier.rotate(180.deg)
                    },
                    src = Res.Image.arror_down_black
                )
            }
            if (expanded) {
                servicesExpanded.forEach {
                    Link(
                        modifier = NavigationItemStyle.toModifier()
                            .margin(bottom = 24.px)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Medium)
                            .textDecorationLine(TextDecorationLine.None)
                            .onClick {
                                scope.launch {
                                    translateX = (-100).percent
                                    opacity = 0.percent
                                    delay(500)
                                    onMenuClosed(false)
                                }
                            },
                        path = "#" + it.first,
                        text = it.second,
                        openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                    )
                }
            }

            Button(
                attrs = Modifier
                    .height(49.px)
                    .border(width = 0.px)
                    .borderRadius(r = 10.px)
                    .padding(leftRight = 16.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .fontSize(20.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .onClick { evt ->
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            delay(500)
                            onMenuClosed(false)
                        }
                        ctx.router.navigateTo(
                            "#contact ",
                            openInternalLinksStrategy = evt.toOpenLinkStrategy(
                                KobwebConfig.Instance.openLinkStrategies.internal
                            ),
                            openExternalLinksStrategy = evt.toOpenLinkStrategy(
                                KobwebConfig.Instance.openLinkStrategies.external
                            )
                        )
                    }
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Connect with us")
            }
        }
    }
}