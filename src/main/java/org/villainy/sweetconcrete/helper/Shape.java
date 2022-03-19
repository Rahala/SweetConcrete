package org.villainy.sweetconcrete.helper;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

public class Shape {
    public static AABB getPixeledAABB(double x0, double y0, double z0, double x1, double y1, double z1)
    { return new AABB(x0/16.0, y0/16.0, z0/16.0, x1/16.0, y1/16.0, z1/16.0); }

    public static AABB getRotatedAABB(AABB bb, Direction facing, boolean horizontalRotation)
    {
        if(!horizontalRotation) {
            switch(facing.get3DDataValue()) {
                case 0: return new AABB(1-bb.maxX, 1-bb.maxZ, 1-bb.minY, 1-bb.minX, 1-bb.minZ, 1-bb.minY); // D
                case 1: return new AABB(1-bb.maxX,   bb.minZ,   bb.minY, 1-bb.minX,   bb.maxZ,   bb.minY); // U
                case 2: return new AABB(1-bb.maxX,   bb.minY, 1-bb.maxZ, 1-bb.minX,   bb.minY, 1-bb.minZ); // N
                case 3: return new AABB(  bb.minX,   bb.minY,   bb.minZ,   bb.maxX,   bb.minY,   bb.maxZ); // S --> bb
                case 4: return new AABB(1-bb.maxZ,   bb.minY,   bb.minX, 1-bb.minZ,   bb.minY,   bb.maxX); // W
                case 5: return new AABB(  bb.minZ,   bb.minY, 1-bb.maxX,   bb.maxZ,   bb.minY, 1-bb.minX); // E
            }
        } else {
            switch(facing.get3DDataValue()) {
                case 0: return new AABB(  bb.minX, bb.minY,   bb.minZ,   bb.maxX, bb.minY,   bb.maxZ); // D --> bb
                case 1: return new AABB(  bb.minX, bb.minY,   bb.minZ,   bb.maxX, bb.minY,   bb.maxZ); // U --> bb
                case 2: return new AABB(  bb.minX, bb.minY,   bb.minZ,   bb.maxX, bb.minY,   bb.maxZ); // N --> bb
                case 3: return new AABB(1-bb.maxX, bb.minY, 1-bb.maxZ, 1-bb.minX, bb.minY, 1-bb.minZ); // S
                case 4: return new AABB(  bb.minZ, bb.minY, 1-bb.maxX,   bb.maxZ, bb.minY, 1-bb.minX); // W
                case 5: return new AABB(1-bb.maxZ, bb.minY,   bb.minX, 1-bb.minZ, bb.minY,   bb.maxX); // E
            }
        }
        return bb;
    }
}
