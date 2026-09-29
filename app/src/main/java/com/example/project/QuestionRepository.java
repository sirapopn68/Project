package com.example.project;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionRepository {

    private final QuestionDao questionDao;

    public QuestionRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        this.questionDao = db.questionDao();
    }

    public void seedInitialData() {
        List<Question> questionList = new ArrayList<>();

        // ==========================================
        // 1. ภาษา C (c)
        // ==========================================

        // C - Easy
        questionList.add(new Question(
                "c_001",
                "c",
                "Easy",
                "// โจทย์: เติมคำสั่งให้โปรแกรมตรวจสอบรหัสผ่าน โดยต้องมีความยาวอย่างน้อย 8 ตัวอักษร และมีตัวอักษรพิเศษ '@' อยู่ในรหัสผ่าน\n\n" +
                        "#include <stdio.h>\n" +
                        "#include <string.h>\n" +
                        "int main() {\n" +
                        "    char pass[] = \"Admin@123\";\n" +
                        "    int len = strlen(pass);\n" +
                        "    int has_at = 0;\n" +
                        "    for (int i = 0; i < len; i++) {\n" +
                        "        if (pass[i] == '@') {\n" +
                        "            ___1___\n" +
                        "        }\n" +
                        "    }\n" +
                        "    if ( ___2___ ) {\n" +
                        "        printf(\"Strong Password\\n\");\n" +
                        "    } else {\n" +
                        "        ___3___\n" +
                        "    }\n" +
                        "    return 0;\n" +
                        "}",
                Arrays.asList("has_at = 1;", "len >= 8 && has_at == 1", "printf(\"Weak Password\\n\");", "has_at = 0;", "len >= 8 || has_at == 1", "printf(\"Strong Password\\n\");"),
                "#include <stdio.h>\n#include <string.h>\nint main() {\n    char pass[] = \"Admin@123\";\n    int len = strlen(pass);\n    int has_at = 0;\n    for (int i = 0; i < len; i++) {\n        if (pass[i] == '@') {\n            has_at = 1;\n        }\n    }\n    if ( len >= 8 && has_at == 1 ) {\n        printf(\"Strong Password\\n\");\n    } else {\n        printf(\"Weak Password\\n\");\n    }\n    return 0;\n}",
                "has_at = 1;"
        ));

        // C - Medium
        questionList.add(new Question(
                "c_002",
                "c",
                "Medium",
                "// โจทย์: เติมคำสั่งสลับตำแหน่งข้อมูลและประมวลผลการเข้ารหัสแบบ XOR Cipher เพื่อสลับค่าระหว่างสองบัฟเฟอร์ให้ปลอดภัย\n\n" +
                        "#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    char data = 'A';\n" +
                        "    char key = 'k';\n" +
                        "    char encrypted = ___1___;\n" +
                        "    char temp = encrypted;\n" +
                        "    ___2___\n" +
                        "    ___3___\n" +
                        "    printf(\"Decrypted: %c\\n\", temp ^ key);\n" +
                        "    return 0;\n" +
                        "}",
                Arrays.asList("data ^ key;", "encrypted = key;", "key = temp;", "data = encrypted;", "data & key;", "temp = data;"),
                "#include <stdio.h>\nint main() {\n    char data = 'A';\n    char key = 'k';\n    char encrypted = data ^ key;\n    char temp = encrypted;\n    encrypted = key;\n    key = temp;\n    printf(\"Decrypted: %c\\n\", temp ^ key);\n    return 0;\n}",
                "data ^ key;"
        ));

        // C - Hard
        questionList.add(new Question(
                "c_003",
                "c",
                "Hard",
                "// โจทย์: เติมคำสั่งให้ฟังก์ชันเขียนทับหน่วยความจำเดิมด้วยค่า 0 (Zeroize Memory) เพื่อลบข้อมูลลับออกจาก RAM\n\n" +
                        "#include <stdio.h>\n" +
                        "void safe_zeroize(char *buf, int size) {\n" +
                        "    for (int i = 0; i < size; i++) {\n" +
                        "        ___1___\n" +
                        "    }\n" +
                        "}\n" +
                        "int main() {\n" +
                        "    char secret[6] = \"12345\";\n" +
                        "    int size = 6;\n" +
                        "    ___2___\n" +
                        "    if ( ___3___ ) {\n" +
                        "        printf(\"Memory Cleared Securely\\n\");\n" +
                        "        return 0;\n" +
                        "    }\n" +
                        "}",
                Arrays.asList("buf[i] = '\\0';", "safe_zeroize(secret, size);", "secret[0] == '\\0'", "buf[i] = '1';", "safe_zeroize(secret, 0);", "secret == NULL"),
                "#include <stdio.h>\nvoid safe_zeroize(char *buf, int size) {\n    for (int i = 0; i < size; i++) {\n        buf[i] = '\\0';\n    }\n}\nint main() {\n    char secret[6] = \"12345\";\n    int size = 6;\n    safe_zeroize(secret, size);\n    if ( secret[0] == '\\0' ) {\n        printf(\"Memory Cleared Securely\\n\");\n        return 0;\n    }\n}",
                "buf[i] = '\\0';"
        ));

        // ==========================================
        // 2. ภาษา SQL (sql)
        // ==========================================

        // SQL - Easy
        questionList.add(new Question(
                "sql_001",
                "sql",
                "Easy",
                "-- โจทย์: เติมคำสั่งเพื่อป้องกันการดูข้อมูลผิดพลาด โดยบังคับให้ระบบตรวจสอบทั้งชื่อผู้ใช้และสถานะบัญชีที่เปิดใช้งาน (Active) เท่านั้น\n\n" +
                        "SELECT username, role\n" +
                        "FROM users\n" +
                        "WHERE username = 'john_doe'\n" +
                        "___1___\n" +
                        "___2___ = ___3___;",
                Arrays.asList("AND", "status", "'active'", "OR", "password", "'disabled'"),
                "SELECT username, role\nFROM users\nWHERE username = 'john_doe'\nAND\nstatus = 'active';",
                "AND"
        ));

        // SQL - Medium
        questionList.add(new Question(
                "sql_002",
                "sql",
                "Medium",
                "-- โจทย์: เติมคำสั่งการใช้ Prepared Statement (Parameterized Query) เพื่อป้องกันการโจมตีประเภท SQL Injection ในขั้นตอนตรวจสอบการเข้าสู่ระบบ\n\n" +
                        "PREPARE login_stmt FROM\n" +
                        "'SELECT id, username FROM accounts WHERE email = ___1___ AND password_hash = ___2___';\n" +
                        "SET @user_email = 'user@example.com';\n" +
                        "SET @user_pass = 'hashed_pass_value';\n\n" +
                        "EXECUTE login_stmt USING ___3___;",
                Arrays.asList("?", "@user_email, @user_pass", "admin", "*", "'1'='1'", "@user_pass"),
                "PREPARE login_stmt FROM\n'SELECT id, username FROM accounts WHERE email = ? AND password_hash = ?';\nSET @user_email = 'user@example.com';\nSET @user_pass = 'hashed_pass_value';\n\nEXECUTE login_stmt USING @user_email, @user_pass;",
                "?"
        ));

        // SQL - Hard
        questionList.add(new Question(
                "sql_003",
                "sql",
                "Hard",
                "-- โจทย์: เติมคำสั่งการกำหนดสิทธิ์ (Least Privilege) และเปิดใช้ระบบ Masking เพื่อซ่อนเลขบัตรประชาชน ป้องกันข้อมูลสำคัญรั่วไหล\n\n" +
                        "ALTER TABLE customer_info\n" +
                        "MODIFY COLUMN national_id ___1___\n" +
                        "WITH (FUNCTION = '___2___');\n\n" +
                        "___3___ SELECT ON customer_info TO 'app_read_role';",
                Arrays.asList("MASKED", "partial(0,\"XXXXXXXXX\",4)", "GRANT", "UNMASK", "DROP", "default()"),
                "ALTER TABLE customer_info\nMODIFY COLUMN national_id MASKED\nWITH (FUNCTION = 'partial(0,\"XXXXXXXXX\",4)');\n\nGRANT SELECT ON customer_info TO 'app_read_role';",
                "MASKED"
        ));

        // ==========================================
        // 3. ภาษา Java (java)
        // ==========================================

        // Java - Easy
        questionList.add(new Question(
                "java_001",
                "java",
                "Easy",
                "// โจทย์: เติมคำสั่งเพื่อตรวจสอบความยาวของ API Token ต้องไม่เป็นค่าว่าง (null) และต้องมีความยาว 32 ตัวอักษรขึ้นไป\n\n" +
                        "public class TokenValidator {\n" +
                        "    public static boolean validateToken(String token) {\n" +
                        "        if (___1___ ___2___ token.length() >= 32) {\n" +
                        "            return ___3___;\n" +
                        "        }\n" +
                        "        return false;\n" +
                        "    }\n" +
                        "}",
                Arrays.asList("token != null", "&&", "true", "token == null", "||", "false"),
                "public class TokenValidator {\n    public static boolean validateToken(String token) {\n        if (token != null && token.length() >= 32) {\n            return true;\n        }\n        return false;\n    }\n}",
                "token != null"
        ));

        // Java - Medium
        questionList.add(new Question(
                "java_002",
                "java",
                "Medium",
                "// โจทย์: เติมคำสั่งเพื่อป้องกันปัญหา Timing Attack ในขั้นตอนการเปรียบเทียบ Signature/Hash โดยใช้ฟังก์ชันเปรียบเทียบเวลาคงที่\n\n" +
                        "import java.security.MessageDigest;\n\n" +
                        "public class SignatureCheck {\n" +
                        "    public static boolean verify(byte[] expectedSig, byte[] inputSig) {\n" +
                        "        boolean isValid = ___1___.___2___(expectedSig, ___3___);\n" +
                        "        return isValid;\n" +
                        "    }\n" +
                        "}",
                Arrays.asList("MessageDigest", "isEqual", "inputSig", "Arrays", "equals", "expectedSig"),
                "import java.security.MessageDigest;\n\npublic class SignatureCheck {\n    public static boolean verify(byte[] expectedSig, byte[] inputSig) {\n        boolean isValid = MessageDigest.isEqual(expectedSig, inputSig);\n        return isValid;\n    }\n}",
                "MessageDigest"
        ));

        // Java - Hard
        questionList.add(new Question(
                "java_003",
                "java",
                "Hard",
                "// โจทย์: เติมคำสั่งเพื่อป้องกันช่องโหว่ XML External Entity (XXE) Injection โดยปิดการทำงานของ External DTDs และ Entities\n\n" +
                        "import javax.xml.parsers.DocumentBuilderFactory;\n\n" +
                        "public class SafeXmlParser {\n" +
                        "    public static void secureParser(DocumentBuilderFactory dbf) throws Exception {\n" +
                        "        dbf.setFeature(\"___1___\", true);\n" +
                        "        dbf.setFeature(\"http://xml.org/sax/features/external-general-entities\", ___2___);\n" +
                        "        dbf.setFeature(\"http://xml.org/sax/features/external-parameter-entities\", ___3___);\n" +
                        "    }\n" +
                        "}",
                Arrays.asList("http://apache.org/xml/features/disallow-doctype-decl", "false", "false", "true", "http://xml.org/sax/features/validation", "null"),
                "import javax.xml.parsers.DocumentBuilderFactory;\n\npublic class SafeXmlParser {\n    public static void secureParser(DocumentBuilderFactory dbf) throws Exception {\n        dbf.setFeature(\"http://apache.org/xml/features/disallow-doctype-decl\", true);\n        dbf.setFeature(\"http://xml.org/sax/features/external-general-entities\", false);\n        dbf.setFeature(\"http://xml.org/sax/features/external-parameter-entities\", false);\n    }\n}",
                "http://apache.org/xml/features/disallow-doctype-decl"
        ));

        questionDao.insertAll(questionList);
    }

    public List<Question> getQuestionsForLanguage(String language) {
        return questionDao.getQuestionsByLanguage(language);
    }

    public String getHint(String questionId) {
        return questionDao.getHintByQuestionId(questionId);
    }

    public String getAnswer(String questionId) {
        return questionDao.getAnswerByQuestionId(questionId);
    }

    public Question getQuestionById(String questionId) {
        return questionDao.getQuestionById(questionId);
    }
}