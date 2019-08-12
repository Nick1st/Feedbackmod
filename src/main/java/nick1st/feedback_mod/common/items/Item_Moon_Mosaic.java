//Idea by Samuel Miller (Modified)

package nick1st.feedback_mod.common.items;

import java.util.Iterator;
import java.util.List;

import net.minecraft.advancements.critereon.PlacedBlockTrigger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import nick1st.feedback_mod.FeedbackMod;
import nick1st.feedback_mod.Specification;
import nick1st.feedback_mod.client.tabs.Tabs;
import nick1st.feedback_mod.common.blocks.Blocks;

public class Item_Moon_Mosaic extends Item{
	
	public Item_Moon_Mosaic() {
		setCreativeTab(Tabs.itemtab);
		setRegistryName(new ResourceLocation(Specification.MODID, "moon_mosaic"));
		setUnlocalizedName("moon_mosaic");
		setMaxDamage(10);
		setMaxStackSize(1);
		setNoRepair();		
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		ItemStack stack = playerIn.getHeldItemOffhand();
		if (!worldIn.isRemote) {
			RayTraceResult result = rayTrace(playerIn, 80);
			if (result.typeOfHit == Type.MISS) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}
			BlockPos pos = result.getBlockPos();
			if(!(playerIn instanceof EntityPlayerMP)) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}
			EntityPlayerMP PlayerMp = (EntityPlayerMP) playerIn;
			int damage = stack.getItemDamage();
			PlayerMp.connection.setPlayerLocation(pos.getX(), pos.getY()+1, pos.getZ(), PlayerMp.rotationYaw, PlayerMp.rotationPitch);
			stack.setItemDamage(damage-1);}		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	public RayTraceResult rayTrace(EntityPlayer player, double blockReachDistance)
    {
        Vec3d vec3d = player.getPositionEyes(1.0F);
        Vec3d vec3d1 = player.getLook(1.0F);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return player.getEntityWorld().rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }
	
}
