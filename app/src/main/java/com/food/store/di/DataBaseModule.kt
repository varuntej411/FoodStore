package com.food.store.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.food.store.common.Constants.FOOD_STORE_DB_NAME
import com.food.store.common.Constants.FOOD_STORE_PREF_NAME
import com.food.store.common.UserDataStore
import com.food.store.common.UserDataStoreImpl
import com.food.store.data.local.FoodStoreDao
import com.food.store.data.local.FoodStoreDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): FoodStoreDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = FoodStoreDataBase::class.java,
            name = FOOD_STORE_DB_NAME
        ).fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodStoreDao(dataBase: FoodStoreDataBase): FoodStoreDao {
        return dataBase.getFoodAppDao()
    }

    @Provides
    @Singleton
    fun provideDataStorePreferences(application: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { application.preferencesDataStoreFile(FOOD_STORE_PREF_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideDataStore(userDataStore: DataStore<Preferences>): UserDataStore {
        return UserDataStoreImpl(userDataStore)
    }

}