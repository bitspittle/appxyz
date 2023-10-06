package xyz.appxyz

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted

class SitePalette(
    val brand: Brand,
) {
    class Brand(
        val primary: Color,
        val accent: Color,
    )
}

object SitePalettes {
    private val sitePalettes = mapOf(
        ColorMode.LIGHT to SitePalette(
            brand = SitePalette.Brand(
                primary = Color.rgb(0x3C83EF),
                accent = Color.rgb(0xF1C75A),
            )
        ),
        ColorMode.DARK to SitePalette(
            brand = SitePalette.Brand(
                primary = Color.rgb(0x3C83EF),
                accent = Color.rgb(0xF1C75A),
            )
        )
    )

    operator fun get(colorMode: ColorMode) = sitePalettes.getValue(colorMode)
}
fun ColorMode.toSitePalette() = SitePalettes[this]

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = Color.rgb(0xFAFAFA)
    ctx.theme.palettes.dark.background = Color.rgb(0x06080B)
}

/**
 * A useful modifier to apply to a container that should differentiate itself from the background but just a little.
 */
fun Modifier.shiftedBackgroundColor(colorMode: ColorMode) =
    this.backgroundColor(colorMode.toPalette().background.shifted(colorMode, byPercent = 0.05f))
