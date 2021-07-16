public class ForLoopRunner {
    public static void main(String[] args){
        runAltForLoop();
    }

    public static void runForLoop(){
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }

    public static void runAltForLoop(){
        boolean condition = true;
        for (int i = 7; condition || i == 31 ; i *= 3){
            if(i % 3 == 0){
                condition = false;
                System.out.println("CONDITION "+ i +" % 3 == 0");
            }
            System.out.println(i);
        }
    }

    public static void runNestedForLoop(){
        int area = 0;
        for (int length = 1; length < 4 ; length++ ){
            for (int width = 1; width< 4 ; width++){
                area = length * width;
                System.out.println("Length: " + length + ", Width: " + width + "Area: " + area);
            }
        }
    }
}
