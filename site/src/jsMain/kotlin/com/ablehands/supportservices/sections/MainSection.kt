package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.Header2
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: (Boolean) -> Unit) {

    val breakpoint = rememberBreakpoint()
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
            Header2(onMenuClicked = onMenuClicked)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = if (breakpoint <= Breakpoint.MD) Alignment.BottomStart else Alignment.Center
            ) {
                if (breakpoint <= Breakpoint.MD) {
                    MainBackground(Res.Image.imagemainmobile)
                    Column(
                        modifier = Modifier
                            .margin(bottom = 29.px, left=28.px)
                    ) {
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(40.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your choice.")
                        }
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(40.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your way.")
                        }
                    }
                } else {
                    MainBackground(Res.Image.imagemain)
                    Column(
                        modifier = Modifier.align(Alignment.CenterStart)
                            .margin(left = 102.px)
                    ) {
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(80.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Primary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your choice.")
                        }
                        H1(
                            attrs = Modifier
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(80.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text("Your way.")
                        }
                    }
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
fun MainBackground(imagemainmobile: String) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = imagemainmobile,
    )
}