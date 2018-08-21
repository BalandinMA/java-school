package heroes;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author Evgeny Borisov
 */
public class CharacterFactory {

    private List<Class<? extends Character>> characterClasses = new ArrayList<>();

    public CharacterFactory() {
        Reflections scanner = new Reflections("heroes");
        Set<Class<? extends Character>> set = scanner.getSubTypesOf(Character.class);
        for (Class<? extends Character> clazz : set) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                characterClasses.add(clazz);
            }
        }

    }

    @SneakyThrows
    public Character createCharacter(){
        int i = RandomFactory.getInstance().getNumberBetween(0, characterClasses.size());
        return characterClasses.get(i).newInstance();
    }
}
