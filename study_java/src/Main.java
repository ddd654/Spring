//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //System.out.printf("Hello and welcome!");
        System.out.println("Hello and welcome!");

        int age = 13;
        if(age >=19){
            System.out.println("adult");
        } else {
            System.out.println("teenager");
        }

        int count = 0;
        while(count <=3){ //3일떄도 한번 더 돈다
            count ++;
            System.out.println("현재 숫자" + count);
        }

    }
}