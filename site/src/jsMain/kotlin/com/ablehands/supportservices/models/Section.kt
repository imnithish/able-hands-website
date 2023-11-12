package com.ablehands.supportservices.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    About(
        id = "about",
        title = "About Us",
        subtitle = "",
        path = "#about"
    ),
    Mission(
        id = "mission",
        title = "Our Mission",
        subtitle = "",
        path = "#mission"
    ),
    Services(
        id = "services",
        title = "Our Services",
        subtitle = "",
        path = "#services"
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "",
        path = "#contact"
    )
}