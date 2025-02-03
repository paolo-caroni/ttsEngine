package com.k2fsa.sherpa.onnx.tts.engine
import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val PREFS_NAME = "com.k2fsa.sherpa.onnx.tts.engine"
    private val SPEED_KEY = "speed"
    private val SID_KEY = "speaker_id"
    private val INIT_KEY = "init_espeak"
    private val CURRENT_LANGUAGE = "current_language"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getSpeed(): Float { //ToDo: Remove later, only needed for migration
        return sharedPreferences.getFloat(SPEED_KEY, 1.0f)
    }

    fun getSid(): Int { //ToDo: Remove later, only needed for migration
        return sharedPreferences.getInt(SID_KEY, 0)
    }
    fun setInitFinished() {
        val editor = sharedPreferences.edit()
        editor.putBoolean(INIT_KEY, true)
        editor.apply()
    }

    fun isInitFinished(): Boolean {
        return sharedPreferences.getBoolean(INIT_KEY, false)
    }

    fun setCurrentLanguage(language: String){
        val editor = sharedPreferences.edit()
        editor.putString(CURRENT_LANGUAGE, language)
        editor.apply()
    }

    fun getCurrentLanguage(): String? {
        return sharedPreferences.getString(CURRENT_LANGUAGE, "")
    }
}