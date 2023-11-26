package com.ablehands.supportservices.models

enum class Section(
    val id: String,
    val title: String,
    val titleVariant: String,
    val path: String
) {
    Main(
        id = "main",
        title = "Main",
        titleVariant = "",
        path = "#main"
    ),
    About(
        id = "about",
        title = "About",
        titleVariant = "About Us",
        path = "#about"
    ),
    Mission(
        id = "mission",
        title = "Mission",
        titleVariant = "Our Mission",
        path = "#mission"
    ),
    Services(
        id = "services",
        title = "Services",
        titleVariant = "Our Services",
        path = "#services"
    ),
    Contact(
        id = "contact",
        title = "Contact",
        titleVariant = "Connect with us!",
        path = "#contact"
    )
}