package ru.startandroid.develop.alertdialogprepare

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

const val LOG_TAG = "myLogs"
const val DIALOG = 1

class MainActivity : AppCompatActivity() {

    val sdf:SimpleDateFormat = SimpleDateFormat("HH:mm:ss")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v:View) {
        showDialog(DIALOG)
    }

    override fun onCreateDialog(id: Int): Dialog {
        Log.d(LOG_TAG, "onCreateDialog")
        if (id == DIALOG) {
            val adb: AlertDialog.Builder = AlertDialog.Builder(this)
            adb.setTitle("Текущее время")
            adb.setMessage(sdf.format(Date(System.currentTimeMillis())))
            return adb.create()
        }
        return super.onCreateDialog(id)
    }

    override fun onPrepareDialog(id: Int, dialog: Dialog?) {
        super.onPrepareDialog(id, dialog)
        Log.d(LOG_TAG, "onPrepareDialog")
        if (id == DIALOG) {
            (dialog as AlertDialog).setMessage(sdf.format(Date(System.currentTimeMillis())))
        }
    }
}