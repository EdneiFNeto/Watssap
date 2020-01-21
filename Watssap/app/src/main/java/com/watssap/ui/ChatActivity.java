package com.watssap.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.watssap.R;
import com.watssap.adapter.ChatAdapter;
import com.watssap.model.Chat;
import com.watssap.util.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ListView listview;
    private ChatAdapter ChatAdapter;
    private String TAG="ChatActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        SharedPreferences sharedPreferences = new PreferencesUtils(this).getSharedPreferences();
        long usuarioId = sharedPreferences.getLong(PreferencesUtils.USUARIO_ID, 0);
        Log.e(TAG, "Usuario id "+usuarioId);

        listview = findViewById(R.id.listViewChat);
        List<Chat> chatList = new ArrayList<Chat>();

        Chat c = new Chat();
        c.setIdUser(1);
        c.setContectUser(2);
        c.setNomeUser("Ednei");
        c.setMessage("OI");
        chatList.add(c);

        Chat c1 = new Chat();
        c1.setNomeUser("Jose");
        c1.setIdUser(2);
        c1.setContectUser(2);
        c1.setMessage("OI");
        chatList.add(c1);

        Chat c2 = new Chat();
        c2.setIdUser(1);
        c2.setContectUser(2);
        c2.setNomeUser("Ednei");
        c2.setMessage("Tudo bem");
        chatList.add(c2);


        Chat c3 = new Chat();
        c3.setIdUser(1);
        c3.setContectUser(2);
        c3.setNomeUser("Ednei");
        c3.setMessage("Blz");
        chatList.add(c3);

        ListAdapter adapter = new ChatAdapter(this, (ArrayList<Chat>) chatList);
        listview.setAdapter(adapter);

    }
}
