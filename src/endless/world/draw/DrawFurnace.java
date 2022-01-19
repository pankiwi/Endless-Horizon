package Endss.world.draw;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;

import mindustry.world.draw.*;

public class DrawFurnace extends DrawBlock {
  public Color flameColor = Color.valueOf("ffc999");
  public TextureRegion top, heat, bottom;
  public float flameSinScl = 8f, flameSclMag = 0.6f;
  public float lightRadius = 60f, lightSinScl = 10f, lightSinMag = 10f, lightAlpha = 0.67;
  
  public DrawFurnace(){
  }
  
  public DrawFurnace(Color flameColor){
    flameColor = flameColor;
  }
  
  @Override
  public void load(Block block){
    top = Core.atlas.find(block.name + "-top");
    heat = Core.atlas.find(block.name + "-heat");
    bottom = Core.atlas.find(block.name + "-bottom");
  }
  
  @Override
  public void draw(GenericCrafter.GenericCrafterBuild build){
    Draw.rect(bottom, build.x, build.y);
    
    if(build.warmup > 0 && flameColor.a > 0.000f){
      Draw.blend(Blending.additive);
      Draw.color(flameColor);
      Draw.alpha((1 - flameSclMag) + Mathf.absin(build.totalProgress, flameSinScl, flameSclMag));
      Draw.rect(heat, build.x, build.y);
      Draw.blend();
      Draw.reset();
    }
    
    Draw.rect(build.block.region, build.x, build.y);
    
    Draw.rect(top, build.x, build.y);
  }
  
  @Override
  public void drawLight(GenericCrafterBuild build){
    Drawf.light(build.team, build.x, build.y, (lightRadius + Mathf.absin(lightSinScl, lightSinMag)) * build.warmup * build.block.size, flameColor, lightAlpha);
  }
  @Override
  public TextureRegion[] icons(Block block){
    return new TextureRegion[]{bottom, block.region, top};
  }
 
};