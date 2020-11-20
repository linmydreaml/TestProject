package com.test.repositoryfinder.search

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.repositoryfinder.R
import com.test.repositoryfinder.base.BaseFragment
import com.test.repositoryfinder.common.viewModel
import kotlinx.android.synthetic.main.fragment_search_repo.*


class SearchFragment : BaseFragment() {

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var homeAdapter: RepoListAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_search_repo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter = RepoListAdapter()
        repoRv.layoutManager = LinearLayoutManager(requireContext())
        repoRv.adapter = homeAdapter

        viewModel.searchModelLiveData.observe(viewLifecycleOwner, Observer {
            homeAdapter.setData(it)
            homeAdapter.notifyDataSetChanged()

        })
        view.findViewById<ImageView>(R.id.searchIv).setOnClickListener {
            val text = searchEt.text.toString()
            if (text.isNotEmpty()) {
                viewModel.searchRepo(text)
            }
        }

    }


}