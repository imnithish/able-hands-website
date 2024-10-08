/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.ablehands.supportservices.util.Res.Image.contactWays
import com.ablehands.supportservices.util.Res.Image.locationUrl
import com.ablehands.supportservices.util.Res.Image.social
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() {
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme.Bg2.rgb)
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        if (breakpoint < Breakpoint.MD) {
            Column(
                modifier = Modifier.padding(
                    bottom = 39.px,
                    left = 53.px,
                    right = 53.px,
                    top = 30.px
                ).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier
                        .width(180.px)
                        .height(58.px),
                    src = Res.Image.logo
                )
                VerticalSpacer(8f)
//                H1(
//                    attrs = Modifier
//                        .fontFamily(Constants.FONT_FAMILY)
//                        .fontSize(16.px)
//                        .fontWeight(FontWeight.Bold)
//                        .color(Theme.Primary.rgb)
//                        .toAttrs()
//                ) {
//                    Text("ABLE HANDS")
//                }
//                VerticalSpacer(1f)

                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text("DISABILITY SERVICES &")
                }

//                VerticalSpacer(1f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .textAlign(TextAlign.Center)
                        .toAttrs()
                ) {
                    Text("NURSING CARE")
                }

//                VerticalSpacer(1f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .textAlign(TextAlign.Center)
                        .toAttrs()
                ) {
                    Text("ORGANISATION")
                }

                VerticalSpacer(16f)
                Row {
                    social.forEachIndexed { index, s ->

                        Link(
                            modifier = Modifier.thenIf(index != social.size - 1) {
                                Modifier.margin(right = 20.px)
                            },
                            path = s.second,
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ) {
                            Image(
                                src = s.first,
                                width = 40,
                                height = 40
                            )
                        }
                    }
                }

                VerticalSpacer(24f)

                Image(
                    modifier = Modifier
                        .width(156.px)
                        .height(75.px),
                    src = Res.Image.ndisT
                )

                VerticalSpacer(24f)

                contactWays.forEachIndexed { i, it ->
                    Row(
                        modifier = Modifier.thenIf(i != contactWays.size - 1) {
                            Modifier.margin(bottom = 14.px)
                        },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            width = 24,
                            height = 24,
                            src = it.first
                        )

                        if (it.second.contains("+61")) {
                            A(
                                href = "tel:${it.second.trim()}",
                                attrs = Modifier
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(16.px)
                                    .margin(left = 10.px)
                                    .fontWeight(FontWeight.Normal)
                                    .color(Theme.Black.rgb)
                                    .toAttrs()
                            ) {
                                Text(it.second)

                            }
                        } else if (it.second.contains(".com")) {
                            A(
                                href = "mailto:${it.second.trim()}",
                                attrs = Modifier
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontSize(16.px)
                                    .margin(left = 10.px)
                                    .fontWeight(FontWeight.Normal)
                                    .color(Theme.Black.rgb)
                                    .toAttrs()
                            ) {
                                Text(it.second)
                            }
                        } else {
                            Link(
                                modifier = Modifier.margin(left = 10.px),
                                path = locationUrl,
                                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                            ) {
                                H1(
                                    attrs = Modifier
                                        .fontFamily(Constants.FONT_FAMILY)
                                        .fontSize(16.px)
                                        .fontWeight(FontWeight.Normal)
                                        .color(Theme.Black.rgb)
                                        .textAlign(TextAlign.Center)
                                        .toAttrs()
                                ) {
                                    Text(it.second)
                                }
                            }
                        }
                    }
                }

                VerticalSpacer(27f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .textAlign(TextAlign.Center)
                        .fontWeight(FontWeight.Light)
                        .color(Theme.GrayVariant.rgb)
                        .toAttrs()
                ) {
                    Text("Copyright (C) 2024 Able hands support services Pty Ltd.")
                }
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Light)
                        .color(Theme.GrayVariant.rgb)
                        .toAttrs()
                ) {
                    Text("ABN 16666893590   ACN 666893590")
                }
            }


        } else {
            Column(
                modifier = Modifier.padding(
                    bottom = 42.px,
                    left = 112.px,
                    right = 112.px,
                    top = 58.px
                ).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {
                        Image(
                            modifier = Modifier
                                .width(245.px)
                                .height(79.px),
                            src = Res.Image.logo
                        )
                        VerticalSpacer(15f)
//                        H1(
//                            attrs = Modifier
//                                .fontFamily(Constants.FONT_FAMILY)
//                                .fontSize(20.px)
//                                .fontWeight(FontWeight.Bold)
//                                .color(Theme.Primary.rgb)
//                                .toAttrs()
//                        ) {
//                            Text("ABLE HANDS")
//                        }
//                        VerticalSpacer(2f)
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("DISABILITY SERVICES &")
                        }

                        VerticalSpacer(2f)
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("NURSING CARE ORGANISATION")
                        }
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .width(198.px)
                                .height(95.px),
                            src = Res.Image.ndisT
                        )
                        /*
                        Add social media icons here
                         */

                        VerticalSpacer(51f)
                        Row {
                            social.forEachIndexed { index, s ->

                                Link(
                                    modifier = Modifier.thenIf(index != social.size - 1) {
                                        Modifier.margin(right = 20.px)
                                    },
                                    path = s.second,
                                    openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                                ) {
                                    Image(
                                        src = s.first,
                                        width = 56,
                                        height = 56
                                    )
                                }
                            }
                        }
                    }

                    Column {

                        contactWays.forEachIndexed { i, it ->
                            Row(
                                modifier = Modifier.thenIf(i != contactWays.size - 1) {
                                    Modifier.margin(bottom = 14.px)
                                },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    width = 24,
                                    height = 24,
                                    src = it.first
                                )

                                if (it.second.contains("4157")) {
                                    Link(
                                        modifier = Modifier.margin(left = 10.px),
                                        path = locationUrl,
                                        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                                    ) {
                                        H1(
                                            attrs = Modifier
                                                .fontFamily(Constants.FONT_FAMILY)
                                                .fontSize(20.px)
                                                .fontWeight(FontWeight.Normal)
                                                .color(Theme.Black.rgb)
                                                .toAttrs()
                                        ) {
                                            Text(it.second)
                                        }
                                    }
                                } else
                                    H1(
                                        attrs = Modifier
                                            .fontFamily(Constants.FONT_FAMILY)
                                            .fontSize(20.px)
                                            .margin(left = 10.px)
                                            .fontWeight(FontWeight.Normal)
                                            .color(Theme.Black.rgb)
                                            .toAttrs()
                                    ) {
                                        Text(it.second)
                                    }

                            }
                        }
                    }

                }
                VerticalSpacer(62f)
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Light)
                        .color(Theme.GrayVariant.rgb)
                        .toAttrs()
                ) {
                    Text("Copyright (C) 2024 Able hands support services Pty Ltd.")
                }
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Light)
                        .color(Theme.GrayVariant.rgb)
                        .toAttrs()
                ) {
                    Text("ABN 16666893590   ACN 666893590")
                }
            }
        }
    }
}