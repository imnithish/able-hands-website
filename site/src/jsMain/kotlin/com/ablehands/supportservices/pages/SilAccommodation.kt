/*
 * Created by Nitheesh AG on 16, 12, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.Header2
import com.ablehands.supportservices.components.OverflowMenu
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.sections.ContactSection2
import com.ablehands.supportservices.sections.FooterSection
import com.ablehands.supportservices.sections.accommodation.AccommodationContent
import com.ablehands.supportservices.sections.accommodation.AccommodationGallery
import com.ablehands.supportservices.sections.accommodation.AccommodationImage
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res.Image.ion_location
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Page(routeOverride = "sil-accommodation")
@Composable
fun SilAccommodationPage() {
    val (menuOpened, setMenuOpened) = remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header2(onMenuClicked = setMenuOpened, navToRoot = true)
            AccommodationImage()

            H1(
                attrs = Modifier
                    .margin(top = 42.px, leftRight = 32.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Constants.FONT_FAMILY2)
                    .fontSize(if (breakpoint < Breakpoint.MD) 24.px else 30.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Discover the right accommodation for your needs.")
            }

            VerticalSpacer(16f)

            Row(verticalAlignment = Alignment.CenterVertically) {

                val imageSize = remember(breakpoint) {
                    if (breakpoint < Breakpoint.MD) 24 else 36
                }
                Image(
                    width = imageSize,
                    height = imageSize,
                    src = ion_location
                )


                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint < Breakpoint.MD) 16.px else 20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Black.rgb)
                        .textAlign(TextAlign.Center)
                        .margin(left = 10.px, top = 10.px)
                        .toAttrs()
                ) {
                    Text(
                        "Victoria Point 4165"
                    )
                }
            }

            VerticalSpacer(42f)

            AccommodationContent()

            VerticalSpacer(if (breakpoint < Breakpoint.MD) 32f else 42f)

            AccommodationGallery()

            VerticalSpacer(32f)

            ContactSection2(
                heading = "Interested in this property? Get in touch for more information.",
                showImage = false
            )
            FooterSection()
        }
        if (menuOpened) {
            OverflowMenu(onMenuClosed = setMenuOpened, true)
        }
    }
}