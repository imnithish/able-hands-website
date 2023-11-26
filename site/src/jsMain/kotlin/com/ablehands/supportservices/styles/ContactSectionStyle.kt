package com.ablehands.supportservices.styles

import com.ablehands.supportservices.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val InputStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LightGray.rgb
            )
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    focus {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb
        )
    }
    hover {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb
        )
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(100.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(120.px)
    }
}

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Base.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}