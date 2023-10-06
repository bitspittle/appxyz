package xyz.appxyz

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

val PrimaryColorStyle by ComponentStyle.base {
    Modifier.color(colorMode.toSitePalette().brand.primary)
}

val AccentColorStyle by ComponentStyle.base {
    Modifier.color(colorMode.toSitePalette().brand.accent)
}

val HeadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontSize(3.cssRem)
        .lineHeight(120.percent)
        .textAlign(TextAlign.Start)
}

val SubheadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontSize(1.cssRem)
        .textAlign(TextAlign.Start)
        .opacity(0.8f)
}

/**
 * A style to indicate that a component can be clicked on.
 *
 * If you use this style, you should probably also register an `onClick` modifier.
 */
val ClickableStyle by ComponentStyle.base(extraModifiers = Modifier.tabIndex(0)) {
    Modifier.cursor(Cursor.Pointer)
}
