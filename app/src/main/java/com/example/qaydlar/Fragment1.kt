package com.example.qaydlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.qaydlar.Adapters.UserAdapter
import com.example.qaydlar.Db.MyDbHelper
import com.example.qaydlar.Models.User
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*

class Fragment1 : Fragment() {

    lateinit var root:View
    lateinit var userAdapter: UserAdapter
    lateinit var userList: ArrayList<User>
    lateinit var myDbHelper: MyDbHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_1, container, false)

        root.add_text.setOnClickListener {
            root.findNavController().navigate(R.id.fragment2)
        }

        myDbHelper = MyDbHelper(root.context)
        onResume()

        return root
    }

    override fun onResume() {
        super.onResume()

        userList = ArrayList()
        userList.addAll(myDbHelper.getAllContact())
        userAdapter = UserAdapter(userList, object : UserAdapter.RVClick{

            override fun deleteItem(user: User) {

                myDbHelper.deleteContact(user)
                onResume()
            }
        })

        root.rv.adapter = userAdapter
    }
}