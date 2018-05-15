package eu.insertcode.androidpexperiment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_design_library_v28.*

class DesignLibraryV28Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_library_v28)

        appbar.replaceMenu(R.menu.menu)

        chip2.setChipIconResource(R.drawable.ic_star)
    }
}
