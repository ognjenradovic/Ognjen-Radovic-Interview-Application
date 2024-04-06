//package rs.raf.ognjenradovic.presentation.view.fragments
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.core.widget.doAfterTextChanged
//import androidx.recyclerview.widget.LinearLayoutManager
//import org.koin.androidx.viewmodel.ext.android.sharedViewModel
//import rs.raf.ognjenradovic.databinding.FragmentFirstBinding
//import rs.raf.ognjenradovic.presentation.contract.MainContract
//import rs.raf.ognjenradovic.presentation.view.recycler.adapter.CategoryAdapter
//import rs.raf.ognjenradovic.presentation.view.recycler.adapter.JobAdapter
//import rs.raf.ognjenradovic.presentation.view.states.CategoriesState
//import rs.raf.ognjenradovic.presentation.viewmodel.MainViewModel
//
///**
// * A simple [Fragment] subclass as the default destination in the navigation.
// */
//class FirstFragmentBackup : Fragment() {
//
//    private val mainViewModel: MainContract.ViewModel by sharedViewModel<MainViewModel>()
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
//        adapter = CategoryAdapter { category ->
//            openCategoryFragment(category)
//        }
//        binding.recyclerView.adapter = adapter
//    }
//    private fun initObservers() {
//        mainViewModel.categoriesState.observe(viewLifecycleOwner, Observer {
//            renderState(it)
//        })
//        mainViewModel.fetchAllCategories()
//        mainViewModel.fetchAllMeals()
//        mainViewModel.getAllCategories()
//    }
//
//    private fun renderState(state: CategoriesState) {
//        when (state) {
//            is CategoriesState.Success -> {
//                showLoadingState(false)
//                adapter.submitList(state.categories.categories)
//            }
//            is CategoriesState.Error -> {
//                showLoadingState(false)
//                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
//            }
//            is CategoriesState.DataFetched -> {
//                showLoadingState(false)
//                /*Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show())*/
//            }
//            is CategoriesState.Loading -> {
//                showLoadingState(true)
//            }
//        }
//    }
//
//    private fun showLoadingState(loading: Boolean) {
//        if (loading) {
//            binding.loadingProgressBar.visibility = View.VISIBLE
//            binding.searchEditText.isEnabled = false
//
//            binding.searchEditText.postDelayed({
//                binding.loadingProgressBar.visibility = View.GONE
//                binding.searchEditText.isEnabled = true
//
//            }, 2000)
//        } else {
//            binding.loadingProgressBar.visibility = View.GONE
//            binding.searchEditText.isEnabled = true
//        }
//    }
//}