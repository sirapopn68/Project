package com.example.project;

public class UserStats {

      // 1. ตัวแปรเก็บข้อมูลสถิติ
        private int totalSolved;        // จำนวนด่านที่เล่นผ่านสำเร็จ
        private int totalAttempts;      // จำนวนครั้งที่กดตอบทั้งหมด (รวมถูกและผิด)
        private double overallAccuracy;  // เปอร์เซ็นต์ความแม่นยำรวม (%)

        // 2. Constructor
        public UserStats() {
            this.totalSolved = 0;       // เริ่มต้นยังไม่เคยผ่านด่าน
            this.totalAttempts = 0;     // เริ่มต้นยังไม่เคยเล่น
            this.overallAccuracy = 0.0; // ความแม่นยำเริ่มต้น 0%
        }

        public UserStats(int totalSolved, int totalAttempts) {
            this.totalSolved = totalSolved;
            this.totalAttempts = totalAttempts;
            calculateAccuracy();        // เรียกคำนวณ % ความแม่นยำทันทีที่สร้าง
        }

        // 3. Method คำนวณ % ความแม่นยำ
        private void calculateAccuracy() {
            if (totalAttempts > 0) {
                // สูตร: (จำนวนข้อที่ถูก / จำนวนครั้งที่เล่นทั้งหมด) * 100
                this.overallAccuracy = ((double) totalSolved / totalAttempts) * 100.0;
            } else {
                this.overallAccuracy = 0.0; // กัน Error กรณีหารด้วย 0
            }
        }
        // 4. Method อัปเดตสถิติการเล่น
           // สั่งทำงานเมื่อเล่นชนะ/ผ่านด่าน
        public void recordSuccess() {
            this.totalSolved++;      // บวกจำนวนข้อที่ถูกขึ้น 1
            this.totalAttempts++;    // บวกจำนวนครั้งที่เล่นขึ้น 1
            calculateAccuracy();     // คำนวณ % ความแม่นยำใหม่
        }

        // สั่งทำงานเมื่อตอบผิด/เล่นแพ้
        public void recordFailure() {
            this.totalAttempts++;    // บวกเฉพาะจำนวนครั้งที่เล่นขึ้น 1
            calculateAccuracy();     // คำนวณ % ความแม่นยำใหม่
        }
        // 5. Getters & Setters
        public int getTotalSolved() { return totalSolved; } // ดึงไปแสดง เช่น "ด่านที่ทำสำเร็จ: 8 ด่าน"
        public void setTotalSolved(int totalSolved) {
            this.totalSolved = totalSolved;
            calculateAccuracy();
        }

        public int getTotalAttempts() { return totalAttempts; }
        public void setTotalAttempts(int totalAttempts) {
            this.totalAttempts = totalAttempts;
            calculateAccuracy();
        }

        public double getOverallAccuracy() { return overallAccuracy; }

}
