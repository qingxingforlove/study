package study.why;

//什么是反射
public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //反射获取类的Class对象
        Class c1 = Class.forName("study.why.User");
        User user = new User();
        System.out.println(c1);
        System.out.println(User.class);
        System.out.println(user.getClass());
        System.out.println(c1.getSuperclass());
        System.out.println("添加打印信息");
    }
}

//实体类
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test01{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}