package com.example.lab7dialogrv_sec1_603020371_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.radio_gd

class MainActivity : AppCompatActivity() {
    val employeeList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = EmployeeAdapter(this.employeeList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }
    fun addEmployee(v: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()



        mDialogView.btnAdd.setOnClickListener{

            var gen :Int = mDialogView.radio_gd.checkedRadioButtonId;
            var gender :RadioButton = mDialogView.findViewById(gen);

            employeeList.add(Employee(mDialogView.edt_name.text.toString(),gender.text.toString(),mDialogView.edt_em.text.toString(),mDialogView.edt_salary.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"The employee is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btncancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData(){
        employeeList.add(Employee("Danny","Male","danny@kkumail.ac.th",30000))

    }
}
