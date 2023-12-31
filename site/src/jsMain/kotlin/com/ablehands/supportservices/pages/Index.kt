package com.ablehands.supportservices.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.BackToTopButton
import com.ablehands.supportservices.components.OverflowMenu
import com.ablehands.supportservices.sections.AboutSection
import com.ablehands.supportservices.sections.ContactSection
import com.ablehands.supportservices.sections.MainSection
import com.ablehands.supportservices.sections.MissionSection
import com.ablehands.supportservices.sections.services.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    val (menuOpened, setMenuOpened) = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = setMenuOpened)
            AboutSection()
            MissionSection()
            ServicesSection()
            SILSection()
            DailyPersonalCareSection()
            HomeServices()
            SupportInSocialActivitiesSection()
            AssistanceWithTravelSection()
            CommunityNursingSection()
            ContactSection()
            Box(modifier = Modifier.height(10.px))
        }
        BackToTopButton()
        if (menuOpened) {
            OverflowMenu(onMenuClosed = setMenuOpened)
        }
    }
}
