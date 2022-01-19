package Endss.content;

import Endss.content.*;
import Endss.world.draw.*;


import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class EndssBlocks implements ContentList {
  public static Block pressureFurnace;
  
  @Override
  public void load(){
    pressureFurnace = new GenericCrafter("pressure-furnace"){{
      requirements(Category.crafting, with(Items.silicon, 30, Items.metaglass, 40, Items.titanium, 80));
      size = 4;
      craftTime = 200f;
      craftEffect = Fx.smeltsmoke;
      hasPower = true;
      hasLiquids = false;
      ambientSound = Sounds.smelter;
      ambientSoundVolume = 0.07f;
      drawer = new DrawFurnace(Color.valueOf("ff9b59"));
      outputItem = new ItemStack(EndssItems.tolium, 2);
      consumes.items(with(Items.thorium, 2, Items.titanium, 4));
      consumes.power(1f);
    }};
  }
};