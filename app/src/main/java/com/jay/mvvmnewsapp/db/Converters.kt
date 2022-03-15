package com.jay.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.jay.mvvmnewsapp.model.Source

//When we have a class in our model class and need to store the other classes
// response in RoomDB then we use typeConverters
//Here we have Article Model Class and in there we again have Source class so used
// the typeConverter to store the Source classes response in RoomDB
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
        fun toSource(name: String): Source {
            return Source(name, name)
        }
}