#!/usr/bin/python
import jinja2
import os

MODID = 'sweetconcrete'
RESOURCES_DIR = '../src/main/resources/'
COLORS = [
    'red', 
    'yellow', 
    'green', 
    'black', 
    'brown', 
    'blue', 
    'white', 
    'orange', 
    'light_blue', 
    'magenta', 
    'pink', 
    'light_gray', 
    'lime',
    'cyan',
    'purple',
    'gray'
]

templateFilePath = jinja2.FileSystemLoader('./templates')
jinjaEnv = jinja2.Environment(loader=templateFilePath)

def generateBlock(name, blockType, templateFile, outputFile):
    template = jinjaEnv.get_template(templateFile)
    output = template.render(modid=MODID, name=name, blockType=blockType)
    print(output)
    outFileH = open(RESOURCES_DIR + outputFile, 'w')
    outFileH.write(output)
    outFileH.close()


def generateBlockAllColors(blockType, templateFile, outputFile):
    for color in COLORS:
            generateBlock(color + '_concrete', blockType, template, output % color)


def writeTagFile(filename, blocks):
    first = True
    with open(RESOURCES_DIR + 'data/minecraft/tags/' + filename, 'w') as writer:
        writer.write('{\n')
        writer.write('  "replace": false,\n')
        writer.write('  "values": [\n')
        for name in blocks:
            if not first:
                writer.write(',\n')
            else:
                first = False
            writer.write('    "sweetconcrete:' + name + '"')
        writer.write('\n  ]\n')
        writer.write('}\n')


def generateTags():
    walls = []
    slabs = []
    stairs = []

    for file in os.listdir(RESOURCES_DIR + '/assets/sweetconcrete/blockstates'):
        if '.json' in file:
            name = file.replace('.json', '')
            if '_wall' in name:
                walls.append(name)
            elif ('_slab' in name):
                slabs.append(name)
            elif '_stairs' in name:
                stairs.append(name)

    writeTagFile('items/walls.json', walls)
    writeTagFile('items/slabs.json', slabs)
    writeTagFile('items/stairs.json', stairs)

    writeTagFile('blocks/walls.json', walls)
    writeTagFile('blocks/slabs.json', slabs)
    writeTagFile('blocks/stairs.json', stairs)
            

# Slabs

slabAssets = {
    'slab/blockstate_slab.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_slab.json',
    'slab/model_block_slab_top.j2' : 'assets/sweetconcrete/models/block/%s_concrete_slab_top.json',
    'slab/model_block_slab.j2': 'assets/sweetconcrete/models/block/%s_concrete_slab.json',
    'slab/model_item_slab.j2': 'assets/sweetconcrete/models/item/%s_concrete_slab.json',
    'slab/recipe_slab.j2': 'data/sweetconcrete/recipes/%s_concrete_slab.json',
    'slab/loot_table_slab.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_slab.json'
}

stairsAssets = {
    'stairs/blockstate_stairs.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_stairs.json',
    'stairs/model_block_stairs.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs.json',
    'stairs/model_block_stairs_inner.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs_inner.json',
    'stairs/model_block_stairs_outer.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs_outer.json',
    'stairs/model_item_stairs.j2': 'assets/sweetconcrete/models/item/%s_concrete_stairs.json',
    'stairs/recipe_stairs.j2': 'data/sweetconcrete/recipes/%s_concrete_stairs.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_stairs.json'
}

wallAssets = {
    'wall/blockstate_wall.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_wall.json',
    'wall/model_block_wall_inventory.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_inventory.json',
    'wall/model_block_wall_post.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_post.json',
    'wall/model_block_wall_side.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_side.json',
    'wall/model_item_wall.j2': 'assets/sweetconcrete/models/item/%s_concrete_wall.json',
    'wall/recipe_wall.j2': 'data/sweetconcrete/recipes/%s_concrete_wall.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_wall.json'
}

blockTypes = {
    'slab' : slabAssets,
    'stairs': stairsAssets,
    'wall': wallAssets
}

for blockType, assets in blockTypes.items():
    for template, output in assets.items():
        generateBlockAllColors(blockType, template, output)

generateTags()
