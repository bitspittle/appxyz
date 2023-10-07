package xyz.appxyz.components.layouts

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import xyz.appxyz.components.sections.Footer
import xyz.appxyz.components.sections.NavHeader
import xyz.appxyz.shiftedBackgroundColor
import xyz.appxyz.toSitePalette

val MarkdownStyle by ComponentStyle {
    base {
        Modifier
            .padding(top = 2.cssRem)
            .lineHeight(1.5.cssRem)
    }

    // The following rules apply to all descendant elements, indicated by the leading space.
    // When you use `cssRule`, the name of this style is prefixed in front of it.
    // See also: https://developer.mozilla.org/en-US/docs/Web/CSS/Descendant_combinator

    cssRule(" h2") {
        Modifier.color(colorMode.toSitePalette().brand.accent).margin(topBottom = 1.cssRem)
    }

    cssRule(" h3") {
        Modifier.color(colorMode.toSitePalette().brand.accent).margin(topBottom = 0.8.cssRem)
    }

    cssRule(" p") {
        Modifier.margin(bottom = 0.8.cssRem)
    }

    cssRule(" li,ol,ul") {
        Modifier.margin(bottom = 0.25.cssRem)
    }

    cssRule(" code") {
        Modifier.opacity(0.8f)
    }

    cssRule(" pre") {
        Modifier
            .margin(top = 0.5.cssRem, bottom = 2.cssRem)
            .fillMaxWidth()
    }
    cssRule(" pre > code") {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .fillMaxWidth()
            .shiftedBackgroundColor(colorMode)
            .border(1.px, LineStyle.Solid, colorMode.toPalette().color)
            .borderRadius(0.25.cssRem)
            .padding(0.5.cssRem)
            .fontSize(1.cssRem)
    }
}

@Composable
fun MarkdownLayout(title: String, content: @Composable () -> Unit) {
    PageLayout(title) {
        Column(MarkdownStyle.toModifier().fillMaxSize(), horizontalAlignment = Alignment.Start) {
            content()
        }
    }
}
