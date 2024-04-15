package com.example.jetchat

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    val auth:FirebaseAuth
) : ViewModel() {

    fun signUpUser(name:String,number:String,email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                Log.d("ViewModel","Success")
            }else{
                Log.d("ViewModel","Failure")

            }
        }
    }

}