package com.food.store.data.local

import androidx.room.ProvidedTypeConverter

@ProvidedTypeConverter
class FoodNameTypeConverter {


//    @TypeConverter
//    fun sourceToString(source: Source): String{
//        return "${source.id},${source.name}"
//    }
//
//    @TypeConverter
//    fun stringToSource(source: String): Source{
//        return source.split(',').let { sourceArray ->
//            Source(id = sourceArray[0], name = sourceArray[1])
//        }
//    }
}