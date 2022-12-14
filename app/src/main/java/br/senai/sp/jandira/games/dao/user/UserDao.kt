package br.senai.sp.jandira.games.dao.user

import androidx.room.*
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.model.UserWithGame

@Dao
interface UserDao {
    @Transaction
    @Query("SELECT * FROM tbl_user WHERE code = :id")
    fun getUserGame(id: Int): List<UserWithGame>

    @Insert
    fun save(user: User): Long

    @Delete
    fun delete(user: User): Int

    @Update
    fun update(user: User): Int

    @Query("SELECT * FROM tbl_user ORDER BY user_name ASC")
    fun getAll(): List<User>

    @Query("SELECT * FROM tbl_user WHERE code = :id")
    fun getUserById(id: Int): User

    @Query("SELECT * FROM tbl_user WHERE user_email = :email")
    fun getUserByEmail(email: String): User
}