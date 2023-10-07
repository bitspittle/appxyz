package xyz.appxyz.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import xyz.appxyz.CircleButtonVariant
import xyz.appxyz.ClickableStyle

val NavHeaderStyle by ComponentStyle.base {
    Modifier.fillMaxWidth().padding(topBottom = 1.cssRem)
}

@Composable
private fun NavLink(path: String, text: String) {
    Link(path, text, variant = UndecoratedLinkVariant.then(UncoloredLinkVariant))
}

@Composable
fun NavHeader() {
    val ctx = rememberPageContext()
    var colorMode by ColorMode.currentState
    Row(NavHeaderStyle.toModifier().gap(1.5.cssRem), verticalAlignment = Alignment.CenterVertically) {
        Image(
            "/kobweb-logo.png", "Kobweb Logo",
            ClickableStyle.toModifier()
                .height(2.cssRem)
                .onClick {
                    ctx.router.navigateTo("https://kobweb.varabyte.com")
                }
        )
        Spacer()
        NavLink("/", "Home")
        NavLink("/about", "About")
        Button(
            onClick = { colorMode = colorMode.opposite },
            variant = CircleButtonVariant
        ) {
            if (colorMode.isLight) MoonIcon() else SunIcon()
        }
        Tooltip(ElementTarget.PreviousSibling, "Toggle color mode", placement = PopupPlacement.BottomRight)
    }
}
