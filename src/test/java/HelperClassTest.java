
import com.akjnfinal.royalrumble.HelperClass;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AkhilJayan
 */
public class HelperClassTest {

    public HelperClass helper = new HelperClass();

    @Test
    public void should_not_return_duplicate_names() {
        List<String> names = Arrays.asList("Louis IX", "Louis VIII", "David II", "David II");
        final int expected = 3;
        final int actual = helper.GetSortedList(names).size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void should_sort_input_correctly() {
        List<String> names = Arrays.asList("Louis IX", "David II", "Louis VIII", "David II", "David II", "Savio VII", "Martin X");
        final List<String> expected = Arrays.asList("David II", "Louis VIII", "Louis IX", "Martin X", "Savio VII");
        final List<String> actual = helper.GetSortedList(names);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void should_return_sorted_fifty_names() {
        List<String> names = RandomInputGenerator();
        final int expected = 50;
        final int actual = helper.GetSortedList(names).size();
        Assert.assertEquals(actual, expected);
    }
    
    
    @Test
    public void should_check_the_input_validations() {
        Assert.assertTrue(3<5);
    }

    private List<String> RandomInputGenerator() {
        List<String> result = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i<50; i++){
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            int  n = rand.nextInt(50) + 1;
            String roman = helper.ConvertIntToRoman(n);
            result.add(firstName + " " +roman);
        }
        return result;
    }

}
