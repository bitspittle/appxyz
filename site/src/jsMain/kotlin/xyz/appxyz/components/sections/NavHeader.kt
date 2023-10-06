package xyz.appxyz.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.appxyz.ClickableStyle

val NavHeaderStyle by ComponentStyle.base {
    Modifier.fillMaxWidth().padding(1.cssRem)
}
//
//val NavItemStyle by ComponentStyle {
//    // Intentionally invert the header colors from the rest of the page
//    val linkColor = colorMode.toPalette().background
//
//    base { Modifier.margin(leftRight = 15.px) }
//
//    link { Modifier.color(linkColor) }
//    visited { Modifier.color(linkColor) }
//}
//
//val NavButtonVariant by NavItemStyle.addVariant {
//    base { Modifier.padding(0.px).borderRadius(50.percent) }
//}
//
//@Composable
//private fun NavLink(path: String, text: String) {
//    Link(path, text, NavItemStyle.toModifier(), UndecoratedLinkVariant)
//}

@Composable
fun NavHeader() {
//    var colorMode by ColorMode.currentState
    val ctx = rememberPageContext()
    Row(NavHeaderStyle.toModifier(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            "/kobweb-logo.png", "Kobweb Logo",
            ClickableStyle.toModifier()
                .height(2.cssRem)
                .onClick {
                    ctx.router.tryRoutingTo("/")
                }
        )
    }
//    Box(NavHeaderStyle.toModifier()) {
//        Row(
//            Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            NavLink("/", "HOME")
//            NavLink("/about", "ABOUT")
//            NavLink("/markdown", "MARKDOWN")
//            Spacer()
//
//            Button(
//                onClick = { colorMode = colorMode.opposite },
//                NavItemStyle.toModifier(NavButtonVariant)
//            ) {
//                Box(Modifier.margin(8.px)) {
//                    when (colorMode) {
//                        ColorMode.LIGHT -> FaMoon()
//                        ColorMode.DARK -> FaSun()
//                    }
//                }
//            }
//            Tooltip(ElementTarget.PreviousSibling, "Toggle color mode", placement = PopupPlacement.BottomRight)
//        }
//    }
}
