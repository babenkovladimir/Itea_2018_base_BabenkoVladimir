package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vladimirbabenko.android_base_homeworks.R
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager
import kotlinx.android.synthetic.main.fragment_congratulation.btFragmentButtonAccept
import kotlinx.android.synthetic.main.fragment_congratulation.btFragmentClose

/*
*  !!. - it's null assertion safety
* */

class CongratulationDialogKt : DialogFragment() {

    val dataManager:DataManager

    init {
      dataManager = DataManager.getInstance(context)
    }

    companion object {
        fun newInstance(bundle: Bundle?): CongratulationDialog {// Use null safety
            val fragment = CongratulationDialog()
            fragment.arguments = bundle                         // No crash by "?"
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_congratulation, container, false)
        setupUI()

        return view
    }

    fun setupUI(): Unit {
        btFragmentButtonAccept.setOnClickListener(
            View.OnClickListener {
                dataManager.prefs.setDialogIsShown(true)
                dismiss()
                Toast.makeText(
                    context, "This is Kotlin! Dialog is accepted", Toast.LENGTH_SHORT
                ).show()
            }
        )
        btFragmentClose.setOnClickListener(View.OnClickListener {
            this.dismiss()
            Toast.makeText(activity, "Welcome screen is CANSELED", Toast.LENGTH_SHORT).show()
        })
        isCancelable = false
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity, "FragmentDialog is closed by Taping outside", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
}
