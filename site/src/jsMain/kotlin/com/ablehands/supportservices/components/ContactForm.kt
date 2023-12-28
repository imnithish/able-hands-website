package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.InputStyle
import com.ablehands.supportservices.styles.MainButtonStyle
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H1(
            attrs = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(20.px)
                .fillMaxWidth()
                .textAlign(TextAlign.Start)
                .fontWeight(FontWeight.SemiBold)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("Write to us ✍\uFE0F")
        }

        VerticalSpacer(12f)

        Form(
            action = "https://formspree.io/f/xzbllejd",
            attrs = Modifier
                .fillMaxWidth()
                .attrsModifier {
                    attr("method", "POST")
                }
                .toAttrs()
        ) {
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .toAttrs(),
                forId = "inputName"
            ) {
                Text("Name")
            }
            Input(
                type = InputType.Text,
                attrs = InputStyle.toModifier()
                    .id("inputName")
                    .classNames("form-control")
                    .margin(bottom = 10.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)

                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .attrsModifier {
                        attr("placeholder", "Full Name")
                        attr("name", "name")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .toAttrs(),
                forId = "inputEmail"
            ) {
                Text("Email")
            }
            Input(
                type = InputType.Email,
                attrs = InputStyle.toModifier()
                    .id("inputEmail")
                    .classNames("form-control")
                    .margin(bottom = 10.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
//                    .width(
//                        if (breakpoint >= Breakpoint.MD) 500.px
//                        else 250.px
//                    )
                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .attrsModifier {
                        attr("placeholder", "Email Address")
                        attr("name", "email")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .toAttrs(),
                forId = "inputMessage"
            ) {
                Text("Message")
            }
            TextArea (
                attrs = InputStyle.toModifier()
                    .id("inputMessage")
                    .classNames("form-control")
                    .height(150.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .margin(bottom = 20.px)
//                    .width(
//                        if (breakpoint >= Breakpoint.MD) 500.px
//                        else 250.px
//                    )
                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .attrsModifier {
                        attr("placeholder", "Your Message")
                        attr("name", "message")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    attrs = MainButtonStyle.toModifier()
                        .height(40.px)
                        .border(width = 0.px)
                        .borderRadius(r = 5.px)
                        .fontFamily(FONT_FAMILY)
                        .fontWeight(FontWeight.Medium)
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

}