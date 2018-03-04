package com.kotlin.albertoquiros.gangame

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.kotlin.albertoquiros.gangame.deals.DealsFragment
import com.kotlin.albertoquiros.gangame.owned.TopOwnedFragment
import com.kotlin.albertoquiros.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val defaultOption = R.id.action_deals
    }

    private val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigationView.selectedItemId = defaultOption
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment = fragments[item.itemId]
            fragment?.let {
                replaceFragment(fragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun initView() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragments[defaultOption]).commit()
        }
    }
}
