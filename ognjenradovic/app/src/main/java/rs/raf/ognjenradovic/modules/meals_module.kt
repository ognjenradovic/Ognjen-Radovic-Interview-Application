package rs.raf.ognjenradovic.modules

import JobRepositoryImpl
import org.koin.dsl.module
import rs.raf.ognjenradovic.data.datasources.local.JobDataBase

import rs.raf.ognjenradovic.data.datasources.remote.JobService

import rs.raf.ognjenradovic.data.repositories.*

val mealsModule = module {

//    single<JobRepository> { JobRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }
//    single { get<JobDataBase>().getJobDao() }
//    single<JobService> { create(retrofit = get()) }





}

