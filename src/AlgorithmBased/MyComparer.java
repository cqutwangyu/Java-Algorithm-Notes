package AlgorithmBased;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @ClassName MyComparer
 * @Description 比价器使用方法
 * @Author ChongqingWangYu
 * @DateTime 2019/3/24 10:14
 * @GitHub https://github.com/ChongqingWangYu
 */
public class MyComparer {
    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 24);
        Student student3 = new Student("C", 3, 25);
        Student[] students = {student3, student1, student2};
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        //优先队列 堆结构，传入对象时需要提供比较器
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);
        while (!heap.isEmpty()) {
            Student student = heap.poll();
            System.out.println(student.toString());
        }
        TreeSet<Student> treeSet = new TreeSet<>(new IdAscendingComparator());

    }

    private static void printStudents(Student[] students) {
        System.out.println("===========");
        for (Student s : students) {
            System.out.println(s.toString());
        }
        System.out.println("===========");
    }

    private static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
//            if (o1.id < o2.id) {
//                //o1排在o2前面
//                return -1;
//            } else if (o2.id < o1.id) {
//                //o2排在o1前面
//                return 1;
//            } else {
//                //两个数相等，顺序不变
//                return 0;
//            }
            return o1.id - o2.id;
        }
    }

    static class Student {
        String name;
        int id;
        int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                            ", id=" + id +
                            ", age=" + age
                    ;
        }
    }
}
