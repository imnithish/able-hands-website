/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

package com.ablehands.supportservices.util

object Constants {
    const val SECTION_WIDTH = 1920
    const val FONT_FAMILY = "Lexend"
    const val FONT_FAMILY2 = "Libre Bodoni"
}

object Res {
    object Icon {
    }

    object Image {
        const val logo = "logo_2.png"
        const val logoT = "image-1-3.png"
        const val hambutton = "hambutton.svg"
        const val unnamed = "unnamed.jpg"
        const val mission = "image2.jpg"
        const val wheelchair = "wheelchair.jpg"
        const val ndis = "ndis.png"
        const val image5 = "image5.jpg"
        const val image6 = "image6.jpg"
        const val image4 = "image4.jpg"
        const val image24 = "image24.png"
        const val image8 = "image8.jpg"
        const val image11 = "image11.jpg"
        const val ndisT = "ndisT.png"

        const val arrowdown = "arrowdown.svg"
        const val arror_down_black = "arror_down_black.svg"
        const val logo_about = "logo_about.svg"
        const val image_3_icon = "image-3.png"
        const val unsplash_4le7k9xvyje = "unsplash-4le7k9xvyje.png"


        const val ion_location = "ion-location.svg"
        const val solar_phone_bold = "solar-phone-bold.svg"
        const val tabler_mail_filled_1 = "tabler-mail-filled-1.svg"


        const val x = "x.svg"
        const val insta = "insta.svg"
        const val fb = "fb.svg"

        val social by lazy {
            listOf(
                Pair(fb, "https://www.facebook.com/share/agtfKiY9B6toe236/?mibextid=LQQJ4d "),
                Pair(insta, "https://www.instagram.com/ablehands.ss/"),
                Pair(x, "https://twitter.com/ablehands_")
            )
        }

        val contactWays by lazy {
            listOf(
//                Pair(solar_phone_bold, "+61 731341027"),
                Pair(solar_phone_bold, "+61 425131663"),
                Pair(tabler_mail_filled_1, "contact@ablehands.com.au"),
                Pair(tabler_mail_filled_1, "info@ablehands.com.au"),
                Pair(ion_location, "30 Ingham Street\nCapalaba QLD 4157"),
            )
        }

        const val locationUrl = "https://maps.app.goo.gl/ni6iWnM5eC9up5Wo9"

        // iStock images
        const val imagemain = "1407581633.png"
        const val imagemain1 = "1351793636.png"
        const val imagemain1mobile = "1351793636-mobile.png"
        const val imagemainmobile = "1407581633-mobile.png"
        const val image_4 = "1053564580.png"
        const val image_5 = "1349910331.png"
        const val image_5_small = "1349910331-mobile.png"
        const val image_6 = "1290205282.png"
        const val image_7 = "1435013460.png"
        const val image_9 = "1367806311.png"
        const val image_8_1 = "1337208889.png"
        const val image_8_2 = "1565967923.png"

        const val formspree = "https://formspree.io/f/mbjnyevn"
    }
}

object Content {
    const val about_us_1 =
        "Able Hands Support Services is a registered NDIS provider with a team of dedicated registered nurses and experienced disability support workers in Queensland, Australia."
    const val about_us_2 =
        "We provide a range of disability and aged care services across Brisbane and surrounding regions. AHS aims to empower our participants to live happily and independently by providing a range of capacity and skill-building programs and individual supports that are bespoke to meet the unique needs of our participants."
    const val about_us_3 =
        "Our approach is centred around understanding and meeting the unique needs of each person we support. We believe in the power of person-centred care and work closely with our participants to develop personalised support plans that address their specific goals and aspirations."
    const val about_us_4 =
        "Our friendly, professional staff listen to your concerns, collaborate, and plan programs and services that foster growth, skill building and overall well-being."
    val missions = listOf(
        "⦁ To empower, encourage and enable people with disabilities to enhance their quality of life with dignity and respect.",
        "⦁ To evaluate and exceed stakeholders' expectations.",
        "⦁ To provide care focused on the holistic well-being of an individual.",
        "Able Hands Support Service's vision is to create a resilient and empowered community in participation to support people with disabilities to live a great life with choice.",
        "Empowerment, Dignity, Respect, Trust, integrity and Innovation."
    )

    const val number = "+61 451120279"
    const val email1 = "info@ablehands.com.au"
    const val email2 = "contact@ablehands.com.au"

    val silProvide = listOf(
        "⦁ 24/7 support with experienced support workers/registered nurses.",
        "⦁ Medication management and administration.",
        "⦁ Help with personal care activities.",
        "⦁ Support with daily living skills such as preparing meals, cleaning and cooking etc.",
        "⦁ Support for appointments, including transportation.",
        "⦁ Support with community access such as visiting family, attending social activities, etc."
    )

    val silDes = listOf(
        "We provide support and care in SIL that helps you with daily life in your own house or supported house. We can help you with personal care activities like showering and dressing, help with cooking meals, shopping for groceries, medication management and administration, keeping your home safe and tidy or helping to get to and from appointments.",
        "AHSS provides participants with higher support needs, such as overnight support, 24/7 care, person-to-person work provided by a support worker, or significant help throughout the day. We provide help and supervision of day-to-day tasks to develop the skills of an individual so they can live as independently as possible. These are supports provided to an NDIS participant in their home and can be in a shared or individual living arrangement."
    )

    val dailyPerCareAndDomTasksDes = listOf(
        "Able Hands Support Services provides home-based care services for people who live with disabilities. We take pride in delivering you a choice of services and support to suit your needs and goals. Our dedicated, experienced, friendly staff will assist you with all aspects of daily living, personal care and home tasks."
    )

    val homeSupportServices = listOf(
        "Meal preparation+We can prepare delicious and nutritious homemade meals using ingredients and recipes you enjoy.",
        "Garden maintenance+We can assist you with lawn-moving services for your garden and other gardening work.",
        "Domestic services+We can assist you with light domestic cleaning, laundry and changing bedsheets.",
        "Sleepover support+Our trained staff can stay in your home to provide the support you may require overnight.",
        "Personal care+We can assist you with showering, toileting, dressing, personal grooming, and mobility support such as hoist transfers and getting in and out of bed.",
    )

    val socialActivitiesAndCommunityAccess = listOf(
        "⦁ Support with individual life skills development and training, including catching public transport.",
        "⦁ Developing skills for community support in attending social and recreational activities.",
        "⦁ Train participants in groups to increase their independence in daily personal activities.",
        "⦁ Provide support and assistance with shopping, appointments, and leisure activities."
    )

    val transportArrangements = listOf(
        "We offer diverse care-assisted transport arrangements to cater to your needs, including medical appointments and community care transfers. You can feel secure knowing your loved ones are safe with us.",
        "Transportation support services, including:",
        "⦁\tAttending the medical hospital and GP appointments",
        "⦁\tAssistance with shopping and groceries",
        "⦁\tAttending social activities in the community",
    )

    val nursing = listOf(
        "Whether recovering from an injury or illness or having a long-term condition, our nursing services give you the clinical nursing care you need to support your health and well-being.   We can provide next-day services in Brisbane and surrounding areas. If you require same-day or on-call nursing, please contact us to discuss your needs.",
        "Some care services can only be provided by Registered Nurses. If you have an injury/illness post-discharge from the hospital, which requires regular clinical attention, then in-home nursing care is the perfect way to rest and recover."
    )

    val nursingPoints = listOf(
        "⦁\tWound care and complex wound care.",
        "⦁\tStitch and staples removal.",
        "⦁\tCatheter care, including Indwelling and suprapubic catheter.",
        "⦁\tContinence assessment, education, reporting and management",
        "⦁\tPEG feeding, enteral feeding and nasogastric feeding.",
        "⦁\tMedication management, including oral, PR and injections.",
        "⦁\tRecovery support: Helping you regain your feet after an injury, illness or surgery. Receive short-term support while you recover from an illness or injury. "
    )

    val servicesExpanded = listOf(
        Pair("services", "Supported Independent Living (SIL)"),
        Pair("daily_personal_care_and_domestic_tasks", "Daily personal care and domestic tasks"),
        Pair("daily_personal_care_and_domestic_tasks", "Home support services"),
        Pair(
            "support_in_social_activities_and_community_access",
            "Support in social activities and community access"
        ),
        Pair(
            "assistance_with_travel_and_transport_arrangements",
            "Assistance with travel and transport arrangements"
        ),
        Pair("community_nursing_care", "Community nursing care"),
    )

    val aboutSub = listOf(
        AboutSub(
            "Our Mission",
            listOf(
                "⦁ To empower, encourage and enable people with disabilities to enhance their quality of life with dignity and respect.",
                "⦁ To evaluate and exceed stakeholders' expectations.",
                "⦁ To provide care focused on the holistic well-being of an individual."
            )
        ),
        AboutSub(
            "Our vision",
            listOf("Able Hands Support Service's vision is to create a resilient and empowered community in participation to support people with disabilities to live a great life with choice.")
        ),
        AboutSub(
            "Our Values",
            listOf("Empowerment, Dignity, Respect, Trust, integrity and Innovation.")
        )
    )

    val silPoints by lazy {
        listOf(
            Pair(
                "mingcute-time-line.svg",
                "24/7 support with experienced support workers/registered nurses."
            ),
            Pair("solar-bus-outline.svg", "Support for appointments, including transportation."),
            Pair(
                "ep-food.svg",
                "Support with daily living skills such as preparing meals, cleaning and cooking etc."
            ),
            Pair("healthicons-eco-care-outline.svg", "Help with personal care activities."),
            Pair(
                "fluent-briefcase-medical-16-regular.svg",
                "Medication management and administration."
            ),
            Pair(
                "fluent-mdl2-family.svg",
                "Support with community access such as visiting family, attending social activities, etc."
            )
        )
    }

    val assistanceWithTravelPoints by lazy {
        listOf(
            "⦁ Attending the medical hospital and GP appointments",
            "⦁ Assistance with shopping and groceries",
            "⦁ Attending social activities in the community"
        )
    }

    val tailoredPoints by lazy {
        listOf(
            "If you have been involved in an accident, suffered an injury or have been in hospital for an illness, you may need some support at home for a period of time whilst you get back on your feet.",
            "We work with a number of healthcare providers to support their clients or patients to get back on the road to recovery as quickly as possible.",
            "If you need help transitioning from the hospital to your home, you may need to access our short-term support services. From help with cleaning your home to attending appointments, we can support you."
        )
    }
}

data class AboutSub(
    val heading: String,
    val points: List<String>
)