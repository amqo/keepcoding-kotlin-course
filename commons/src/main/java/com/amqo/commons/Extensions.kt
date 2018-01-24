package com.amqo.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(viewId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(viewId, this, attachToRoot)

