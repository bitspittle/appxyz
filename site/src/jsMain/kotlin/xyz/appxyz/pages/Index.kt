package xyz.appxyz.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.dom.svg.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import xyz.appxyz.HeadlineTextStyle
import xyz.appxyz.SiteColors
import xyz.appxyz.SubheadlineTextStyle
import xyz.appxyz.components.layouts.PageLayout


private val GridCellColorVar by StyleVariable<Color>()
val GridCellStyle by ComponentStyle.base {
    Modifier
        .backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value())
        .borderRadius(1.cssRem)
}

@Composable
private fun GridCell(color: Color, row: Int, column: Int, width: Int? = null, height: Int? = null) {
    Div(
        GridCellStyle.toModifier()
            .setVariable(GridCellColorVar, color)
            .gridItem(row, column, width, height)
            .toAttrs()
    )
}

@Composable
private fun SvgBlurredEllipse(color: Color, modifier: Modifier) {
    Svg(attrs = modifier.filter(blur(100.px)).toAttrs()) {
        Ellipse {
            cx(50.percent)
            cy(50.percent)
            rx(50.percent)
            ry(50.percent)
            fill(color)
        }
    }
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(Modifier.fillMaxWidth().gap(2.cssRem).margin(top = 20.vh)) {
            Box {
                SvgBlurredEllipse(SiteColors.brand.accent, Modifier.align(Alignment.TopEnd))
                SvgBlurredEllipse(SiteColors.brand.primary, Modifier.align(Alignment.BottomStart))

                Column(Modifier.gap(2.cssRem)) {
                    Div(HeadlineTextStyle.toAttrs()) {
                        SpanText("Use this template as your starting point for ")
                        SpanText("Kobweb", Modifier.color(SiteColors.brand.accent))
                    }

                    Div(SubheadlineTextStyle.toAttrs()) {
                        SpanText("You can read the ")
                        Link("/about", "About")
                        SpanText(" page for more information.")
                    }

                    val ctx = rememberPageContext()
                    Button(onClick = {
                        ctx.router.tryRoutingTo("/about")
                    }, colorScheme = ColorSchemes.Blue) {
                        Text("This could be your CTA")
                    }
                    Tooltip(ElementTarget.PreviousSibling, "A CTA is a call to action")
                }
            }

            Div(Modifier
                .displayIfAtLeast(Breakpoint.MD)
                .grid {
                    rows { repeat(3) { size(1.fr) } }
                    columns { repeat(5) { size(1.fr) } }
                }
                .gap(0.5.cssRem)
                .width(70.cssRem)
                .height(18.cssRem)
                .toAttrs()
            ) {
                GridCell(SiteColors.brand.primary, 1, 1, 2, 2)
                GridCell(ColorSchemes.Monochrome._600, 1, 3)
                GridCell(ColorSchemes.Monochrome._100, 1, 4, width = 2)
                GridCell(SiteColors.brand.accent, 2, 3, width = 2)
                GridCell(ColorSchemes.Monochrome._300, 2, 5)
                GridCell(ColorSchemes.Monochrome._800, 3, 1, width = 5)
            }
        }
    }
}
