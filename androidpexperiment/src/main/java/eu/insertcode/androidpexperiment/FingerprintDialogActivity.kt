/*
 *    Copyright 2018 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.androidpexperiment

import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fingerprint_dialog.*

class FingerprintDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint_dialog)

        if (Build.VERSION.SDK_INT == 28) {
            if (!packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT))
                showErrorDialog("You need a fingerprint censor for that.")

            val cancellationSignal = CancellationSignal().apply { setOnCancelListener { finish() } }
            biometricPrompt().authenticate(cancellationSignal, mainExecutor, authenticationCallback())
        } else showErrorDialog("You need Android P for that.")
    }


    @RequiresApi(Build.VERSION_CODES.P)
    private fun biometricPrompt() = BiometricPrompt.Builder(this)
            .setTitle("Biometric Prompt")
            .setSubtitle("This is only a simple experiment.")
            .setDescription("Please try out this fingerprint censor to make sure it works.")
            .setNegativeButton("Cancel", mainExecutor, DialogInterface.OnClickListener { _, _ -> })
            .build()


    @RequiresApi(Build.VERSION_CODES.P)
    private fun authenticationCallback() =
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                    super.onAuthenticationError(errorCode, errString)
                    viewRoot.setBackgroundColor(getColor(R.color.red))
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                    super.onAuthenticationSucceeded(result)
                    viewRoot.setBackgroundColor(getColor(R.color.green))
                }

                override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                    super.onAuthenticationHelp(helpCode, helpString)
                    viewRoot.setBackgroundColor(getColor(R.color.yellow))
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    viewRoot.setBackgroundColor(getColor(R.color.red))
                }
            }

    private fun showErrorDialog(message: String) {
        AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("GOT IT", { _, _ -> finish() })
                .show()
    }
}
