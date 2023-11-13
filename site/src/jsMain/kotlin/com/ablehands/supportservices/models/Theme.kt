package com.ablehands.supportservices.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#384E9F", rgb = rgb(r = 56, g = 78, b = 159)),
    Secondary(hex = "#B35EA2", rgb = rgb(r = 179, g = 94, b = 162)),
    Base(hex = "#121D34", rgb = rgb(r = 18, g = 29, b = 52)),
    Red(hex = "#8B0000", rgb = rgb(r = 139, g = 0, b = 0)),
    LightGray(hex = "#EDEDED", rgb = rgb(r = 237, g = 237, b = 237)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249))
}