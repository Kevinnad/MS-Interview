package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_item.*

@AndroidEntryPoint
class HomeDetailFragment : Fragment(R.layout.list_item){

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observer()

    }

    fun observer(){

     homeViewModel.apiList.let {

         if(tv_name != null){
             val selectedItem = it.get(homeViewModel.selectedPositon)
             tv_name.text = selectedItem.full_name
             tv_node_id.text = selectedItem.owner.node_id
             tv_type.text = selectedItem.owner.type
             et_comments.setText(selectedItem.owner.comment)
         }


     }

    }
}