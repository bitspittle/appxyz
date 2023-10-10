package xyz.appxyz.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem
import xyz.appxyz.nearBackground
import xyz.appxyz.toSitePalette

val FooterStyle by ComponentStyle.base {
    Modifier
        .backgroundColor(colorMode.toPalette().nearBackground)
        .padding(topBottom = 1.5.cssRem)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(FooterStyle.toModifier().then(modifier), contentAlignment = Alignment.Center) {
        Row(Modifier.flexWrap(FlexWrap.Wrap)) {
            SpanText("Built with ")
            Link(
                "https://github.com/varabyte/kobweb",
                "Kobweb",
                Modifier.setVariable(ColorVar, ColorMode.current.toSitePalette().brand.primary),
                variant = UncoloredLinkVariant
            )
            SpanText(", template designed by ")
            Link(
                "https://ui-rocket.com",
                "UI Rocket",
                Modifier.setVariable(ColorVar, ColorMode.current.toSitePalette().brand.accent),
                variant = UncoloredLinkVariant
            )
            // Huge thanks to UI Rocket (https://ui-rocket.com) for putting this great template together for us! If you
            // like the design here and want help building your own site, please check them out at the link above!
        }
    }
}
