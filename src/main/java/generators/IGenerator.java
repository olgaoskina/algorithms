package generators;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public interface IGenerator<Type> {
    Type[] generateTestArray(int size);
}
