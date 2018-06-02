package eu.insertcode.androidpexperiment

import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

class FingerprintDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint_dialog)

        if (Build.VERSION.SDK_INT == 28) {
            if (!packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
                AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("You need a fingerprint censor for that.")
                        .setPositiveButton("GOT IT", { _, _ -> finish() })
                        .show()
            }

            BiometricPrompt.Builder(this)
                    .setTitle("Biometric Prompt")
                    .setSubtitle("This is only a simple experiment.")
                    .setDescription("Please try out this fingerprint censor to make sure it works.")
                    .setNegativeButton("Cancel", { }, { _, _ -> })
                    .build()
        } else {
            AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("You need Android P for that.")
                    .setPositiveButton("GOT IT", { _, _ -> finish() })
                    .show()
        }
    }
}
