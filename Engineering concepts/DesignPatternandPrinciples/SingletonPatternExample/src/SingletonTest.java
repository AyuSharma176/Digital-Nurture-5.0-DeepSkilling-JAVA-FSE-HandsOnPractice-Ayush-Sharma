public class SingletonTest {
    static void main(String[] args) {
        Logger l1= Logger.getInstance();
        Logger l2= Logger.getInstance();

        l1.log("First log message");
        l2.log("Second log message");

        if(l1==l2){
            System.out.println("Only one Logger instance exist");
        }else{
            System.out.println("Multiple Logger instance exist");
        }
        System.out.println("HashCode of l1: "+l1.hashCode());
        System.out.println("HashCode of l2: "+l2.hashCode());
    }
}
