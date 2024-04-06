//package rs.raf.ognjenradovic.presentation.view.fragments
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import org.koin.androidx.viewmodel.ext.android.sharedViewModel
//import rs.raf.ognjenradovic.R
//import rs.raf.ognjenradovic.data.models.Job
//import rs.raf.ognjenradovic.databinding.FragmentFirstBinding
//import rs.raf.ognjenradovic.presentation.contract.MainContract
//import rs.raf.ognjenradovic.presentation.view.recycler.adapter.JobAdapter
//import rs.raf.ognjenradovic.presentation.view.states.JobsState
//import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.MainViewModel
//
///**
// * A simple [Fragment] subclass as the default destination in the navigation.
// */
//class FirstFragment : Fragment() {
//
//    private val viewModel: MainContract.ViewModel1 by sharedViewModel<MainViewModel>()
//    private var _binding: FragmentFirstBinding? = null
//    private lateinit var adapter: JobAdapter
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
//        return binding.root
//
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        init()
////        binding.cardLayout.setOnClickListener {
//////            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
////        }
//    }
//
//    private fun init() {
//        initUi()
//        initObservers()
//    }
//
//    private fun initUi() {
//        initRecycler()
//        initListeners()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    private fun initListeners() {
////        binding.searchEditText.doAfterTextChanged {
////            val filter = it.toString()
////            mainViewModel.getCategoriesByName(filter)
////        }
//    }
//
//    private fun initRecycler() {
//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
//        adapter = JobAdapter { job ->
//            navigateToSecondFragment(job)
//        }
//        binding.recyclerView.adapter = adapter
//    }
//    private fun initObservers() {
//        viewModel.jobsState.observe(viewLifecycleOwner, Observer {
//            renderState(it)
//        })
//        viewModel.fetchAllJobs()
//        viewModel.getAllJobs()
//    }
//
//    private fun navigateToSecondFragment(job: Job) {
//        val fragment = SecondFragment.newInstance(job)
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .addToBackStack(null)  // Add this if you want to navigate back to FirstFragment
//            .commit()
//    }
//
//
//    private fun renderState(state: JobsState) {
//        when (state) {
//            is JobsState.Success -> {
//                showLoadingState(false)
//                adapter.submitList(state.job.jobs)
//            }
//            is JobsState.Error -> {
//                showLoadingState(false)
//                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
//            }
//            is JobsState.DataFetched -> {
//                showLoadingState(false)
//                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show();
//            }
//            is JobsState.Loading -> {
//                showLoadingState(true)
//            }
//        }
//    }
//
//    private fun showLoadingState(loading: Boolean) {
////        if (loading) {
////            binding.loadingProgressBar.visibility = View.VISIBLE
////            binding.searchEditText.isEnabled = false
////
////            binding.searchEditText.postDelayed({
////                binding.loadingProgressBar.visibility = View.GONE
////                binding.searchEditText.isEnabled = true
////
////            }, 2000)
////        } else {
////            binding.loadingProgressBar.visibility = View.GONE
////            binding.searchEditText.isEnabled = true
////        }
//    }
//}
//
//



package rs.raf.ognjenradovic.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.ognjenradovic.R
import rs.raf.ognjenradovic.data.models.Job
import rs.raf.ognjenradovic.databinding.FragmentFirstBinding
import rs.raf.ognjenradovic.presentation.contract.MainContract
import rs.raf.ognjenradovic.presentation.view.states.JobsState
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.MainViewModel
import rs.raf.ognjenradovic.presentation.view.recycler.JobEpoxyController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel: MainContract.ViewModel1 by sharedViewModel<MainViewModel>()
    private var _binding: FragmentFirstBinding? = null
    private lateinit var epoxyController: JobEpoxyController


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecycler() {
        epoxyController = JobEpoxyController { job ->
            navigateToSecondFragment(job)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setController(epoxyController)
    }

    private fun initObservers() {
        viewModel.jobsState.observe(viewLifecycleOwner, Observer {
            renderState(it)
        })
        viewModel.fetchAllJobs()
        viewModel.getAllJobs()
    }

    private fun navigateToSecondFragment(job: Job) {
        val fragment = SecondFragment.newInstance(job)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun renderState(state: JobsState) {
        when (state) {
            is JobsState.Success -> {
                showLoadingState(false)
                epoxyController.setData(state.job.jobs)
            }
            is JobsState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is JobsState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show();
            }
            is JobsState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
    }
}
