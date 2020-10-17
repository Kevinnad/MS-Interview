package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.AdapterClickListener
import com.example.myapplication.adapters.ListAdapter
import com.example.myapplication.adapters.PaginationScrollListener
import com.example.myapplication.model.ApiListResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

const val POSITION = "position"
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by activityViewModels()
    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    private val listAdapter by lazy {
        ListAdapter(object : AdapterClickListener {
            override fun onItemClick(position: Int, value: String) {

                homeViewModel.selectedPositon = position

                NavHostFragment.findNavController(this@HomeFragment)
                    .navigate(R.id.action_details_fragment,Bundle().apply {
                        this.putInt(POSITION, position)
                    })
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callListApi(0)
        oberservers()

        rv_list.adapter = listAdapter

        rv_list?.addOnScrollListener(object : PaginationScrollListener(rv_list.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true

                getMoreItems()
            }
        })
    }

    fun getMoreItems() {

        callListApi(homeViewModel.apiList.get(homeViewModel.selectedPositon).id)
        isLoading = false

    }

    private fun callListApi(since : Int){
        homeViewModel.fetchList(since)
    }

    private fun oberservers(){

        homeViewModel.listResponseData.observe(requireActivity(), Observer {

//            Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
            homeViewModel.apiList.addAll(it)
            listAdapter.setDataList(homeViewModel.apiList)
        })

        homeViewModel.errorValue.observe(requireActivity(), Observer {

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })
    }

}