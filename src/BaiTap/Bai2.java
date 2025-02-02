package BaiTap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age;
        double height;
        boolean isStudent;
        char grade;
        String name;

        // Nhập dữ liệu
        System.out.print("Nhập tuổi: ");
        age = scanner.nextInt();
        System.out.print("Nhập chiều cao: ");
        height = scanner.nextDouble();
        System.out.print("Là sinh viên? (true/false): ");
        isStudent = scanner.nextBoolean();
        System.out.print("Nhập điểm (A, B, C...): ");
        grade = scanner.next().charAt(0);
        System.out.print("Nhập tên: ");
        scanner.nextLine(); // Đọc bỏ dòng new line sau boolean
        name = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter("data.dat");
            writer.write("Tuổi: " + age + "\n");
            writer.write("Chiều cao: " + height + "\n");
            writer.write("Là sinh viên: " + isStudent + "\n");
            writer.write("Điểm: " + grade + "\n");
            writer.write("Tên: " + name + "\n");
            writer.close();
            System.out.println("Đã ghi dữ liệu vào file data.dat");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }

        scanner.close();
    }
}
