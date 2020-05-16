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
    buttons = []
    pressurePlates = []
    fences = []

    for file in os.listdir(RESOURCES_DIR + '/assets/sweetconcrete/blockstates'):
        if '.json' in file:
            name = file.replace('.json', '')
            if '_wall' in name and 'sign' not in name:
                walls.append(name)
            elif ('_slab' in name and 'vertical' not in name):
                slabs.append(name)
            elif '_stairs' in name:
                stairs.append(name)
            elif '_button' in name:
                buttons.append(name)
            elif '_fence' in name:
                fences.append(name)

    writeTagFile('items/walls.json', walls)
    writeTagFile('items/slabs.json', slabs)
    writeTagFile('items/stairs.json', stairs)
    writeTagFile('items/buttons.json', buttons)
    writeTagFile('items/wooden_pressure_plates.json', pressurePlates)
    writeTagFile('items/fences.json', fences)


    writeTagFile('blocks/walls.json', walls)
    writeTagFile('blocks/slabs.json', slabs)
    writeTagFile('blocks/stairs.json', stairs)
    writeTagFile('blocks/buttons.json', buttons)
    writeTagFile('blocks/wooden_pressure_plates.json', pressurePlates)
    writeTagFile('blocks/fences.json', fences)
            

# Slabs

slabAssets = {
    'slab/blockstate_slab.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_slab.json',
    'slab/model_block_slab_top.j2' : 'assets/sweetconcrete/models/block/%s_concrete_slab_top.json',
    'slab/model_block_slab.j2': 'assets/sweetconcrete/models/block/%s_concrete_slab.json',
    'slab/model_item_slab.j2': 'assets/sweetconcrete/models/item/%s_concrete_slab.json',
    'slab/recipe_slab.j2': 'data/sweetconcrete/recipes/%s_concrete_slab.json',
    'slab/recipe_slab_stonecutter.j2': 'data/sweetconcrete/recipes/%s_concrete_slab_stonecutter.json',
    'slab/loot_table_slab.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_slab.json'
}

stairsAssets = {
    'stairs/blockstate_stairs.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_stairs.json',
    'stairs/model_block_stairs.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs.json',
    'stairs/model_block_stairs_inner.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs_inner.json',
    'stairs/model_block_stairs_outer.j2': 'assets/sweetconcrete/models/block/%s_concrete_stairs_outer.json',
    'stairs/model_item_stairs.j2': 'assets/sweetconcrete/models/item/%s_concrete_stairs.json',
    'stairs/recipe_stairs.j2': 'data/sweetconcrete/recipes/%s_concrete_stairs.json',
    'stairs/recipe_stairs_stonecutter.j2': 'data/sweetconcrete/recipes/%s_concrete_stairs_stonecutter.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_stairs.json'
}

wallAssets = {
    'wall/blockstate_wall.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_wall.json',
    'wall/model_block_wall_inventory.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_inventory.json',
    'wall/model_block_wall_post.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_post.json',
    'wall/model_block_wall_side.j2': 'assets/sweetconcrete/models/block/%s_concrete_wall_side.json',
    'wall/model_item_wall.j2': 'assets/sweetconcrete/models/item/%s_concrete_wall.json',
    'wall/recipe_wall.j2': 'data/sweetconcrete/recipes/%s_concrete_wall.json',
    'wall/recipe_wall_stonecutter.j2': 'data/sweetconcrete/recipes/%s_concrete_wall_stonecutter.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_wall.json'
}

fenceAssets = {
    'fence/blockstate_fence.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_fence.json',
    'fence/model_block_fence_inventory.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_inventory.json',
    'fence/model_block_fence_post.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_post.json',
    'fence/model_block_fence_side.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_side.json',
    'fence/model_item_fence.j2': 'assets/sweetconcrete/models/item/%s_concrete_fence.json',
    'fence/recipe_fence.j2': 'data/sweetconcrete/recipes/%s_concrete_fence.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_fence.json'
}

fenceGateAssets = {
    'fence_gate/blockstate_fence_gate.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_fence_gate.json',
    'fence_gate/model_block_fence_gate.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_gate.json',
    'fence_gate/model_block_fence_gate_open.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_gate_open.json',
    'fence_gate/model_block_fence_gate_wall.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_gate_wall.json',
    'fence_gate/model_block_fence_gate_wall_open.j2': 'assets/sweetconcrete/models/block/%s_concrete_fence_gate_wall_open.json',
    'fence_gate/model_item_fence_gate.j2': 'assets/sweetconcrete/models/item/%s_concrete_fence_gate.json',
    'fence_gate/recipe_fence_gate.j2': 'data/sweetconcrete/recipes/%s_concrete_fence_gate.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_fence_gate.json'
}

ladderAssets = {
    'ladder/blockstate_ladder.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_ladder.json',
    'ladder/model_block_ladder.j2': 'assets/sweetconcrete/models/block/%s_concrete_ladder.json',
    'ladder/model_item_ladder.j2': 'assets/sweetconcrete/models/item/%s_concrete_ladder.json',
    'ladder/recipe_ladder.j2': 'data/sweetconcrete/recipes/%s_concrete_ladder.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_ladder.json'
}

buttonAssets = {
    'button/blockstate_button.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_button.json',
    'button/model_block_button_inventory.j2': 'assets/sweetconcrete/models/block/%s_concrete_button_inventory.json',
    'button/model_block_button_pressed.j2': 'assets/sweetconcrete/models/block/%s_concrete_button_pressed.json',
    'button/model_block_button.j2': 'assets/sweetconcrete/models/block/%s_concrete_button.json',
    'button/model_item_button.j2': 'assets/sweetconcrete/models/item/%s_concrete_button.json',
    'button/recipe_button.j2': 'data/sweetconcrete/recipes/%s_concrete_button.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_button.json'
}

leverAssets = {
    'lever/blockstate_lever.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_lever.json',
    'lever/model_block_lever.j2': 'assets/sweetconcrete/models/block/%s_concrete_lever.json',
    'lever/model_block_lever_on.j2': 'assets/sweetconcrete/models/block/%s_concrete_lever_on.json',
    'lever/model_block_lever_inventory.j2': 'assets/sweetconcrete/models/block/%s_concrete_lever_inventory.json',
    'lever/model_item_lever.j2': 'assets/sweetconcrete/models/item/%s_concrete_lever.json',
    'lever/recipe_lever.j2': 'data/sweetconcrete/recipes/%s_concrete_lever.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_lever.json'
}

pressurePlateAssets = {
    'pressure_plate/blockstate_pressure_plate.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_pressure_plate.json',
    'pressure_plate/model_block_pressure_plate_down.j2': 'assets/sweetconcrete/models/block/%s_concrete_pressure_plate_down.json',
    'pressure_plate/model_block_pressure_plate.j2': 'assets/sweetconcrete/models/block/%s_concrete_pressure_plate.json',
    'pressure_plate/model_item_pressure_plate.j2': 'assets/sweetconcrete/models/item/%s_concrete_pressure_plate.json',
    'pressure_plate/recipe_pressure_plate.j2': 'data/sweetconcrete/recipes/%s_concrete_pressure_plate.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_pressure_plate.json'
}

signAssets = {
    'sign/blockstate_sign.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_sign.json',
    'sign/model_block_sign.j2' : 'assets/sweetconcrete/models/block/%s_concrete_sign.json',
    'sign/model_item_sign.j2': 'assets/sweetconcrete/models/item/%s_concrete_sign.json',
    'sign/recipe_sign.j2': 'data/sweetconcrete/recipes/%s_concrete_sign.json',
    'loot_table_generic.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_sign.json'
}

cakeAssets = {
    'cake/blockstate_cake.j2' : 'assets/sweetconcrete/blockstates/concrete_cake.json',
    'cake/model_block_cake.j2': 'assets/sweetconcrete/models/block/concrete_cake.json',
    'cake/model_item_cake.j2': 'assets/sweetconcrete/models/item/concrete_cake.json',
    'cake/recipe_cake.j2': 'data/sweetconcrete/recipes/concrete_cake.json',
}

verticalSlabAssets = {
    'vertical_slab/blockstate_vertical_slab.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_vertical_slab.json',
    'vertical_slab/model_block_vertical_slab.j2': 'assets/sweetconcrete/models/block/%s_concrete_vertical_slab.json',
    'vertical_slab/model_item_vertical_slab.j2': 'assets/sweetconcrete/models/item/%s_concrete_vertical_slab.json',
    'vertical_slab/recipe_vertical_slab.j2': 'data/sweetconcrete/recipes/%s_concrete_vertical_slab.json',
    'vertical_slab/recipe_vertical_slab_stonecutter.j2': 'data/sweetconcrete/recipes/%s_concrete_vertical_slab_stonecutter.json',
    'vertical_slab/loot_table_vertical_slab.j2': 'data/sweetconcrete/loot_tables/blocks/%s_concrete_vertical_slab.json'
}

powderLayerAssets = {
    'powder_layer/blockstate_powder_layer.j2' : 'assets/sweetconcrete/blockstates/%s_concrete_powder_layer.json',
    'powder_layer/model_block_powder_layer2.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer2.json',
    'powder_layer/model_block_powder_layer4.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer4.json',
    'powder_layer/model_block_powder_layer6.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer6.json',
    'powder_layer/model_block_powder_layer8.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer8.json',
    'powder_layer/model_block_powder_layer10.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer10.json',
    'powder_layer/model_block_powder_layer12.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer12.json',
    'powder_layer/model_block_powder_layer14.j2' : 'assets/sweetconcrete/models/block/%s_concrete_powder_layer14.json',
    'powder_layer/model_item_powder_layer.j2' : 'assets/sweetconcrete/models/item/%s_concrete_powder_layer.json',
    'powder_layer/recipe_powder_layer.j2': 'data/sweetconcrete/recipes/%s_concrete_powder_layer.json',
    'powder_layer/loot_table_powder_layer.j2' : 'data/sweetconcrete/loot_tables/blocks/%s_concrete_powder_layer.json',
}

blockTypes = {
    'slab' : slabAssets,
    'stairs': stairsAssets,
    'wall': wallAssets,
    'button': buttonAssets,
    'lever': leverAssets,
    'pressure_plate': pressurePlateAssets,
    'fence': fenceAssets,
    'fence_gate': fenceGateAssets,
    'ladder': ladderAssets,
    'sign': signAssets,
    'vertical_slab': verticalSlabAssets,
    'powder_layer': powderLayerAssets,
}

uncoloredBlockTypes = {
    'cake': cakeAssets,
}


# Colored variants
for blockType, assets in blockTypes.items():
    for template, output in assets.items():
        generateBlockAllColors(blockType, template, output)

# Uncolored variants
for blockType, assets in uncoloredBlockTypes.items():
    for template, output in assets.items():
        generateBlock("concrete_" + blockType, blockType, template, output)


generateTags()
