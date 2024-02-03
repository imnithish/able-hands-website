package com.ablehands.supportservices.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun ReadMoreButton(
    modifier: Modifier,
    textSize: CSSNumeric,
    expanded: Boolean = false,
    onClick: () -> Unit
) {

    val text = remember(expanded) {
        if (expanded) "Read less" else "Read more"
    }

    Row(
        modifier = modifier.onClick { onClick() },
    ) {

        H1(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(textSize)
                .fontWeight(FontWeight.SemiBold)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(text)
        }

        Image(
            modifier = Modifier.margin(left = 5.px).thenIf(expanded) {
                Modifier.rotate(180.deg)
            },
            src = Res.Image.arrowdown,
            width = 24,
            height = 24
        )
    }

}