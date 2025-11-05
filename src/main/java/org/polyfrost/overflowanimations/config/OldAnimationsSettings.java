package org.polyfrost.overflowanimations.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import org.polyfrost.overflowanimations.OverflowAnimations;

public class OldAnimationsSettings extends Config {

    // 2D Items
    @Switch(
            name = "2D Dropped Items",
            description = "Renders items as sprites rather than as models.",
            subcategory = "2D Dropped Items"
    )
    public static boolean itemSprites = false;

    @Checkbox(name = "1.7 Item Sprite Colors",
            description = "Changes the colors of the dropped item sprites to be brighter just like in 1.7.",
            subcategory = "2D Dropped Items"
    )
    public static boolean itemSpritesColor = false;

    @Checkbox(
            name = "Remove Glint From Sprites",
            description = "This will disable the enchantment glint for both dropped items and projectiles. Only works with 2D items enabled.",
            subcategory = "2D Dropped Items"
    )
    public static boolean spritesGlint = false;

    @Switch(
            name = "Rotation Fix",
            description = "Allows dropped items to face the player properly without being stuck on the Y-Axis.",
            subcategory = "2D Dropped Items"
    )
    public static boolean rotationFix = true;

    // Smooth Sneaking

    @Switch(
            name = "1.7 Smoother Sneaking",
            description = "Smoothens the player camera to appear just like the 1.7 smoother sneaking camera.",
            subcategory = "Smooth Sneaking"
    )
    public static boolean smoothSneaking = true;

    @Switch(
            name = "1.7 Longer Unsneak",
            description = "Lengthens the player camera's speed to appear just like the 1.7 smoother sneaking camera.",
            subcategory = "Smooth Sneaking"
    )
    public static boolean longerUnsneak = true;

    @Switch(
            name = "1.7 Third Person Sneaking",
            description = "Synchronizes the player model's sneaking behavior to the eye height to replicate the same behavior in 1.7. Disable if incompatible with cosmetic mods",
            subcategory = "Smooth Sneaking"
    )
    public static boolean smoothModelSneak = true;

    // Interaction
    @Switch(
            name = "1.7 Block-Hitting Animation",
            description = "Re-enables the block-hitting animations.",
            subcategory = "Interaction"
    )
    public static boolean oldBlockhitting = true;

    @Dropdown(
            name = "Armor Damage Tint Style",
            description = "Applies a damage tint to armor. " +
                    "\"None\" will disable the effect on armor. " +
                    "\"1.7\" will apply the damage color using the 1.7 formula. " +
                    "\"1.8 (With Glint)\" will use the 1.8 formula AND account for the enchantment glint. " +
                    "\"1.8 (Without Glint)\" will use the 1.8 formula AND NOT account for the enchantment glint. " +
                    "\"1.8 (Orange Marshall) will use Orange Marshall's hit color.",
            options = {"None", "1.7", "1.8 (With Glint)", "1.8 (Without Glint)", "1.8 (Orange Marshall)"},
            subcategory = "Interaction"
    )
    public int armorDamageTintStyle = 3;

    @Dropdown(
            name = "1.7 Item Switching Animation",
            description = "Applies a damage tint to armor. " +
                    "\"None\" will disable the re-equip animation completely. " +
                    "\"1.7\" will use the 1.7 logic to display the re-equip animation. " +
                    "\"1.8\" will use the 1.8 logic to display the re-equip animation.",
            options = {"Disabled", "1.7", "1.8"},
            subcategory = "Interaction"
    )
    public int itemSwitchMode = 1;

    @Switch(
            name = "1.7 Miss Penalty Swing Animation",
            description = "This option is purely visual. During the miss penalty, the player's arm will still swing and show particles just like in 1.7.",
            subcategory = "Interaction"
    )
    public static boolean visualSwing = true;

    @Switch(
            name = "1.7 Punching During Usage",
            description = "Purely visual feature. Re-enables the ability to consume food or block a sword whilst punching a block.",
            subcategory = "Interaction"
    )
        public static boolean punching = true;

    @Checkbox(
            name = "1.7 Punch-During-Usage Particles",
            description = "Spawns Particles whilst Punching During Usage",
            subcategory = "Interaction"
    )
    public static boolean punchingParticles = true;

    // Positions
    @Switch(
            name = "1.7 First-Person Item Transformations",
            description = "Brings back the old item positions from 1.7.",
            subcategory = "Position"
    )
    public static boolean firstTransformations = true;

    @Switch(
            name = "1.7 Third-Person Item Transformations",
            description = "Brings back the old item positions from 1.7.",
            subcategory = "Position"
    )
    public static boolean thirdTransformations = true;

    @Checkbox(
            name = "1.7 First-Person Fishing Rod Position",
            description = "Brings back the old fishing rod position from 1.7.",
            subcategory = "Position"
    )
    public static boolean fishingRodPosition = true;

    @Checkbox(
            name = "1.7 First-Person Carpet Position",
            description = "Brings back the old carpet position from 1.7.",
            subcategory = "Position"
    )
    public static boolean firstPersonCarpetPosition = true;

    @Checkbox(
            name = "1.7 Third-Person Carpet Position",
            description = "Brings back the old carpet position from 1.7.",
            subcategory = "Position"
    )
    public static boolean thirdPersonCarpetPosition = true;

    @Switch(
            name = "1.7 Projectiles Transformations",
            description = "Mirrors and transforms projectiles so that they're facing the correct direction and in the same position as 1.7 or 1.9+.",
            subcategory = "Position"
    )
    public static boolean oldProjectiles = true;

    @Switch(
            name = "1.7 Third-Person Arm Block Position",
            description = "Brings back the old arm rotation while blocking from 1.7.",
            subcategory = "Position")
    public static boolean oldArmPosition = true;

    @Switch(
            name = "1.7 Third-Person Sword Block Position",
            description = "Brings back the old sword rotation while blocking from 1.7.",
            subcategory = "Position"
    )
    public static boolean thirdPersonBlock = true;

    @Switch(
            name = "1.7 XP Orbs Position",
            description = "Brings back the old XP Orbs position from 1.7.",
            subcategory = "Position"
    )
    public static boolean oldXPOrbs = true;

    @Switch(
            name = "1.7 Pickup Animation Position",
            description = "Brings back the old item pickup position from 1.7.",
            subcategory = "Position"
    )
    public static boolean oldPickup = true;

    // Enchantment Glint

    @Switch(
            name = "1.7 Enchantment Glint",
            description = "Brings back the old enchantment glint from 1.7.",
            subcategory = "Enchantment Glint"
    )
    public static boolean enchantmentGlint = true;

    @Switch(
            name = "1.7 GUI Enchantment Glint",
            description = "Brings back the old GUI enchantment glint from 1.7.",
            subcategory = "Enchantment Glint"
    )
    public static boolean enchantmentGlintGui = false;

    @Switch(
            name = "1.7 Third-Person Fishing Rod Cast Texture",
            description = "For some reason, in 1.7, when a fishing rod is cast, the third person texture becomes a stick rather than the fishing rod texture. This feature brings back that questionable feature.",
            subcategory = "Item Changes"
    )
    public static boolean fishingStick = false;

    // HUD

    @Switch(
            name = "1.7 Health Bar Flashing",
            description = "Disables the heart flashing texture while taking damage similar to 1.7.",
            subcategory = "HUD"
    )
    public static boolean oldHealth = true;

    @Dropdown(
            name = "Debug Menu Crosshair Style",
            description = "Allows you to choose between the 1.7, the vanilla 1.8, and the 1.12+ debug screen crosshair. 1.12+ Debug Screen Crosshair fixes Patcher's Parallax Fix Feature!",
            subcategory = "HUD",
            options = {"1.7", "1.8", "1.12+"}
    )
    public int debugCrosshairMode = 2;

    @Dropdown(
            name = "Debug Menu Style",
            description = "Reverts the debug menu to be aesthetically similar to 1.7",
            options = {"1.7", "1.8", "Disable Background"},
            subcategory = "HUD"
    )
    public int debugScreenMode = 1;

    @Dropdown(
            name = "Tab Menu Style",
            description = "Allows you to choose between the 1.7 tab menu, the 1.8 tab menu, and disabling the player heads in the tab menu.",
            options = {"1.7", "1.8", "Disable Heads"},
            subcategory = "HUD"
    )
    public int tabMode = 1;

    // Miscellaneous
    @Slider(
            name = "Item Re-equip Animation Speed",
            min = 0.1F, max = 1.0F,
            category = "Misc", subcategory = "Re-equip Animation",
            instant = true
    )
    public float reequipSpeed = 0.4F;

    @Switch(
            name = "Only Allow Re-equip Animation Upon Switching Slots",
            description = "Fixes the re-equip animation to only play when items slots are switched.",
            category = "Misc", subcategory = "Re-equip Animation"
    )
    public static boolean fixReequip = true;

    @Switch(
            name = "Disable Item Pickup Animation",
            description = "Removes the animation played when picking up items.",
            category = "Misc", subcategory = "Pickup Animation"
    )
    public static boolean disablePickup = false;

    @Slider(
            name = "Dropped Item Y Position",
            min = -1.5F, max = 2.5F,
            category = "Misc", subcategory = "Pickup Animation",
            instant = true
    )
    public float pickupPosition = 0.0F;

    @Switch(
            name = "Rod Line Position Based on FOV",
            description = "Includes the player's FOV when calculating the fishing rod cast line position.",
            category = "Misc", subcategory = "Fishing Rod Line"
    )
    public static boolean fixRod = true;

    @Slider(
            name = "Rod Line Thickness Slider",
            min = -100.0F, max = 100.0F,
            category = "Misc", subcategory = "Fishing Rod Line",
            instant = true
    )
    public float rodThickness = 0.0F;

    @Switch(
            name = "Block Breaking Fixes",
            description = "Resets block removing while using an item or when the player is out of range of a block.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean breakFix = false;

    @Switch(
            name = "Disable Hand View Sway",
            description = "Disables held item rotations/swaying while the player turns their head.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean oldItemRotations = false;

    @Switch(
            name = "Disable Potion Enchantment Glint",
            description = "Disables the enchantment glint from rendering on potions.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean potionGlint = false;

    @Switch(
            name = "Colored Potion Bottles",
            description = "Uses the potion overlay color as the color of the potion bottle.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean coloredBottles = false;

    @Switch(
            name = "Apply Damage Tint to Held Items",
            description = "Applies the damage tint to entity held items.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean damageHeldItems = false;

    @Switch(
            name = "Apply Damage Tint to Capes",
            description = "Applies the damage tint to capes.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean damageCape = false;

    @Checkbox(
            name = "Disable Drop Item Arm Swing in Chests",
            description = "Disables the arm swinging animation upon dropping items while in Chests.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean modernDropSwingFix = true;

    @Switch(
            name = "Disable Entity/Mob Third-Person Item Transformations",
            description = "Allows/Disallows mobs or entities to have third person item positions applied to them.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean entityTransforms = true;

    @Switch(
            name = "Disable swinging at the ground in Adventure Mode",
            description = "Allows/Disallows swinging at the ground in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventurePunching = false;

    @Switch(
            name = "Disable Punching During Usage in Adventure Mode",
            description = "Allows/Disallows the punching during usage feature in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventureBlockHit = false;

    @Checkbox(
            name = "Disable Punch-During-Usage Particles in Adventure Mode",
            description = "Allows/Disallows the particles played while punching during usage to appear while in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventureParticles = true;

    @Switch(
            name = "Disable Hurt Camera Shake",
            description = "Disables the camera damage shake.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean noHurtCam = false;

    @Switch(
            name = "Old Lunar/CheatBreaker Block-Hit Position",
            description = "Brings back the weird block-hitting position from older versions of Lunar Client or CheatBreaker!",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean lunarBlockhit = false;

    @Switch(
            name = "Old Lunar/CheatBreaker Item Positions",
            description = "Brings back the item positions from older versions of Lunar Client or CheatBreaker!",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean lunarPositions = false;

    @Switch(
            name = "Dinnerbone Mode Player-Only",
            description = "Allows the player to be completely upside down, just like Dinnerbone.",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean dinnerBoneMode = false;

    @Switch(
            name = "Dinnerbone Mode All Entities",
            description = "Makes all entities be upside down, just like Dinnerbone.",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean dinnerBoneModeEntities = false;

    @Switch(
            name = "Alpha/Indev Wavy Arms",
            description = "Brings back the wavy arms from Indev.",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean wackyArms = false;

    @Switch(
            name = "Allow Clicking While Using an Item",
            description = "This option is purely visual. Allows the player to swing while clicking and using an item.",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean fakeBlockHit = false;

    @Exclude public static final OldAnimationsSettings INSTANCE = new OldAnimationsSettings();

    public OldAnimationsSettings() {
        super(new Mod(OverflowAnimations.NAME, ModType.PVP), "overflowanimations.json");
        initialize();

        // Sprites
        addDependency("rotationFix", "itemSprites");
        addDependency("spritesGlint", "itemSprites");
        addDependency("itemSpritesColor", "itemSprites");
        // Interactions
        addDependency("punching", "oldBlockhitting");
        addDependency("punchingParticles", "oldBlockhitting");
        addDependency("adventureParticles", "oldBlockhitting");
        addDependency("adventurePunching", "oldBlockhitting");
        addDependency("adventureParticles", "punchingParticles");
        addDependency("punchingParticles", "punching");
        addDependency("adventureParticles", "punching");
        addDependency("adventurePunching", "punching");
        // Transformations
        addDependency("firstPersonCarpetPosition", "itemTransformations");
        addDependency("fixRod", "itemTransformations");
        addDependency("entityTransforms", "thirdTransformations");
        // Sneaking
        addDependency("longerUnsneak", "smoothSneaking");
    }
}
