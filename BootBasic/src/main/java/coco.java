public class coco {
    public static int solution(int[] dot) {
        int answer = 0;

        //1사분면 나오게 하기
        if (dot[0] > 0 && dot[1] > 0) {
            answer = 1;
        } else if (dot[0] < 0 && dot[1] > 0) {
            answer = 2;
        } else if (dot[0] < 0 && dot[1] < 0) {
            answer = 3;
        } else if (dot[0] > 0 && dot[1] < 0){
            answer =4;
        }

            return answer;
    }

    public static void main(String[] args) {
        int[] ex = {11, 22}; //1
        System.out.println(solution(ex));
    }
}
