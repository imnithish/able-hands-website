package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.Header
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: (Boolean) -> Unit) {

    val breakpoint = rememberBreakpoint()


    val size = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 24.px else 54.px
    }
    val ndisImageSize = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 40 else 100
    }

    val ndisBottomMargin = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 16.px else if (breakpoint >= Breakpoint.LG) 74.px else 24.px
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
            Header(onMenuClicked = onMenuClicked)

            Box(
                modifier = Modifier.fillMaxWidth(85.percent).borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                MainBackground()
                Column(
                    modifier = Modifier.align(Alignment.BottomStart)
                        .margin(left = size.value.px, bottom = ndisBottomMargin.value.px)
                ) {
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY2)
                            .fontSize(size.value.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Base.rgb)
                            .toAttrs()
                    ) {
                        Text("Your way.")
                    }
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY2)
                            .fontSize(size.value.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Base.rgb)
                            .toAttrs()
                    ) {
                        Text("Your choice.")
                    }

                    Box(
                        modifier = Modifier.height(if (ndisBottomMargin.value == 74f) 32.px else 0.px)
                    )
                    NDISImage(ndisImageSize)
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
fun MainBackground() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover).borderRadius(12.px),
        src = Res.Image.wheelchair,
    )
}