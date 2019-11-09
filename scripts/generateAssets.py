#!/usr/bin/python
import jinja2

MODID = 'sweetconcrete'
OUTPUT_PATH = '../src/main/resources/'
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

def generate(name, blockType, templateFile, outputFile):
    template = jinjaEnv.get_template(templateFile)
    output = template.render(modid=MODID, name=name, blockType=blockType)
    print(output)
    outFileH = open(OUTPUT_PATH + outputFile, 'w')
    outFileH.write(output)
    outFileH.close()

def generateAllColors(blockType, templateFile, outputFile):
    for color in COLORS:
            generate(color + '_concrete', blockType, template, output % color)

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

blockTypes = {
    'slab' : slabAssets,
    'stairs': stairsAssets
}

for blockType, assets in blockTypes.items():
    for template, output in assets.items():
        generateAllColors(blockType, template, output)
