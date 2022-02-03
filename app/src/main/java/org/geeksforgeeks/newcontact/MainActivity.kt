package org.geeksforgeeks.newcontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditTextName = findViewById<EditText>(R.id.edit_text_1)
        val mEditTextPhone = findViewById<EditText>(R.id.edit_text_2)
        val mButton = findViewById<Button>(R.id.button_1)

        mButton.setOnClickListener {
            if(mEditTextName.text.isNotEmpty() and mEditTextPhone.text.isNotEmpty()){
                val mName = mEditTextName.text.toString()
                val mPhone = mEditTextPhone.text.toString()
                mSaveContact(mName, mPhone)
            } else {
                Toast.makeText(applicationContext, "Missing Fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun mSaveContact(fName: String, fPhone: String){
        val mIntent = Intent(ContactsContract.Intents.Insert.ACTION)
        mIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
        mIntent.putExtra(ContactsContract.Intents.Insert.NAME, fName)
        mIntent.putExtra(ContactsContract.Intents.Insert.PHONE, fPhone)
        startActivity(mIntent)
    }
}