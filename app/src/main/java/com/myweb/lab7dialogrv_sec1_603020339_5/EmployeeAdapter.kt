package com.myweb.lab7dialogrv_sec1_603020339_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.em_item_layout.view.*

class EmployeeAdapter(val item:List<Employee>,val context:Context) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.em_item_layout,parent,false)
        return ViewHolder(view_item)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvname?.text = "Name : "+item[position].name
        holder.tvgen?.text= "Gender : "+item[position].gender
        holder.tvemail?.text = "E-mail : "+item[position].email
        holder.tvsalary?.text = "Salary : "+item[position].salary.toString()
    }
}

class ViewHolder (view:View) : RecyclerView.ViewHolder(view){
    val tvname = view.tv_name
    val tvgen = view.tv_gen
    val tvemail = view.tv_mail
    val tvsalary = view.tv_salary
}