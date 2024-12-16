/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ablehands.supportservices.components.Header2
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.ablehands.supportservices.util.Res.Image.image_4
import com.ablehands.supportservices.util.Res.Image.image_5
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: (Boolean) -> Unit) {

    var mainImage by remember { mutableStateOf(Res.Image.imagemain) }
    var currMainImage by remember {
        mutableStateOf(1)
    }

    val breakpoint = rememberBreakpoint()

    LaunchedEffect(breakpoint) {
        while (true) {
            when (currMainImage) {
                0 -> {
                    mainImage =
                        if (breakpoint < Breakpoint.MD) Res.Image.imagemain1mobile else
                            Res.Image.imagemain1
                    currMainImage = 1
                }

                else -> {
                    mainImage =
                        if (breakpoint < Breakpoint.MD) Res.Image.imagemainmobile else Res.Image.imagemain
                    currMainImage = 0
                }
            }
            delay(5000L)
        }
    }

    Box(
        modifier = Modifier
            .id(Section.Main.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header2(onMenuClicked = onMenuClicked)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = if (breakpoint <= Breakpoint.MD) Alignment.BottomStart else Alignment.Center
            ) {
                if (breakpoint <= Breakpoint.MD) {
                    MainBackground(mainImage)
                    Column(
                        modifier = Modifier
                            .margin(bottom = 14.px, left = 18.px)
                    ) {
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(40.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your choice.")
                        }
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(40.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your way.")
                        }
                    }
                } else {
                    MainBackground(mainImage)
                    Column(
                        modifier = Modifier.align(Alignment.CenterStart)
                            .margin(left = 102.px)
                    ) {
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(64.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your choice.")
                        }
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(64.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your way.")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NDISImage(size: Int) {
    Image(
        modifier = Modifier
            .height(size.px)
            .objectFit(ObjectFit.Contain),
        src = Res.Image.ndis,
    )
}

@Composable
fun MainBackground(imagemainmobile: String) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = imagemainmobile,
    )
}