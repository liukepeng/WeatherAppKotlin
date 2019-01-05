package com.kun.weatherappkotlin.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.kun.weatherappkotlin.R
import com.kun.weatherappkotlin.extensions.ctx
import com.kun.weatherappkotlin.extensions.slideEnter
import com.kun.weatherappkotlin.extensions.slideExit
import com.kun.weatherappkotlin.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author liukepeng
 * @date 2019/1/5
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_setting -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unkown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}