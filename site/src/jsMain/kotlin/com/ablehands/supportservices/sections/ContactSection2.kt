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
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.InputStyle
import com.ablehands.supportservices.styles.MainButtonStyle
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res.Image.formspree
import com.ablehands.supportservices.util.Res.Image.unsplash_4le7k9xvyje
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactSection2(heading: String = "Connect with Us", showImage: Boolean = true) {
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth()
                then (
                if (breakpoint < Breakpoint.MD)
                    Modifier.margin(top = 24.px, bottom = 66.px)
                else
                    Modifier.margin(top = 64.px, bottom = 80.px)
                )
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        if (breakpoint < Breakpoint.MD)
            Column(
                modifier = Modifier.fillMaxWidth().padding(
                    left = 22.px, right = 22.px
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (showImage) {
                    Image(
                        src = unsplash_4le7k9xvyje,
                        modifier = Modifier.fillMaxWidth()
                    )
                    VerticalSpacer(40f)
                }

                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(24.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Black.rgb)
                        .toAttrs()
                ) {
                    Text(heading)
                }

                VerticalSpacer(24f)

                Form(
                    action = formspree,
                    attrs = Modifier
                        .fillMaxWidth()
                        .attrsModifier {
                            attr("method", "POST")
                        }
                        .toAttrs()
                ) {
                    Input(
                        type = InputType.Text,
                        attrs = InputStyle.toModifier()
                            .id("inputName")
                            .classNames("form-control")
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontWeight(FontWeight.Normal)
                            .borderRadius(4.px)
                            .minHeight(60.px)
                            .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                            .attrsModifier {
                                attr("placeholder", "Full Name")
                                attr("name", "name")
                                attr("required", "true")
                            }
                            .toAttrs()
                    )
                    VerticalSpacer(24f)
                    Input(
                        type = InputType.Email,
                        attrs = InputStyle.toModifier()
                            .id("inputEmail")
                            .classNames("form-control")
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontWeight(FontWeight.Normal)
                            .borderRadius(4.px)
                            .minHeight(60.px)
                            .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                            .attrsModifier {
                                attr("placeholder", "Email Address")
                                attr("name", "email")
                                attr("required", "true")
                            }
                            .toAttrs()
                    )
                    VerticalSpacer(24f)

                    TextArea(
                        attrs = InputStyle.toModifier()
                            .id("inputMessage")
                            .classNames("form-control")
                            .minHeight(195.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontWeight(FontWeight.Normal)
                            .borderRadius(4.px)
                            .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                            .attrsModifier {
                                attr("placeholder", "Your Message")
                                attr("name", "message")
                                attr("required", "true")
                            }
                            .toAttrs()
                    )
                    VerticalSpacer(24f)

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            attrs = MainButtonStyle.toModifier()
                                .height(49.px)
                                .border(width = 0.px)
                                .borderRadius(r = 5.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontWeight(FontWeight.Medium)
                                .fontSize(20.px)
                                .backgroundColor(Theme.Primary.rgb)
                                .color(Colors.White)
                                .cursor(Cursor.Pointer)
                                .toAttrs()
                        ) {
                            Text("Submit")
                        }
                    }
                }
            }
        else {
            Row(
                modifier = Modifier.fillMaxWidth().padding(
                    left = 64.px, right = 64.px
                ),
                horizontalArrangement = if (!showImage) Arrangement.Center else Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.minWidth(485.px),
                    horizontalAlignment = Alignment.Start,
                ) {

                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(if (!showImage) 28.px else 40.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Black.rgb)
                            .toAttrs()
                    ) {
                        Text(heading)
                    }

                    VerticalSpacer(44f)

                    Form(
                        action = formspree,
                        attrs = Modifier
                            .fillMaxWidth()
                            .attrsModifier {
                                attr("method", "POST")
                            }
                            .toAttrs()
                    ) {
                        Input(
                            type = InputType.Text,
                            attrs = InputStyle.toModifier()
                                .id("inputName")
                                .classNames("form-control")
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontWeight(FontWeight.Normal)
                                .borderRadius(4.px)
                                .minHeight(60.px)
                                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                                .attrsModifier {
                                    attr("placeholder", "Full Name")
                                    attr("name", "name")
                                    attr("required", "true")
                                }
                                .toAttrs()
                        )
                        VerticalSpacer(24f)
                        Input(
                            type = InputType.Email,
                            attrs = InputStyle.toModifier()
                                .id("inputEmail")
                                .classNames("form-control")
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontWeight(FontWeight.Normal)
                                .borderRadius(4.px)
                                .minHeight(60.px)
                                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                                .attrsModifier {
                                    attr("placeholder", "Email Address")
                                    attr("name", "email")
                                    attr("required", "true")
                                }
                                .toAttrs()
                        )
                        VerticalSpacer(24f)

                        TextArea(
                            attrs = InputStyle.toModifier()
                                .id("inputMessage")
                                .classNames("form-control")
                                .minHeight(195.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontWeight(FontWeight.Normal)
                                .borderRadius(4.px)
                                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                                .attrsModifier {
                                    attr("placeholder", "Your Message")
                                    attr("name", "message")
                                    attr("required", "true")
                                }
                                .toAttrs()
                        )
                        VerticalSpacer(24f)

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                attrs = MainButtonStyle.toModifier()
                                    .height(49.px)
                                    .border(width = 0.px)
                                    .borderRadius(r = 5.px)
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .fontWeight(FontWeight.Medium)
                                    .fontSize(20.px)
                                    .backgroundColor(Theme.Primary.rgb)
                                    .color(Colors.White)
                                    .cursor(Cursor.Pointer)
                                    .toAttrs()
                            ) {
                                Text("Submit")
                            }
                        }
                    }
                }

                if (showImage)
                    Image(
                        src = unsplash_4le7k9xvyje,
                        width = 604,
                        height = 385
                    )
            }

        }
    }
}