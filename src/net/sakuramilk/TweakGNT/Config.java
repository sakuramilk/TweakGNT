package net.sakuramilk.TweakGNT;

import net.sakuramilk.util.SystemCommand;

public class Config {
    public static final String TGNT_BACKUP_DIR = "/TweakGNT/backup";
    
    public static boolean checkDevice() {
        String model = SystemCommand.get_prop("ro.product.model");
        String device = SystemCommand.get_prop("ro.product.device");
        if ("SC-05D".equals(model) || "quincydcm".equals(model)) {
        	return true;
        }
        if ("SC-05D".equals(device) || "quincydcm".equals(device)) {
        	return true;
        }
        return false;
    }
}
