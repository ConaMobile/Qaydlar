package com.example.qaydlar

import android.R.attr
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.qaydlar.Adapters.UserAdapter
import com.example.qaydlar.Db.MyDbHelper
import com.example.qaydlar.Models.User
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.fragment_2.view.*
import android.R.attr.label
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService




class Fragment2 : Fragment() {

    lateinit var root:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_2, container, false)



        root.back_btn.setOnClickListener {

            val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
            findNavController().navigate(R.id.fragment1)
            }
            }
            requireActivity().onBackPressed()

        }

        root.btn_save.setOnClickListener {
            val name = item_name_tv_begin.text.toString()

            val user = User(name)
            val myDbHelper = MyDbHelper(requireContext())
            myDbHelper.addContact(user)
            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
            onResume()

        }

        root.share_btn.setOnClickListener {
            val shareBody = item_name_tv_begin.text.toString()
            val shareSub = "Created by Nurmuhammad"

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

            startActivity(shareIntent)
        }

        root.paste_btn.setOnClickListener {
            Toast.makeText(context, "Pasted", Toast.LENGTH_SHORT).show()
        }

        root.like_btn.setOnClickListener {
            root.like_img.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

        root.delete_btn.setOnClickListener {

        }

        return root
    }

    override fun onResume() {
        super.onResume()

    }
}

