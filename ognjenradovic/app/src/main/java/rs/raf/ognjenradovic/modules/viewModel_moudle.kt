////package rs.raf.ognjenradovic.modules
////
////import JobRepositoryImpl
////import org.koin.androidx.viewmodel.dsl.viewModel
////import org.koin.dsl.module
////import rs.raf.ognjenradovic.data.repositories.JobRepository
////import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.MainViewModel
////import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.SecondViewModel
//
//val viewModelModule = module {
//    viewModel { MainViewModel(get()) }
//    viewModel { SecondViewModel(get()) }// Inject JobRepository
//}
//
//val repositoryModule = module {
//    single<JobRepository> { JobRepositoryImpl() } // Assuming JobRepositoryImpl is your implementation
//}