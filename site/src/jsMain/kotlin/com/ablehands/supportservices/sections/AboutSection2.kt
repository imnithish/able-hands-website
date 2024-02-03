package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ablehands.supportservices.components.ReadMoreButton
import com.ablehands.supportservices.components.SectionTitle2
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content.aboutSub
import com.ablehands.supportservices.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenUnless
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection2() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth()
            .background(Theme.Bg.rgb)
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize().then(
                if (breakpoint < Breakpoint.MD)
                    Modifier.padding(top = 42.px, bottom = 39.px)
                else
                    Modifier.padding(top = 109.px, bottom = 103.px)
            ),
        ) {
            AboutSection2Content(breakpoint)
        }
    }
}

@Composable
fun AboutSection2Content(breakpoint: Breakpoint) {

    var expanded by remember { mutableStateOf(false) }

    val titleSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 24.px else 40.px
    }

    val contentSizes = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD) 14.px else 20.px
    }

    val mainImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(320, 239) else Pair(640, 467)
    }

    val subImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(310, 167) else Pair(896, 435)
    }

    val iconImageSize: Pair<Int, Int> = remember(breakpoint) {
        if (breakpoint < Breakpoint.MD)
            Pair(30, 32) else Pair(124, 130)
    }

    SimpleGrid(
        modifier = Modifier.then(
            if (breakpoint < Breakpoint.MD) Modifier.padding(left = 20.px) else Modifier.padding(
                left = 89.px
            )
        ),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        Column(modifier = Modifier.thenIf(breakpoint < Breakpoint.MD) {
            Modifier.padding(
                bottom = 29.px
            )
        })
        {
            SectionTitle2(title = Section.About.titleVariant, fontSize = titleSizes)
            Column(
                modifier = Modifier.fillMaxWidth().then(
                    if (breakpoint < Breakpoint.MD) Modifier.padding(right = 20.px) else Modifier.padding(
                        right = 89.px
                    )
                ),
            ) {
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(contentSizes)
                        .margin(top = 24.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Caption.rgb)
                        .toAttrs()
                ) {
                    Text(
                        "Able Hands Support Services is a registered NDIS provider with a team of dedicated registered nurses and experienced disability support workers in Queensland, Australia.\n" +
                                "We provide a range of disability and aged care services across Brisbane and surrounding regions. AHS aims to empower our participants to live happily and independently by providing a range of capacity and skill-building programs and individual supports that are bespoke to meet the unique needs of our participants."
                    )
                }

                if (expanded)
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(contentSizes)
                            .margin(top = if (breakpoint < Breakpoint.MD) 14.px else 24.px)
                            .fontWeight(FontWeight.Normal)
                            .color(Theme.Caption.rgb)
                            .toAttrs()
                    ) {
                        Text(
                            "Our approach is centred around understanding and meeting the unique needs of each person we support. We believe in the power of person-centred care and work closely with our participants to develop personalised support plans that address their specific goals and aspirations.\n" +
                                    "\n" +
                                    "Our friendly, professional staff listen to your concerns, collaborate, and plan programs and services that foster growth, skill building and overall well-being."
                        )
                    }

                ReadMoreButton(
                    modifier = Modifier.margin(top = if (breakpoint < Breakpoint.MD) 16.px else 60.px),
                    expanded = expanded,
                    textSize = if (breakpoint < Breakpoint.MD) 16.px else 24.px,
                    onClick = {
                        expanded = !expanded
                    })
            }

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Box { }
            AboutUsImage(mainImageSize)
        }

    }

    VerticalSpacer(if (breakpoint < Breakpoint.MD) 108f else 39f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme.AboutSecondaryLight.rgb)
    ) {
        Image(
            src = Res.Image.image_5,
            width = subImageSize.first,
            height = subImageSize.second
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                src = Res.Image.logo_about,
                width = iconImageSize.first,
                height = iconImageSize.second
            )
        }
    }

    VerticalSpacer(if (breakpoint < Breakpoint.MD) 32f else 114f)

    SimpleGrid(
        modifier = Modifier.then(
            if (breakpoint < Breakpoint.MD) Modifier.padding(leftRight = 20.px) else Modifier.padding(
                leftRight = 67.px
            )
        ),
        numColumns = numColumns(base = 1, md = 3)
    ) {
        aboutSub.forEachIndexed { i, it ->
            Column(
                modifier = Modifier.thenUnless(
                    breakpoint < Breakpoint.MD
                ) {
                    if (i == 0 || i == 1)
                        Modifier.padding(right = 66.px)
                    else Modifier
                }.thenIf(
                    breakpoint < Breakpoint.MD
                ) {
                    if (i == 1 || i == 2)
                        Modifier.padding(top = 24.px)
                    else Modifier
                },
            ) {
                H1(
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(titleSizes)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(
                        it.heading
                    )
                }

                it.points.forEach {
                    P(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(contentSizes)
                            .fontWeight(FontWeight.Normal)
                            .color(Theme.Base.rgb)
                            .toAttrs()
                    ) {
                        Text(
                            it
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun AboutUsImage(mainImageSize: Pair<Int, Int>) {
    Image(
        modifier = Modifier.objectFit(ObjectFit.Cover),
        src = Res.Image.image_4,
        width = mainImageSize.first,
        height = mainImageSize.second
    )
}

@Composable
fun AboutSection2ContentMD() {

}