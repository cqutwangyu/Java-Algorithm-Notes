package real;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName 猫狗队列
 * @Description 实现一种狗猫队列的结构，要求如下：用户可以调用add方法将cat类或dog类的实例放入队列中；用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * @Author cqutwangyu
 * @DateTime 2019/3/28 19:37
 * @GitHub https://github.com/cqutwangyu
 */
public class 猫狗队列 {
    /**
     * add方法将cat类或dog类的实例放入队列中；
     * pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
     * pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
     * pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
     * isEmpty方法，检查队列中是否还有dog或cat的实例；
     * isDogEmpty方法，检查队列中是否有dog类的实例；
     * isCatEmpty方法，检查队列中是否有cat类的实例。
     *
     * @param args
     */
    public static void main(String[] args) {
        DogCatQueue q = new DogCatQueue();
        q.add(new Pet("cat"));
        q.add(new Pet("dog"));
        q.add(new Pet("dog"));
        q.add(new Pet("cat"));
        q.add(new Pet("cat"));
        System.out.println(q.isEmpty());
        System.out.println(q.pollAll().getPetType());
        System.out.println(q.pollAll().getPetType());
        System.out.println(q.pollAll().getPetType());
        System.out.println(q.isEmpty());
        System.out.println(q.isDogEmpty());
        System.out.println(q.isCatEmpty());
    }

    /**
     * 将猫和狗分别存在不同队列中，使用自定义封装类PetEnter给Pet贴上序号
     */
    static class DogCatQueue {
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DogCatQueue() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("err,not dog or cat");
            }
        }

        /**
         * 根据封装类记录的次序，从小到大依次弹出
         */
        public Pet pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("err,queue is empty");
            }
        }

        public Dog pollDog() {
            if (!this.dogQ.isEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty");
            }
        }

        public Cat pollCat() {
            if (!this.catQ.isEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty");
            }
        }

        public boolean isEmpty() {
            return dogQ.isEmpty() && catQ.isEmpty();
        }

        public boolean isDogEmpty() {
            return dogQ.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQ.isEmpty();
        }
    }

    /**
     * 将Pet封装，给Pet加上count属性，记录进入的序号
     */
    static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getPetEnterType() {
            return pet.getPetType();
        }
    }

    /**
     * 以下是题目给出的代码
     */
    static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return type;
        }

    }

    static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
}
