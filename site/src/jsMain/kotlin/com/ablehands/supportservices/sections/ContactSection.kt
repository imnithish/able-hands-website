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
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
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
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (breakpoint <= Breakpoint.MD) {
                // TODO: ContactContentMD
            } else
                ContactContent()
        }
    }
}

@Composable
fun ContactContent() {
    Column(
        modifier = Modifier
            .margin(top = 40.px)
            .fillMaxWidth(85.percent)
    ) {

        SectionTitle(
            section = Section.Contact,
        )

        VerticalSpacer(32f)

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            ContactForm(Modifier.weight(1f))
            Box(modifier = Modifier.width(48.px)) { }
            ContactContentRight(Modifier.weight(1f))
        }

        VerticalSpacer(32f)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            NDISImage(100)

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FaLocationDot(
                        modifier = Modifier.color(Theme.Base.rgb).margin(bottom = 10.px, right = 6.px),
                        size = IconSize.SM
                    )

                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Medium)
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
                        size = IconSize.SM
                    )
                    H1(
                        attrs = Modifier
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Medium)
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
                            .fontWeight(FontWeight.Medium)
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
                            .fontWeight(FontWeight.Medium)
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

        VerticalSpacer(74f)
        P(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .fillMaxWidth()
                .textAlign(TextAlign.Center)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Base.rgb)
                .toAttrs()
        ) {
            Text("© Able Hands Support Services, 2024")
        }

    }
}

@Composable
fun ContactContentRight(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Iframe(
            attrs = {
                attr("width", "100%")
                attr("height", "350")
                attr("src", "https://maps.google.com/maps?q=-27.524840, 153.209890&output=embed")
            }
        )
    }
}