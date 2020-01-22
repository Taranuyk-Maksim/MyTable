package com.pupsik.mytable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {


    class DayViewAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {

        private val fragmentList : MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment){
            fragmentList.add(fragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setLightStatusBar()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager : ViewPager = findViewById(R.id.vp_list)
        val adapterr = DayViewAdapter(supportFragmentManager)


        adapterr.addFragment(DayFragment())
        adapterr.addFragment(DayFragment())
        adapterr.addFragment(DayFragment())

        viewPager.adapter = adapterr
        val bn : BottomNavigationItemView = findViewById(R.id.bottom_navigstion)
    }

}

