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
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val LogoStyle by ComponentStyle {
    base {
        Modifier
            .width(86.px)
            .height(81.px)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val PhoneNumberStyle by ComponentStyle {
    base {
        Modifier
            .transform { scale(1f) }
            .transition(
                CSSTransition(property = "transform", duration = 200.ms)
            )
    }
    hover {
        Modifier
            .transform { scale(1.05f) }

    }
}

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Black.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    anyLink {
        Modifier.color(Theme.Black.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}