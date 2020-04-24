package com.zkb.appplugin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {


        ClassLoader classLoader = this.getClassLoader();
        Object dexElements = getDexElements(classLoader);



    }

    private Object getDexElements(ClassLoader classLoader) {

        try {
            Field dexPathListField = BaseDexClassLoader.class.getDeclaredField("pathList");
            dexPathListField.setAccessible(true);

            Object dexPathListObject = dexPathListField.get(classLoader);

            Field dexElements = dexPathListObject.getClass().getDeclaredField("dexElements");
            dexElements.setAccessible(true);

            return dexElements.get(dexPathListObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
