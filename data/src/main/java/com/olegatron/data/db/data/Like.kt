package com.olegatron.data.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.olegatron.domain.db.data.Like

@Entity(tableName = "likes")
data class Like(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int? = 0
) {
    fun convert(): Like {
        val like = this
        return Like(like.id)
    }
}
