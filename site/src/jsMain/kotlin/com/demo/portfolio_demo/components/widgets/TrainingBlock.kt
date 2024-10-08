package com.demo.portfolio_demo.components.widgets

import androidx.compose.runtime.Composable
import com.demo.portfolio_demo.components.model.*
import com.demo.portfolio_demo.components.styles.*
import com.demo.portfolio_demo.utils.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun TrainingBlock(
    modifier: Modifier = Modifier,
    training: Trainings
) {
    val ctx = rememberPageContext()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
            .fontFamily(Res.Fonts.DM_SANS)
            .then(modifier)
            .cursor(Cursor.Pointer)
            .onClick { if (training.link.isNotEmpty()) ctx.router.navigateTo(training.link) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.px, style = LineStyle.Solid, color = when (ColorMode.current) {
                        ColorMode.LIGHT -> Res.Colors.FOOTER_COLOR_LIGHT
                        ColorMode.DARK -> Res.Colors.FOOTER_COLOR_LIGHT
                    }
                )
                .backgroundColor(Colors.White)
                .align(Alignment.TopCenter)
                .borderRadius(10.px)
                .margin(top = 0.35.cssRem)
                .padding(all = 24.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            SpanText(
                text = if(training.topic.isNotEmpty()) "Topic - ${training.topic}" else "",
                modifier = ResearchItemSubtitleStyle.toModifier()
                    .fillMaxWidth()
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.DimGray
                            ColorMode.DARK -> Colors.Gray
                        }
                    )
                    .fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = training.title,
                modifier = ResearchItemTitleStyle.toModifier()
                    .fillMaxWidth()
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Black
                            ColorMode.DARK -> Colors.White
                        }
                    )
                    .fontFamily(Res.Fonts.Space_Grotesk)
                    .fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = training.organisation,
                modifier = ResearchItemSubtitleStyle.toModifier()
                    .fillMaxWidth()
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        }
                    )
                    .fontWeight(FontWeight.Bold)
            )
        }

    }
}