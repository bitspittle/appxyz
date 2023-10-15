package xyz.appxyz.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.defer.deferRender
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import xyz.appxyz.CircleButtonVariant
import xyz.appxyz.ClickableStyle
import xyz.appxyz.UncoloredButtonVariant
import xyz.appxyz.toSitePalette

val NavHeaderStyle by ComponentStyle.base {
    Modifier.fillMaxWidth().padding(1.cssRem)
}

@Composable
private fun NavLink(path: String, text: String) {
    Link(path, text, variant = UndecoratedLinkVariant.then(UncoloredLinkVariant))
}

@Composable
private fun MenuItems() {
    NavLink("/", "Home")
    NavLink("/about", "About")
}


@Composable
private fun ColorModeButton() {
    var colorMode by ColorMode.currentState
    Button(
        onClick = { colorMode = colorMode.opposite },
        variant = CircleButtonVariant.then(UncoloredButtonVariant)
    ) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }
    Tooltip(ElementTarget.PreviousSibling, "Toggle color mode", placement = PopupPlacement.BottomRight)
}

@Composable
private fun HamburgerButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        variant = CircleButtonVariant.then(UncoloredButtonVariant)
    ) {
        HamburgerIcon()
    }
}

@Composable
private fun CloseButton(onClick: () -> Unit) {
    Box(ClickableStyle.toModifier().onClick { onClick() }) {
        CloseIcon()
    }
}

val SideMenuSlideInAnim by Keyframes {
    from {
        Modifier.translateX(100.percent)
    }

    to {
        Modifier
    }
}

// Note: When the user closes the side menu, we don't immediately stop rendering it (at which point it would disappear
// abruptly). Instead, we start animating it out and only stop rendering it when the animation is complete.
enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun NavHeader() {
    Row(NavHeaderStyle.toModifier(), verticalAlignment = Alignment.CenterVertically) {
        A("https://kobweb.varabyte.com") {
            Image("/kobweb-logo.png", "Kobweb Logo", Modifier.height(2.cssRem))
        }

        Spacer()

        Row(Modifier.gap(1.5.cssRem).displayIfAtLeast(Breakpoint.MD), verticalAlignment = Alignment.CenterVertically) {
            MenuItems()
            ColorModeButton()
        }

        Row(Modifier.gap(0.5.cssRem).displayUntil(Breakpoint.MD), verticalAlignment = Alignment.CenterVertically) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

            ColorModeButton()
            HamburgerButton { menuState = SideMenuState.OPEN }

            deferRender {
                if (menuState != SideMenuState.CLOSED) {
                    Box(
                        Modifier
                            .position(Position.Fixed).top(0.px).left(0.px).right(0.px).bottom(0.px)
                            .onClick { menuState = menuState.close() },
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        key(menuState) { // Force recompute animation parameters when close button is clicked
                            Column(
                                Modifier
                                    .backgroundColor(ColorMode.current.toSitePalette().nearBackground)
                                    .animation(
                                        SideMenuSlideInAnim.toAnimation(
                                            duration = 200.ms,
                                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse
                                        )
                                    )
                                    .borderRadius(topLeft = 1.cssRem)
                                    .fillMaxHeight()
                                    .padding(left = 5.cssRem, top = 1.cssRem, right = 1.cssRem)
                                    .gap(1.5.cssRem)
                                    .onClick { it.stopPropagation() }
                                    .onAnimationEnd {
                                        if (menuState == SideMenuState.CLOSING) menuState = SideMenuState.CLOSED
                                    },
                                horizontalAlignment = Alignment.End
                            )
                            {
                                CloseButton { menuState = menuState.close() }
                                MenuItems()
                            }
                        }
                    }
                }
            }
        }
    }
}
