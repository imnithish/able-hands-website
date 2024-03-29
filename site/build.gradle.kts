/*
 * Created by Nitheesh AG on 11, 2, 2024
 * Copyright (C) 2024 Able hands support services Pty Ltd. - All Rights Reserved
 *
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited.
 */

import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.ablehands.supportservices"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Disability support and community nursing services")
            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(
                    rel = "preconnect",
                    href = "https://fonts.gstatic.com"
                ) { attributes["crossorigin"] = "" }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Lexend:wght@300;400;500;600;700&family=Libre+Bodoni:wght@400;500;600;700&display=swap",
                    rel = "stylesheet"
                )
                script {
                    src =
                        "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("supportservices")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.silk.icons.fa)
                // implementation(libs.kobwebx.markdown)
            }
        }
    }
}
