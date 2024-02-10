/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

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
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.Black40.rgb
            )
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    focus {
        Modifier.border(
            width = 1.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb
        )
    }
    hover {
        Modifier.border(
            width = 1.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb
        )
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(120.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(140.px)
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