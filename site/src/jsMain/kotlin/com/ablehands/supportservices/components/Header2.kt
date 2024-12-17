/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.init.KobwebConfig
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.toOpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header2(onMenuClicked: (Boolean) -> Unit, navToRoot: Boolean = false) {
    val breakpoint = rememberBreakpoint()
    val ctx = rememberPageContext()

    val topBottomMargin = remember(breakpoint) {
        if (breakpoint <= Breakpoint.MD)
            19.px else 16.px
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = topBottomMargin),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AbleLogo(breakpoint = breakpoint)

        if (breakpoint <= Breakpoint.MD)
            HamButton(onMenuClicked)
        else
            Row(
                modifier = Modifier.margin(left = 36.px, right = 154.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Section.entries.filterNot { it.id == "main" }.forEachIndexed { index, section ->
                    when (section.id) {
                        "services" -> ServicesNavBarItem(
                            mainText = section.titleVariant,
                            href = section.path,
                            Content.servicesExpanded,
                            navToRoot = navToRoot
                        )

                        "contact" -> {
                            Button(
                                attrs = Modifier
                                    .height(49.px)
                                    .width(184.px)
                                    .border(width = 0.px)
                                    .borderRadius(r = 10.px)
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontWeight(FontWeight.Medium)
                                    .fontSize(18.px)
                                    .backgroundColor(Theme.Primary.rgb)
                                    .color(Colors.White)
                                    .onClick { evt ->
                                        ctx.router.navigateTo(
                                            section.path,
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
                                Text(section.titleVariant)
                            }
                        }

                        else -> {
                            Link(
                                modifier = NavigationItemStyle.toModifier()
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(20.px)
                                    .fontWeight(FontWeight.Medium)
                                    .margin(right = if (index == 3) 0.px else 48.px)
                                    .textDecorationLine(TextDecorationLine.None),
                                path = if (navToRoot) "/${section.path}" else section.path,
                                text = section.titleVariant
                            )
                        }
                    }
                }
            }
    }
}

@Composable
fun AbleLogo(breakpoint: Breakpoint) {
    val widthAndHeight = remember(breakpoint) {
        if (breakpoint <= Breakpoint.MD)
            Pair(180.px, 58.px) else Pair(245.px, 79.px)
    }

    val ctx = rememberPageContext()

    Image(
        modifier = Modifier
            .width(widthAndHeight.first)
            .height(widthAndHeight.second)
            .margin(left = if (breakpoint <= Breakpoint.MD) 20.px else 64.px)
            .onClick {
                ctx.router.navigateTo("/")
            }.styleModifier {
                cursor("pointer")
            },
        src = Res.Image.logo,
    )
}

@Composable
fun HamButton(onMenuClicked: (Boolean) -> Unit) {
    Image(
        modifier = Modifier
            .width(27.px)
            .onClick { onMenuClicked(true) }
            .margin(right = 20.px)
            .height(12.00001.px),
        src = Res.Image.hambutton
    )
}