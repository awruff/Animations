package com.github.awruff.animations

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.universal.UDesktop
import cc.polyfrost.oneconfig.utils.Notifications
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import com.github.awruff.animations.config.OldAnimationsSettings
import java.net.URI

@Mod(
    modid = Animations.MODID,
    name = Animations.NAME,
    version = Animations.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object Animations {
    const val MODID: String = "@MOD_ID@"
    const val NAME: String = "@MOD_NAME@"
    const val VERSION: String = "@MOD_VERSION@"

    @JvmField
    var isPatcherPresent: Boolean = false

    @JvmField
    var doTheFunnyDulkirThing = false

    @JvmField
    var oldDulkirMod: Boolean = false
    private var customCrosshair = false

    @JvmField
    var isDamageTintPresent: Boolean = false

    @JvmField
    var isItemPhysics: Boolean = false

    @JvmField
    var isNEUPresent: Boolean = false

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        OldAnimationsSettings.INSTANCE.preload()
        EventManager.INSTANCE.register(this)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        if (Loader.isModLoaded("dulkirmod")) {
            doTheFunnyDulkirThing = true
        }
        isPatcherPresent = Loader.isModLoaded("patcher")
        customCrosshair = Loader.isModLoaded("custom-crosshair-mod")
        isDamageTintPresent = Loader.isModLoaded("damagetint")
        isItemPhysics = Loader.isModLoaded("itemphysic")
        isNEUPresent = Loader.isModLoaded("notenoughupdates")
    }

    @Mod.EventHandler
    fun onLoad(event: FMLLoadCompleteEvent) {
        if (customCrosshair) {
            OldAnimationsSettings.smoothModelSneak = false
            OldAnimationsSettings.INSTANCE.save()
            Notifications.INSTANCE.send(
                "OverflowAnimations",
                "Custom Crosshair Mod has been detected, which is written poorly and causes major issues with OverflowAnimations. Disabling Smooth Model Sneak. If you want a better crosshair mod, please click here to use PolyCrosshair instead.",
                5000f,
                Runnable {
                    UDesktop.browse(URI("https://modrinth.com/mod/crosshair"))
                })
        }
    }

}