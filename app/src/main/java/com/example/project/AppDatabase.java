package com.example.project;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/*
  คลาสหลักฐานข้อมูล Room Database ของแอปพลิเคชัน[cite: 19]

  คำแนะนำสำหรับเพื่อนในทีม:
  - เรียกใช้ผ่าน AppDatabase.getInstance(context)
  - QUESTIONCONTROLLER -> ใช้ questionDao()[cite: 15, 19]
  - LEVELCONTROLLER / SAVECONTROLLER -> ใช้ gameStageDao()[cite: 15]
 */
@Database(entities = {Question.class, GameStage.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    /* Access Object สำหรับจัดการโจทย์ */
    public abstract QuestionDao questionDao();


    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "quiz_game_db"
                            )
                            .fallbackToDestructiveMigration() // รีเซ็ต DB อัตโนมัติเมื่อมีการปรับเปลี่ยนตารางข้อมูล[cite: 19]
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}