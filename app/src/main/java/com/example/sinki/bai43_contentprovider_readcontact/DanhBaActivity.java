package com.example.sinki.bai43_contentprovider_readcontact;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sinki.model.Contact;

import java.util.ArrayList;

public class DanhBaActivity extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayList<Contact>dsDanhBa;
    ArrayAdapter<Contact>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        addEvents();
        showAllContactONDevice();
    }

    private void showAllContactONDevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext())
        {
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vtTenCotName = cursor.getColumnIndex(tenCotName);
            int vtTenCotPhone = cursor.getColumnIndex(tenCotPhone);
            String name = cursor.getString(vtTenCotName);
            String phone = cursor.getString(vtTenCotPhone);
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
        }
        arrayAdapter.notifyDataSetChanged();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<Contact>(
                DanhBaActivity.this,
                android.R.layout.simple_list_item_1,
                dsDanhBa);
        lvDanhBa.setAdapter(arrayAdapter);
    }
}
