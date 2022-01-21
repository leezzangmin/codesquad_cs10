import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class ClassifierAlpha {
    private int number;

    public ClassifierAlpha(int number) {
        this.number = number;
    }

    Predicate<Integer> isFactor = i -> this.number % i == 0;

    public Set factors(int target) { // supplier?
        HashSet factors = new HashSet<>();
        for (int pod = 1 ; pod < target ; pod++) {
            if (isFactor.test(pod)) {
                factors.add(pod);
            }
        }
        return factors;
    }

    static public int sum(Set factors) {
        return factors.parallelStream().mapToInt(i -> (int)i).sum();
    }



    Predicate<Integer> isPerfect = i -> sum(factors(i)) == i ? true : false;
    Predicate<Integer> isAbundant = i -> sum(factors(i)) > i ? true : false;
    Predicate<Integer> isDeficient = i -> sum(factors(i)) < i ? true : false;
    Predicate<Integer> isPrime = i -> sum(factors(i))== 1 ? true : false;
    Predicate<Integer> isSquared = i -> Math.sqrt(i) % 1 == 0 ? true : false; // 어떤 자연수의 제곱이 되는 수


    public ArrayList<String> defineNumber() {
        ArrayList<String> answer = new ArrayList<String>(4);
        if(isPerfect.test(this.number))
            answer.add("perfect");
        else if(isAbundant.test(this.number))
            answer.add("abundant");
        else
            answer.add("deficient");
        if(isPrime.test(this.number))
            answer.add("prime");
        if(isSquared.test(this.number))
            answer.add("squared");
        return answer;
    }



    public static void main(String[] args) {
        for(int i=2;i<=100;i++){
            ClassifierAlpha a = new ClassifierAlpha(i);
            System.out.print(i);
            System.out.println(a.defineNumber());

        }

    }
}
//factors.stream().forEach(System.out::println);
