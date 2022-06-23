package com.example.a2320

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var context: Activity = this
    var b1: Button? = null
    var b2: Button? = null
    var b3: Button? = null
    var et1: EditText? = null
    var et2: EditText? = null
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        b1 = findViewById<View>(R.id.login) as Button
        b2 = findViewById<View>(R.id.register) as Button
        b3 = findViewById<View>(R.id.cancel) as Button
        et1 = findViewById<View>(R.id.login1) as EditText
        et2 = findViewById<View>(R.id.register1) as EditText
        mAuth = FirebaseAuth.getInstance()


        b3!!.setOnClickListener {
            et1!!.setText(null)
            et2!!.setText(null)
        }

        b2!!.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity2,MainActivity3::class.java)
            startActivity(intent)
        }

        b1!!.setOnClickListener {
            mAuth!!.signInWithEmailAndPassword(et1!!.text.toString(), et2!!.text.toString())
                .addOnCompleteListener(context, object : OnCompleteListener<AuthResult?> {
                    override fun onComplete(task: Task<AuthResult?>) {
                        if (task.isSuccessful()) {
                            val intent = Intent()
                            intent.setClass(this@MainActivity2, MainActivity::class.java)
                            startActivity(intent)
                            tv1!!.text = "登入成功"

                        } else {
                            tv1!!.text = "登入失敗"
                        }
                    }
                })
        }

    }
}
