@Entity(tableName = "users") data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String, val age: Int )

@Dao interface UserDao { @Insert suspend fun 
    insert (user: User) @Query("SELECT * FROM users") fun getAll(): Flow> }

@Database(entities = [User::class], version = 1) abstract class
AppDatabase : RoomDatabase() {abstract fun UserDao(): UserDao}
