package rs.raf.ognjenradovic.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.ognjenradovic.data.models.Job
//import androidx.navigation.fragment.findNavController4
import rs.raf.ognjenradovic.databinding.FragmentSecondBinding
import rs.raf.ognjenradovic.presentation.contract.MainContract
import rs.raf.ognjenradovic.presentation.contract.SecondContract
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.MainViewModel
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.SecondViewModel
import rs.raf.ognjenradovic.presentation.view.states.JobDetailsState
import rs.raf.ognjenradovic.presentation.view.states.JobsState

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val secondViewModel: SecondContract.ViewModel2 by sharedViewModel<SecondViewModel>()

    private var _binding: FragmentSecondBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }
    private fun init() {
        initObservers()
    }
    private fun initObservers() {
        secondViewModel.jobDetailsState.observe(viewLifecycleOwner, Observer {
            renderState(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val job1: Job? = arguments?.getParcelable("job")
        var job: Unit? =null;
        init()
        if (job1 != null) {
            secondViewModel.getJobById(job1.id+"")
        }

    }
    companion object {
        fun newInstance(job: Job): SecondFragment {
            val fragment = SecondFragment()
            // Pass data to fragment arguments
            val args = Bundle()
            args.putParcelable("job", job)
            fragment.arguments = args
            return fragment
        }
    }

    private fun renderState(state: JobDetailsState) {
        when (state) {
            is JobDetailsState.Success -> {
                val job=state.job
                job?.let {
                    binding.positionName.text = it.name
                    binding.incomeAmount.text = it.salary
                    val techArray = it.technologies.split(", ") // Splitting technologies by comma
                    if (techArray.size >= 1) binding.tech2.text = techArray[0]
                    if (techArray.size >= 2) binding.tech3.text = techArray[1]
                    if (techArray.size >= 3) binding.tech4.text = techArray[2]
                    if (techArray.size >= 4) binding.tech5.text = techArray[3]
                    if (techArray.size >= 5) binding.tech6.text = techArray[4]
                    binding.jobDescription.text = it.description
                    binding.companyName1.text = it.companyName
                    binding.textView1.text=it.companyName
                    binding.companyDescription.text = it.companyDescription

                    Picasso.get().load(job.imageURL).into(binding.imageView1)
                }
            }
            is JobDetailsState.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is JobDetailsState.DataFetched -> {
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show();
            }
            is JobDetailsState.Loading -> {
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}