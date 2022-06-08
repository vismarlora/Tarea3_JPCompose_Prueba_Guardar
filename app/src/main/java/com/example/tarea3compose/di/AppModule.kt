package com.example.tarea3compose.di

import android.content.Context
import androidx.room.Room
import com.example.tarea3compose.data.OcupacionDao
import com.example.tarea3compose.data.PersonaDao
import com.example.tarea3compose.data.PrestamosDb
import com.example.tarea3compose.data.repository.OcupacionRepository
import com.example.tarea3compose.data.repository.PersonaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton

    fun providesPrestamosDb(@ApplicationContext context: Context):PrestamosDb{
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java, "PrestamosDb")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun providesOcupacionDao(prestamosDb:PrestamosDb): OcupacionDao{
        return prestamosDb.ocupacionDao
    }

    @Provides
    fun providesPersonaDao(prestamosDb:PrestamosDb): PersonaDao {
        return prestamosDb.personaDao
    }

    @Provides
    fun providesOcupacionRepository(ocupacionDao: OcupacionDao): OcupacionRepository{
        return OcupacionRepository(ocupacionDao)
    }

    @Provides
    fun providesPersonaRepository(personaDao: PersonaDao): PersonaRepository {
        return PersonaRepository(personaDao)
    }
}