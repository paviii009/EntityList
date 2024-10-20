package com.cst2335.entitylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class EntityAdapter(private val context: Context, private val entities: MutableList<Entity>) : BaseAdapter() {
    override fun getCount(): Int {
        return entities.size
    }

    override fun getItem(position: Int): Any {
        return entities[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.entity_item, parent, false)

        val entity = entities[position]

        val entityIcon = view.findViewById<ImageView>(R.id.entityIcon)
        val entityName = view.findViewById<TextView>(R.id.entityName)
        val entityType = view.findViewById<TextView>(R.id.entityType)

        entityIcon.setImageResource(context.resources.getIdentifier("entities/${entity.type}.png", "drawable", context.packageName))
        entityName.text = entity.name
        entityType.text = entity.textType

        return view
    }
}