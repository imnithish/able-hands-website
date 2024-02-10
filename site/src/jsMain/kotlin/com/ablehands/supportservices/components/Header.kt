/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.LogoStyle
import com.ablehands.supportservices.styles.NavigationItemStyle
import com.ablehands.supportservices.styles.PhoneNumberStyle
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Content.servicesExpanded
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
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
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(onMenuClicked: (Boolean) -> Unit) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 85.percent else 90.percent)
            .margin(topBottom = 40.px),
        horizontalArrangement = if (breakpoint <= Breakpoint.MD) Arrangement.Center else Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD)
            LogoSideMD(onMenuClicked = onMenuClicked)
        else
            Header()
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
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 10.px, right = 8.px),
                size = IconSize.LG
            )
            H1(
                attrs = Modifier
                    .fontFamily(FONT_FAMILY)
                    .fontSize(22.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.number)
            }
        }
        Row(
            modifier = PhoneNumberStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaEnvelope(
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 4.px, right = 6.px),
                size = IconSize.SM
            )
            H1(
                attrs = Modifier
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.email1)
            }
        }
        Row(
            modifier = PhoneNumberStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaEnvelope(
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 4.px, right = 6.px),
                size = IconSize.SM
            )
            H1(
                attrs = Modifier
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.email2)
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.5.px).background(org.jetbrains.compose.web.css.Color.lightgray))
        Row(
            modifier = Modifier
                .fillMaxWidth().margin(top = 20.px),
        ) {
            Section.entries.filterNot { it.id == "main" }.forEachIndexed { index, section ->
                Row(verticalAlignment = Alignment.CenterVertically) {

                    if (section.id == "services") {
                        ServicesNavBarItem(mainText = section.titleVariant, href = section.path, servicesExpanded)
                    } else
                        Link(
                            modifier = NavigationItemStyle.toModifier()
                                .fontFamily(FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.SemiBold)
                                .margin(right = if (index == 3) 0.px else 18.px)
                                .textDecorationLine(TextDecorationLine.None),
                            path = section.path,
                            text = section.titleVariant
                        )
                }

            }
        }
    }

}


@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LogoSide()
            Row(
                modifier = Modifier.margin(leftRight = 32.px),
            ) {
                Section.entries.filterNot { it.id == "main" }.forEachIndexed { index, section ->
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        if (section.id == "services") {
                            ServicesNavBarItem(mainText = section.titleVariant, href = section.path, servicesExpanded)
                        } else
                            Link(
                                modifier = NavigationItemStyle.toModifier()
                                    .fontFamily(FONT_FAMILY)
                                    .fontSize(18.px)
                                    .fontWeight(FontWeight.SemiBold)
                                    .margin(right = if (index == 3) 0.px else 18.px)
                                    .textDecorationLine(TextDecorationLine.None),
                                path = section.path,
                                text = section.titleVariant
                            )
                    }

                }
            }
        }
        Column {

            Row(
                modifier = PhoneNumberStyle.toModifier(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaEnvelope(
                    modifier = Modifier.color(Theme.Base.rgb).margin(bottom = 4.px, right = 6.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.email1)
                }
            }
            Row(
                modifier = PhoneNumberStyle.toModifier(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaEnvelope(
                    modifier = Modifier.color(Theme.Base.rgb).margin(bottom = 4.px, right = 6.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.email2)
                }
            }
            Row(
                modifier = PhoneNumberStyle.toModifier(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaPhone(
                    modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 10.px, right = 8.px),
                    size = IconSize.SM
                )
                H1(
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Medium)
                        .color(Theme.Base.rgb)
                        .toAttrs()
                ) {
                    Text(Content.number)
                }
            }
        }
    }
}
