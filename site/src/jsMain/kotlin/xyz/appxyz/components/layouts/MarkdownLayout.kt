package xyz.appxyz.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.appxyz.nearBackground
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
            .backgroundColor(colorMode.toPalette().nearBackground)
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
