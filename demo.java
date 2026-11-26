
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
        a.add(new TaiKhoan("Tran Cao Thai", "09/11/2000", 38));
        a.add(new TaiKhoan("Nguyen Cao Phong", "03/20/2019", 50));
        a.add(new TaiKhoan("Dinh Cao Hoa", "11/02/2000", 24));
        a.add(new TaiKhoan("Lo Thi Huong", "09/30/1920", 31));
        a.add(new TaiKhoan("Tran Tuan Phong", "08/10/2002", 30));

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
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getUsername().contains(username)) {
                return i;
            }
        }
        return p;
    }

    @Override
    public void xoa(String username) {
        int p = tim(username);
        if (p == -1) {
            System.out.println("tim ko thay");
        } else {
            a.remove(a.get(p));
        }
    }

    @Override
    public void xoaNhieu(int age) {

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
        Collections.sort(a);
    }

    @Override
    public void sapXepDate() {
        Collections.sort(a, new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan o1, TaiKhoan o2) {
                return o1.getDob().compareTo(o2.getDob());
            }
        });
    }

    @Override
    public void sapXepTen() {
        Collections.sort(a, new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan o1, TaiKhoan o2) {
                String u1 = o1.getUsername();
                String u2 = o2.getUsername();
                String t1 = u1.substring(u1.lastIndexOf(" ")) + u1;
                String t2 = u2.substring(u2.lastIndexOf(" ")) + u2;
                return t1.compareTo(t2);
            }
        });
    }

}

class TaiKhoan implements Comparable<TaiKhoan> {

    private String ma, username;
    private Date dob;
    private int age;
    private static int sMa = 1;

    public TaiKhoan() {
    }

    public TaiKhoan(String username, String dob, int age) {
        this.ma = String.format("TK%03d", sMa++);
        this.username = username;
        this.dob = new Date(dob);
        this.age = age;
    }

    public void input(Scanner in) {
        this.ma = String.format("TK%03d", sMa++);
        this.username = in.nextLine();
        this.dob = new Date(in.nextLine());
        this.age = Integer.parseInt(in.nextLine());
    }

    @Override
    public String toString() {
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
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

    @Override
    public int compareTo(TaiKhoan o) {
        return this.ma.compareTo(o.getMa());
    }

}
