package xyz.appxyz

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.SilkTheme
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.Palette
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.shifted

object SiteColors {
    class Brand {
        val primary: Color = Color.rgb(0x3C83EF)
        val accent: Color = Color.rgb(0xF3DB5B)
    }
    val brand = Brand()
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = Color.rgb(0xFAFAFA)
    ctx.theme.palettes.dark.background = Color.rgb(0x06080B)
}

/**
 * A useful color to apply to a container that should differentiate itself from the background but just a little.
 */
val Palette.nearBackground: Color get() {
    val colorMode = when (this) {
        SilkTheme.palettes.light -> ColorMode.LIGHT
        SilkTheme.palettes.dark -> ColorMode.DARK
        else -> error("Unexpected palette")
    }
    return background.shifted(colorMode, byPercent = 0.1f)
}
