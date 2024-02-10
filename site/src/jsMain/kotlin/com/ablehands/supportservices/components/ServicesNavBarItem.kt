/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.styles.NavItemStyle
import com.ablehands.supportservices.styles.NavStyle
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.util.Constants
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServicesNavBarItem(
    mainText: String,
    href: String,
    servicesExpanded: List<Pair<String, String>>
) {
    Div(
        attrs = NavStyle.toModifier()
            .width(Width.FitContent)
            .classNames("navbar")
            .padding(top = 0.px, bottom = 0.px, right = 48.px).toAttrs()
    ) {
        Div(
            attrs = NavStyle.toModifier()
                .classNames("navbaritems", "dropdown")
                .padding(topBottom = 0.px)
                .toAttrs()
        ) {
            A(
                attrs = NavItemStyle.toModifier()
                    .attrsModifier {
                        attr("href", href)
                    }
                    .cursor(Cursor.Pointer)
                    .padding(right = 10.px)
                    .toAttrs(),
                content = { Text(mainText) }
            )

            Div(
                attrs = NavItemStyle.toModifier()
                    .classNames("services")
                    .toAttrs()
            ) {
                Div(
                    attrs = NavItemStyle.toModifier()
                        .classNames("dropitems")
                        .width(Width.FitContent)
                        .toAttrs()
                ) {
                    ServicesDropdown(servicesExpanded)
                }
            }
        }
    }
}


@Composable
fun ServicesDropdown(servicesExpanded: List<Pair<String, String>>) {
    Column(
        modifier = NavStyle.toModifier()
            .classNames("drop-item")
            .margin(10.px)
            .padding(10.px)
            .width(Width.FitContent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = NavStyle.toModifier()
                .classNames("drop-item")
                .margin(leftRight = 5.px),
        ) {
            servicesExpanded.forEach { service ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .padding(top=8.px)
                        .fontWeight(FontWeight.Medium)
                        .textDecorationLine(TextDecorationLine.None),
                    path = "#${service.first}",
                    text = service.second
                )
            }
        }
    }
}