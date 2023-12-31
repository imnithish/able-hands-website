package com.ablehands.supportservices.components

import androidx.compose.runtime.*
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants.FONT_FAMILY
import com.ablehands.supportservices.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    color: CSSColorValue = Theme.Base.rgb,
    fontSize: Int = 26,
    anim: Boolean = false
) {

    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.px) }

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            scope.launch {
                titleMargin = 0.px
            }
        }
    )

    P(
        attrs = modifier
            .fontFamily(FONT_FAMILY)
            .fontSize(fontSize.px)
            .margin(
                right = if (anim) titleMargin else 0.px,
                top = 0.px,
                bottom = 0.px
            )
            .fontWeight(FontWeight.SemiBold)
            .color(color)
            .textAlign(TextAlign.Center)
            .transition(CSSTransition(property = "margin", duration = 300.ms))
            .toAttrs()
    ) {
        Text(section.titleVariant)
    }

}

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: String,
    color: CSSColorValue = Theme.Base.rgb,
    fontSize: Int = 22,
) {
    P(
        attrs = modifier
            .fontFamily(FONT_FAMILY)
            .fontSize(fontSize.px)
            .margin(
                right = 0.px,
                top = 0.px,
                bottom = 0.px
            )
            .fontWeight(FontWeight.SemiBold)
            .color(color)
            .toAttrs()
    ) {
        Text(section)
    }
}