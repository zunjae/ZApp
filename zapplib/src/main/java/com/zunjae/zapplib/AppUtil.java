package com.zunjae.zapplib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by zunjae on 7/24/2017.
 */

public final class AppUtil {
    /**
     * Check if an app is installed
     *
     * @param packageName the Package Name we want to check
     */
    public static boolean hasAppInstalled(@NonNull Context context, @NonNull String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * Check if any app from a given list is installed. Will only return a boolean, not the app name
     *
     * @param packageNames a String[] containing app package names
     * @return a boolean which says if any of the given app is installed
     */
    public static boolean hasAnyAppInstalled(@NonNull Context context, @NonNull String... packageNames) {
        for (String packageName : packageNames) {
            if (hasAppInstalled(context, packageName)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static String getAnyAppInstalled(@NonNull Context context, @NonNull String... packageNames) {
        for (String packageName : packageNames) {
            if (hasAppInstalled(context, packageName)) {
                return packageName;
            }
        }
        return null;
    }

    /**
     * Check if an intent can be activated
     */
    public static boolean intentIsValid(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        final PackageManager manager = context.getPackageManager();
        List<ResolveInfo> activities = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }

    /**
     * Check if the device used by the user is an emulator
     */
    public static boolean deviceIsEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }

    /**
     * Return the version number, in int format
     *
     * @param context to access our package name
     * @return our version (Example: 3)
     * Will return -1 when failed
     */
    public static int versionNumberInt(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return Integer.parseInt(pInfo.versionName.replaceAll("\\.", ""));
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Return the version number, in String format
     *
     * @param context to access our package name
     * @return our version (Example: "3.9")
     */
    @Nullable
    public static String versionNumberString(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
