package com.watssap.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.watssap.R;
import com.watssap.model.Chat;
import com.watssap.util.PreferencesUtils;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Chat> lista;

    public ChatAdapter(Context context, ArrayList<Chat>lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Chat getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.model_chat, parent, false);
        TextView textMessage = view.findViewById(R.id.textMesage);
        TextView textNomeUsuario = view.findViewById(R.id.textNomeUsuario);
        LinearLayout linearLayout = view.findViewById(R.id.containerChat);

        textMessage.setText(lista.get(position).getMessage());
        textNomeUsuario.setText(lista.get(position).getNomeUser());

        SharedPreferences sharedPreferences = new PreferencesUtils(context).getSharedPreferences();
        long id_usuario = sharedPreferences.getLong(PreferencesUtils.USUARIO_ID, 0);

        if(id_usuario == lista.get(position).getIdUser()){
            textMessage.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_dark));
            linearLayout.setGravity(Gravity.LEFT);
        }else{
            textMessage.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_dark));
            linearLayout.setGravity(Gravity.RIGHT);
        }

        return view;
    }
}
