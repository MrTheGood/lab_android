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

package eu.insertcode.lab.architecture.normal.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import eu.insertcode.lab.architecture.R
import eu.insertcode.lab.architecture.normal.view.fragment.ArticleFragment
import eu.insertcode.lab.architecture.normal.view.fragment.ArticleListFragment

class ArchitectureComponentsActivity : AppCompatActivity() {
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture_components)

        if (savedInstanceState == null) {
            showFragment(ArticleListFragment(), false)
        }
    }

    override fun onResume() {
        super.onResume()
        currentFragment = supportFragmentManager.fragments.firstOrNull { !it.isHidden }
    }

    override fun onBackPressed() {
        val listFragment = supportFragmentManager.findFragmentByTag(ArticleListFragment::class.java.simpleName)
        if (currentFragment is ArticleFragment && listFragment != null) {
            showFragment(listFragment, false)
        } else super.onBackPressed()
    }

    fun showFragment(fragment: Fragment, addToBackStack: Boolean) {
        val current = currentFragment
        currentFragment = fragment

        if (current === currentFragment) {
            return
        }

        supportFragmentManager.beginTransaction().run {
            if (!fragment.isAdded) add(R.id.activity_arch_root, fragment, fragment.javaClass.simpleName)
            else if (fragment.isDetached) attach(fragment)
            else if (fragment.isHidden) show(fragment)

            if (addToBackStack) addToBackStack(fragment.javaClass.simpleName)

            if (current != null) {
                hide(current)
            }
            commitAllowingStateLoss()
        }
    }
}
