package com.watssap.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.watssap.R;
import com.watssap.model.Contact;
import com.watssap.ui.ChatActivity;

import java.util.ArrayList;

public class ContectAdapter extends RecyclerView.Adapter<ContectAdapter.MyHolder> {

    private final Context context;
    private final ArrayList<Contact> contacts;

    public ContectAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.model_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.add(contacts.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, ChatActivity.class);
                it.putExtra("contact", contacts.get(position));
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private TextView textNameContact;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textNameContact = itemView.findViewById(R.id.textNameContact);
        }

        public void add(Contact contact) {
            textNameContact.setText(contact.getName());
        }
    }
}
