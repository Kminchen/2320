package com.example.a2320

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity3 : AppCompatActivity() {
    var context2: Activity = this
    var b: Button? = null
    var bb: Button? = null
    var tv: TextView? = null
    var et: EditText? = null
    var ett: EditText? = null
    var mAuthe: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        b = findViewById<View>(R.id.cancel2) as Button
        bb = findViewById<View>(R.id.register3) as Button
        et = findViewById<View>(R.id.login2) as EditText
        ett = findViewById<View>(R.id.register2) as EditText
        tv = findViewById<View>(R.id.tv2) as TextView
        mAuthe = FirebaseAuth.getInstance()

        bb!!.setOnClickListener {
            mAuthe!!.createUserWithEmailAndPassword(et!!.text.toString(), ett!!.text.toString())
                .addOnCompleteListener(context2, object : OnCompleteListener<AuthResult?> {
                    override fun onComplete(task: Task<AuthResult?>) {
                        if (task.isSuccessful()) {
                            val intent = Intent()
                            intent.setClass(this@MainActivity3, MainActivity2::class.java)
                            startActivity(intent)
                            tv!!.text ="註冊成功"
                        } else {
                            tv!!.text = "註冊失敗"
                        }
                    }
                })
        }

        b!!.setOnClickListener {
            et!!.setText(null)
            ett!!.setText(null)
        }
    }
}