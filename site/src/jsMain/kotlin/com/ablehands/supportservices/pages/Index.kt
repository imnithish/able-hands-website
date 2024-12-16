/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ablehands.supportservices.components.BackToTopButton
import com.ablehands.supportservices.components.OverflowMenu
import com.ablehands.supportservices.sections.*
import com.ablehands.supportservices.sections.services.*
import com.ablehands.supportservices.util.scrollToSectionFromHash
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.core.Page
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {

    LaunchedEffect(window.location.hash) {
        scrollToSectionFromHash()
    }

    val (menuOpened, setMenuOpened) = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = setMenuOpened)
            AboutSection2()
            MissionSection2()
            ServicesSection2()
            DailyPersonalCareSection2()
//            MissionSection()
//            ServicesSection()
//            SILSection()
//            DailyPersonalCareSection()
//            HomeServices()
            SupportInSocialActivitiesSection2()
            AssistanceWithTravelSection2()
            CommunityNursingCareSection2()
            TailoredSection()
            ContactSection2()
            FooterSection()
        }
        BackToTopButton()
        if (menuOpened) {
            OverflowMenu(onMenuClosed = setMenuOpened)
        }
    }
}
