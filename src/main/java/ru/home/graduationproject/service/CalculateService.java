package ru.home.graduationproject.service;

import org.springframework.stereotype.Service;
import ru.home.graduationproject.domain.Record;
import ru.home.graduationproject.repository.RecordRepository;
import ru.home.graduationproject.core.СarbohydrateCalculator;

@Service
public class CalculateService {
    private RecordRepository repository;
    private int nextId = 1;

    public CalculateService(RecordRepository repository) {
        this.repository = repository;
    }

    public void add( String product, int productAmount, int carbohydratePerAmount) {

        СarbohydrateCalculator amountOfBreadUnit = new СarbohydrateCalculator(productAmount, carbohydratePerAmount);
        Record record = new Record(nextId, product, productAmount, carbohydratePerAmount, amountOfBreadUnit.calculate());
        repository.add(record);
        nextId++;
    }

    public Record[] getAll() {
        return repository.getAll();
    }

    public Record getById(int id) {
        return repository.getById(id);
    }

    public void updateById(int id,  String product, int productAmount, int carbohydratePerAmount) {
        СarbohydrateCalculator amountOfBreadUnit = new СarbohydrateCalculator(productAmount, carbohydratePerAmount);
        Record record = new Record(id, product, productAmount, carbohydratePerAmount, amountOfBreadUnit.calculate());
        repository.update(record);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}
