package com.example.project;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey
    @NonNull
    private String id;
    private String language;
    private String Difficulty;
    private String codeSnippet;
    private List<String> options;
    private String answer;
    private String hint;

    public Question() {}

    public Question(@NonNull String id, String language, String Difficulty, String codeSnippet, List<String> options, String answer, String hint) {
        this.id = id; //ไอดีคำถาม
        this.language = language; //ภาษา
        this.Difficulty = Difficulty; //ความยาก
        this.codeSnippet = codeSnippet; //โจทย์
        this.options = options; //ตัวเลือกคำตอบ
        this.answer = answer; //เฉลย
        this.hint = hint; //คำใบ้
    }

    @NonNull public String getId() { return id; }
    public void setId(@NonNull String id) { this.id = id; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getDifficulty() { return Difficulty; }
    public void setDifficulty(String Difficulty) { this.Difficulty = Difficulty; }

    public String getCodeSnippet() { return codeSnippet; }
    public void setCodeSnippet(String codeSnippet) { this.codeSnippet = codeSnippet; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getHint() { return hint; }
    public void setHint(String hint) { this.hint = hint; }
}
