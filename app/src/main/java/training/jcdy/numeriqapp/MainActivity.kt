package training.jcdy.numeriqapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = mutableListOf("test", "test2", "test3")
        var result = mutableListOf<String>()
        for (s in list) {
            result.add(s)
        }
    }
}