package megalonemo.goomod.items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.World;
import net.minecraftforge.server.command.TextComponentHelper;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class BlockItemInfo extends BlockItem {
    private String info = "";
    public BlockItemInfo(Block bruh, Item.Properties group,String infobruh) {
        super(bruh,group);
        info = infobruh;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        //ITextComponent bruh = new TextComponentString("");
        if(InputMappings.isKeyDown(Minecraft.getInstance().func_228018_at_().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("\u00A77"+info));
        }else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for more info"));
        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
