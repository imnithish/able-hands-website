package com.ablehands.supportservices.sections

import androidx.compose.runtime.Composable
import com.ablehands.supportservices.components.ContactForm
import com.ablehands.supportservices.components.SectionTitle
import com.ablehands.supportservices.components.VerticalSpacer
import com.ablehands.supportservices.models.Section
import com.ablehands.supportservices.models.Theme
import com.ablehands.supportservices.styles.SocialLinkStyle
import com.ablehands.supportservices.util.Constants
import com.ablehands.supportservices.util.Content
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactSection() {

    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        ContactContent()
    }
}

@Composable
fun ContactContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = if (breakpoint <= Breakpoint.MD) 24.px else 112.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(
            section = Section.Contact,
        )

        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 80.percent
                else 90.percent
            ).margin(top = 32.px),
            numColumns = numColumns(base = 1, md = 2),
        ) {
            ContactForm(breakpoint = breakpoint)
            ContactContentRight(breakpoint)
        }


        VerticalSpacer(32f)
        P(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("© Able Hands Support Services")
        }


    }
}

@Composable
fun ContactContentRight(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier.fillMaxHeight().thenIf(breakpoint < Breakpoint.MD) {
            Modifier.margin(top = 32.px)
        },
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Iframe(
            attrs = {
                attr("width", "100%")
                attr("height", "350")
                attr("src", "https://maps.google.com/maps?q=-27.524840, 153.209890&output=embed")
            }
        )

        VerticalSpacer(32f)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaLocationDot(
                modifier = Modifier.color(Theme.Base.rgb).margin(bottom = 4.px, right = 6.px),
                size = IconSize.LG
            )

            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text("30 Ingham Street, Capalaba QLD 4157")
            }

        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaPhone(
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 10.px, right = 8.px),
                size = IconSize.LG
            )
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(22.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.number)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaEnvelope(
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 4.px, right = 6.px),
                size = IconSize.SM
            )
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.email1)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaEnvelope(
                modifier = Modifier.color(Theme.Base.rgb).rotateY(180.deg).margin(bottom = 4.px, right = 6.px),
                size = IconSize.SM
            )
            H1(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Black)
                    .color(Theme.Base.rgb)
                    .toAttrs()
            ) {
                Text(Content.email2)
            }
        }
        VerticalSpacer(8f)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Link(
                path = "https://github.com/imnithish",
                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
            ) {
                FaFacebook(
                    modifier = SocialLinkStyle.toModifier(),
                    size = IconSize.LG
                )
            }
            Box(modifier = Modifier.width(6.px))
            Link(
                path = "https://github.com/imnithish",
                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
            ) {
                FaInstagram(
                    modifier = SocialLinkStyle.toModifier(),
                    size = IconSize.LG
                )
            }
            Box(modifier = Modifier.width(6.px))

            Link(
                path = "https://github.com/imnithish",
                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
            ) {
                FaTwitter(
                    modifier = SocialLinkStyle.toModifier(),
                    size = IconSize.LG
                )
            }
        }
    }
}