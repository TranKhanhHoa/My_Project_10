
import java.text.SimpleDateFormat;
import java.util.*;

public class demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        QuanLyTaiKhoan q = new QuanLyTaiKhoan();
        while (true) {
            System.out.println("1.Hien thi"
                    + "\n2.them"
                    + "\n3.xoa"
                    + "\n4.xoa nhieu"
                    + "\n5.tim"
                    + "\n6.sua"
                    + "\n7.sapXepMa"
                    + "\n8.sapXepDate"
                    + "\n9.sapXepTen"
            );
            int chon;
            System.out.println("chon:");
            chon = Integer.parseInt(in.nextLine());
            switch (chon) {
                case 1 ->
                    q.hienThi();
                case 2 ->
                    q.them(in);
                case 3 ->
                    q.xoa(in.nextLine());
                case 4 ->
                    q.xoaNhieu(Integer.parseInt(in.nextLine()));
                case 5 ->
                    q.timKiem(in.nextLine());
                case 6 ->
                    q.sua(in.nextLine());
                case 7 ->
                    q.sapXepMa();
                case 8 ->
                    q.sapXepDate();
                case 9 ->
                    q.sapXepTen();
            }
        }
    }
}

interface ChucNang {

    public void hienThi();

    public void them(Scanner in);

    public void xoa(String username);

    public void xoaNhieu(int age);

    public void timKiem(String username);

    public void sua(String ma);

    public void sapXepMa();

    public void sapXepDate();

    public void sapXepTen();
}

class QuanLyTaiKhoan implements ChucNang {

    private List<TaiKhoan> a = new ArrayList<>();

    public QuanLyTaiKhoan() {
        a.add(new TaiKhoan("TranCaoThai", new Date("09-11-2000"), 18));
        a.add(new TaiKhoan("NguyenCaoPhong", new Date("03-20-2019"), 50));
    }

    @Override
    public void hienThi() {
        for (TaiKhoan x : a) {
            System.out.println(x);
        }
    }

    @Override
    public void them(Scanner in) {
        TaiKhoan x = new TaiKhoan();
        x.input(in);
        a.add(x);
    }

    private int tim(String username) {
        int p = -1;
        for (int i = 0; i <= a.size(); i++) {
            if (a.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return p;
    }

    @Override
    public void xoa(String username) {

    }

    @Override
    public void xoaNhieu(int age) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void timKiem(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sua(String ma) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sapXepMa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sapXepDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sapXepTen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class TaiKhoan {

    private String ma, username;
    private Date dob;
    private int age;
    private static int sMa = 1;

    public TaiKhoan() {
    }

    public TaiKhoan(String username, Date dob, int age) {
        this.ma = String.format("TK%03d", sMa++);
        this.username = username;
        this.dob = dob;
        this.age = age;
    }

    public void input(Scanner in) {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        this.ma = String.format("TK%03d", sMa++);
        this.username = in.nextLine();
        this.dob = new Date(in.nextLine());
        this.age = Integer.parseInt(in.nextLine());
    }

    @Override
    public String toString() {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        return this.ma + " " + this.username + " " + spf.format(dob) + " " + this.age;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
