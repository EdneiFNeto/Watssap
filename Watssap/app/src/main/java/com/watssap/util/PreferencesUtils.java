package com.watssap.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.watssap.model.Usuario;

public class PreferemncesUtils {

    private static Context context;
    public static String USUARIO_ID="usuario_id";
    private static String PREFERENCES="preferences";

    public PreferemncesUtils(Context context) {
        this.context = context;
    }

    public static SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void saveUsuarioID(SharedPreferences sharedPreferences, Usuario usuario){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(USUARIO_ID, usuario.getId()).commit();
    }
}
