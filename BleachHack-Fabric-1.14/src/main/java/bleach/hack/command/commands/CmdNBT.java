/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/bleachhack-1.14/).
 * Copyright (c) 2019 Bleach.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bleach.hack.command.commands;

import bleach.hack.command.Command;
import bleach.hack.command.CommandManager;
import bleach.hack.utils.BleachLogger;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringNbtReader;

public class CmdNBT extends Command {

    @Override
    public String getAlias() {
        return "nbt";
    }

    @Override
    public String getDescription() {
        return "NBT stuff";
    }

    @Override
    public String getSyntax() {
        return "nbt [get/copy/set/wipe] <nbt>";
    }

    @Override
    public void onCommand(String command, String[] args) throws Exception {
        if (args[0].isEmpty()) {
            BleachLogger.errorMessage("Invalid Syntax!");
            BleachLogger.infoMessage(CommandManager.prefix + getSyntax());
            return;
        }
        ItemStack item = mc.player.inventory.getMainHandStack();

        if (args[0].equalsIgnoreCase("get")) {
        	BleachLogger.infoMessage("§6§lNBT:\n" + item.getTag() + "");
        } else if (args[0].equalsIgnoreCase("copy")) {
            mc.keyboard.setClipboard(item.getTag() + "");
            BleachLogger.infoMessage("§6Copied\n§f" + (item.getTag() + "\n") + "§6to clipboard.");
        } else if (args[0].equalsIgnoreCase("set")) {
            try {
                if (args[1].isEmpty()) {
                    BleachLogger.errorMessage("Invalid Syntax!");
                    BleachLogger.infoMessage(CommandManager.prefix + getSyntax());
                    return;
                }
                item.setTag(StringNbtReader.parse(args[1]));
                BleachLogger.infoMessage("§6Set NBT of " + item.getItem().getName() + "to\n§f" + (item.getTag()));
            } catch (Exception e) {
                BleachLogger.errorMessage("Invalid Syntax!");
                BleachLogger.infoMessage(getSyntax());
            }
        } else if (args[0].equalsIgnoreCase("wipe")) {
            item.setTag(new CompoundTag());
        }

    }

}
