package net.sakuramilk.TweakGNT;

import net.sakuramilk.util.SystemCommand;

public class Config {
    public static final String SC05D_BACKUP_DIR = "/TweakGNT/backup";
    public static final String SC03D_BACKUP_DIR = "/TweakGLTE/backup";

    public static final int DEVICE_UNKNOWN = 0;
    public static final int DEVICE_SC05D = 1;
    public static final int DEVICE_SC03D = 2;

    public static String getBackupDir() {
    	int device = checkDevice();
    	switch (device) {
    	case DEVICE_SC05D: return SC05D_BACKUP_DIR;
    	case DEVICE_SC03D: return SC03D_BACKUP_DIR;
    	}
    	return null;
    }

    public static int checkDevice() {
        String model = SystemCommand.get_prop("ro.product.model");
        String device = SystemCommand.get_prop("ro.product.device");
        if ("SC-05D".equals(model) || "quincydcm".equals(model)) {
        	return DEVICE_SC05D;
        }
        if ("SC-05D".equals(device) || "quincydcm".equals(device)) {
        	return DEVICE_SC05D;
        }
        if ("SC-03D".equals(model) || "celoxdcm".equals(model)) {
        	return DEVICE_SC03D;
        }
        if ("SC-03D".equals(device) || "celoxdcm".equals(device)) {
        	return DEVICE_SC03D;
        }
        return DEVICE_UNKNOWN;
    }
}
