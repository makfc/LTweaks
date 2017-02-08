package li.lingfeng.ltweaks.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;

import li.lingfeng.ltweaks.MyApplication;
import li.lingfeng.ltweaks.prefs.PackageNames;

/**
 * Created by smallville on 2017/1/25.
 */

public class ContextUtils {

    public static Context createPackageContext(String packageName) {
        try {
            return MyApplication.instance().createPackageContext(packageName, Context.CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e("Can't create context for package " + packageName + ", " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static int getResId(String name, String type) {
        return getResId(name, type, MyApplication.instance());
    }

    public static int getResId(String name, String type, Context context) {
        return context.getResources().getIdentifier(name, type, context.getPackageName());
    }

    public static int getIdId(String name) {
        return getIdId(name, MyApplication.instance());
    }

    public static int getIdId(String name, Context context) {
        return getResId(name, "id", context);
    }

    public static int getStringId(String name) {
        return getStringId(name, MyApplication.instance());
    }

    public static int getStringId(String name, Context context) {
        return getResId(name, "string", context);
    }

    public static int getDrawableId(String name) {
        return getDrawableId(name, MyApplication.instance());
    }

    public static int getDrawableId(String name, Context context) {
        return getResId(name, "drawable", context);
    }

    public static String getString(String name) {
        return getString(name, MyApplication.instance());
    }

    public static String getString(String name, Context context) {
        return context.getString(getStringId(name, context));
    }

    public static Drawable getDrawable(String name) {
        return getDrawable(name, MyApplication.instance());
    }

    public static Drawable getDrawable(String name, Context context) {
        return context.getResources().getDrawable(getDrawableId(name, context));
    }

    public static int getLayoutId(String name) {
        return getLayoutId(name, MyApplication.instance());
    }

    public static int getLayoutId(String name, Context context) {
        return getResId(name, "layout", context);
    }

    public static XmlResourceParser getLayout(String name) {
        return getLayout(name, MyApplication.instance());
    }

    public static XmlResourceParser getLayout(String name, Context context) {
        return context.getResources().getLayout(getLayoutId(name, context));
    }
}