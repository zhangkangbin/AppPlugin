package com.zkb.appplugin;

import dalvik.system.PathClassLoader;

public class MyClassLoader extends PathClassLoader {
/*
    public MyClassLoader(String dexPath, String librarySearchPath, ClassLoader parent) {
        super(dexPath, librarySearchPath, parent);
    }
*/

    public MyClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, parent);
    }
}
