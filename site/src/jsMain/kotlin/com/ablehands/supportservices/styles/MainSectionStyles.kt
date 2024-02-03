package com.ablehands.supportservices.styles

import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

val NavItemStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Black.rgb)
            .fontFamily(Constants.FONT_FAMILY)
            .fontSize(20.px)
            .fontWeight(FontWeight.Medium)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    anyLink {
        Modifier.color(Theme.Black.rgb)
    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}


@OptIn(ExperimentalComposeWebApi::class)
val NavStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .fontWeight(FontWeight.SemiBold)
            .fontSize(FontSize.Large)
            .justifyContent(org.jetbrains.compose.web.css.JustifyContent.SpaceBetween)
    }
    cssRule(".navbar") {
        Modifier
            .display(DisplayStyle.Flex)
    }
    cssRule(".nav-bar .navbaritem") {
        Modifier
            .listStyle(ListStyleType.None)
            .borderRadius(r = 10.px)
            .padding(leftRight = 20.px)
    }
    cssRule(".navbar .navbaritem .dropdown") {
        Modifier
            .position(Position.Absolute)
            .display(DisplayStyle.None)
            .top(100.percent)
            .right(0.px)
            .overflow { y(Overflow.Hidden) }
    }
    cssRule(".dropdown .services") {
        Modifier
            .position(Position.Absolute)
            .right((-100).px)
            .width(Width.MaxContent)
            .backgroundColor(Colors.White)
            .padding(5.px)
            .borderRadius(10.px)
            .height(0.px)
            .overflow(Overflow.Hidden)
            .visibility(Visibility.Hidden)
    }
    cssRule(".dropdown:hover .services") {
        Modifier
            .height(Height.MinContent)
            .margin(top = 60.px)
            .visibility(Visibility.Visible)
            .overflow(Overflow.Hidden)
    }
    cssRule(".navbar .dropdown:hover .services") {
        Modifier
            .height(Height.MinContent)
            .margin(top = 20.px)
            .visibility(Visibility.Visible)
            .overflow(Overflow.Hidden)
    }
    cssRule(".dropdown .services .dropitems") {
        Modifier
            .top(100.percent)
            .margin(bottom = 5.px)
    }
    cssRule(".navbar .dropdown:after") {
        Modifier
            .content("")
            .position(Position.Absolute)
            .right((-10).px)
            .top(8.px)
            .cursor(Cursor.Pointer)
            .transform { rotate((-45).deg) }
            .borderLeft(1.8.px, LineStyle.Solid, Colors.Black)
            .borderBottom(1.8.px, LineStyle.Solid, Colors.Black)
            .transition(CSSTransition("all", 0.2.s, TransitionTimingFunction.EaseIn))
            .size(10.px)
    }
    cssRule(".navbar .dropdown:hover:after") {
        Modifier
            .transform { rotate(135.deg) }
    }
}