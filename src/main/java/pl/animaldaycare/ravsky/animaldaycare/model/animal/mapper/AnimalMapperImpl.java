package pl.animaldaycare.ravsky.animaldaycare.model.animal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
public class AnimalMapperImpl implements AnimalMapper {

    private final static String REQUEST = "Request";
    private final ModelMapper modelMapper;

    public AnimalMapperImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Animal map(AnimalRequest animalRequest) {
        String className = animalRequest.getClass().getSimpleName().replace(REQUEST, "");
        String animalClassName = "pl.animaldaycare.ravsky.animaldaycare.model.animal." + className;
        try {
            Class<?> animalClass = Class.forName(animalClassName);
            Constructor<?> constructor = animalClass.getConstructor();
            Animal animal = (Animal) constructor.newInstance();
            modelMapper.map(animalRequest, animal);
            return animal;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Unsupported animal request type", e);
        }
    }

    @Override
    public AnimalResponse map(Animal animal) {
        String className = animal.getClass().getSimpleName();
        String responseClassName = className.endsWith(REQUEST) ?
                "pl.animaldaycare.ravsky.animaldaycare.model.animal.response." + className.replace(REQUEST, "Response") :
                "pl.animaldaycare.ravsky.animaldaycare.model.animal.response." + className + "Response";

        try {
            Class<?> responseClass = Class.forName(responseClassName);
            Constructor<?> constructor = responseClass.getConstructor();
            AnimalResponse response = (AnimalResponse) constructor.newInstance();
            modelMapper.map(animal, response);
            return response;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Unsupported animal type", e);
        }
    }
}
