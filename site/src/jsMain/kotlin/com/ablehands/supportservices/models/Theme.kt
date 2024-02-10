/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#384E9F", rgb = rgb(r = 56, g = 78, b = 159)),
    Secondary(hex = "#B35EA2", rgb = rgb(r = 179, g = 94, b = 162)),
    Base(hex = "#121D34", rgb = rgb(r = 18, g = 29, b = 52)),
    Red(hex = "#8B0000", rgb = rgb(r = 139, g = 0, b = 0)),
    LightGray(hex = "#EDEDED", rgb = rgb(r = 237, g = 237, b = 237)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249)),
    LightBlue(hex = "#e8ecf3", rgb = rgb(r = 232, g = 236, b = 243)),

    Bg(hex = "#3151a3", rgb = rgba(r = 49, g = 81, b = 163, a = 0.10)),
    Bg2(hex = "#F4F4F4", rgb = rgba(r = 244, g = 244, b = 244, a = 1)),
    Black(hex = "#000000", rgb = rgba(r = 0, g = 0, b = 0, a = 1)),
    Black40(hex = "#000000", rgb = rgba(r = 0, g = 0, b = 0, a = .40)),
    Caption(hex = "#363636", rgb = rgba(r = 54, g = 54, b = 54, a = 1)),

    AboutSecondaryLight(hex = "#F7E3F3", rgb = rgba(r = 247, g = 227, b = 243, a = 1)),

    GrayVariant(hex = "#363636", rgb = rgba(r = 54, g = 54, b = 54, a = 1))


}