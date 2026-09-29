package com.example.project;

public class Levelsummary {
        // 1. ตัวแปรเก็บข้อมูลผลสรุปด่าน
        private String stageId;            // รหัสหรือเลขประจำด่าน
        private double accuracyPercentage; // เปอร์เซ็นต์ความแม่นยำเฉพาะด่านนี้
        private int wrongAttemptsCount;    // นับจำนวนครั้งที่กดตอบผิด
        private int hintsUsedCount;        // นับจำนวนครั้งที่กดขอคำใบ้

        // 2. Constructor คำนวณค่าอัตโนมัติ
        public Levelsummary(String stageId, int correctCount, int wrongAttemptsCount, int hintsUsedCount) {
            this.stageId = stageId;
            this.wrongAttemptsCount = wrongAttemptsCount;
            this.hintsUsedCount = hintsUsedCount;

            // คำนวณความแม่นยำเฉพาะด่านนี้ทันที
            int totalAttempts = correctCount + wrongAttemptsCount;
            if (totalAttempts > 0) {
                this.accuracyPercentage = ((double) correctCount / totalAttempts) * 100.0;
            } else {
                this.accuracyPercentage = 0.0;
            }
        }
        // 3. Getters & Setters
        public String getStageId() { return stageId; }
        public double getAccuracyPercentage() { return accuracyPercentage; }
        public int getWrongAttemptsCount() { return wrongAttemptsCount; }
        public int getHintsUsedCount() { return hintsUsedCount; }

}
