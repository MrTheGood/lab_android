package eu.insertcode.androidpexperiment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_material_2.*

class Material2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_2)

        appbar.replaceMenu(R.menu.menu)
    }
}
