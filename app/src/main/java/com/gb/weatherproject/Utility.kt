package com.gb.weatherproject

import android.view.View
import com.google.android.material.snackbar.Snackbar


fun View.createAndShow(text: String, actionText: String, action: (View) -> Unit, length: Int = Snackbar.LENGTH_INDEFINITE) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun View.showWarning(){
    Snackbar.make(this,"Warning action!",Snackbar.LENGTH_SHORT).show()
}

fun View.showAppName(){
    Snackbar.make(this,context.getText(R.string.app_name),Snackbar.LENGTH_LONG).show()
}