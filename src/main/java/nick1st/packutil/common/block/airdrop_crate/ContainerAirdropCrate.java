package nick1st.packutil.common.block.airdrop_crate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class ContainerAirdropCrate extends Container {
	private final int numRows;
	//private final TileEntityAirdropCrate crateInventory;
	private EntityPlayer player;
	private IInventory crate;

	public ContainerAirdropCrate(InventoryPlayer playerInv, TileEntityAirdropCrate crateInventory) {
		//this.crateInventory = crateInventory;
		this.crate = crateInventory;
		this.numRows = crateInventory.getSizeInventory() / 6;
		this.player = ((InventoryPlayer) playerInv).player;
		crateInventory.openInventory(this.player);
		for (int y = 0; y < numRows; ++y) {
			for (int x = 0; x < 6; x++) {
				this.addSlotToContainer(new Slot(crateInventory, x + y * 6, 35 + x * 18, 8 + y * 18));
			}
		}
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 74 + y * 18));
			}
		}
		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 132));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		//return this.crateInventory.isUsableByPlayer(playerIn);
		return this.crate.isUsableByPlayer(playerIn);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		//crateInventory.closeInventory(playerIn);
		this.crate.closeInventory(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack = slot.getStack();
			stack = itemStack.copy();
			if (index < this.numRows * 6) {
				if (!this.mergeItemStack(itemStack, this.numRows * 6, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemStack, 0, this.numRows * 6, false)) {
				return ItemStack.EMPTY;
			}
			if (itemStack.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return stack;
	}

	/*
	public TileEntityAirdropCrate getCrateInventory() {
		return this.crateInventory;
	}*/
}
