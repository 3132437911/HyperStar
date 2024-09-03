package com.chaos.hyperstar.hook.base;

import android.content.res.Resources;
import android.content.res.XModuleResources;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public abstract class BaseHooker {

    public BaseHooker(){

    }

    public enum ClassType{
        load(false),res(false);

        private boolean value;

        ClassType(boolean value){
            this.value=value;
        }

        public boolean getValue() {
            return this.value;
        }

        public void setValue(boolean value) {
            this.value = value;
        }
    }


    public void getLocalRes(Resources res){};
    public void doMethods(ClassLoader classLoader){};
    public void doMethods(XC_LoadPackage.LoadPackageParam lpparam){};
    public void doRes(XC_InitPackageResources.InitPackageResourcesParam resparam){}

    //public ProviderUtils mProviderUtils;
    public String mPath;

    public XModuleResources mXModuleResources;
    public XC_LoadPackage.LoadPackageParam lpparam;

    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable {
        mPath=startupParam.modulePath;
    }


    public boolean classIsExist(XC_LoadPackage.LoadPackageParam lpparam, String className){
        Class<?> hookClass= XposedHelpers.findClass(className,lpparam.classLoader);
        if (hookClass == null){
            return false;
        }
        return true;
    }

    public void hookAllMethods (ClassLoader classLoader,
                                String className,
                                String methodName,
                                MethodHook methodHook){
        Class<?> hookClass= XposedHelpers.findClass(className,classLoader);
        XposedBridge.hookAllMethods(hookClass, methodName, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                methodHook.before(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                methodHook.after(param);
            }
        });
        //XposedBridge.hookAllMethods(hookClass,methodName,methodHook);

    }



    public interface MethodHook{
        void before(XC_MethodHook.MethodHookParam param);
        void after(XC_MethodHook.MethodHookParam param);
    }

}
