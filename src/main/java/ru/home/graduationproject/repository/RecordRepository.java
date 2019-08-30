package ru.home.graduationproject.repository;

import org.springframework.stereotype.Repository;
import ru.home.graduationproject.domain.Record;

@Repository
public class RecordRepository {
    private Record[] items = new Record[20];
    private int nextIndex = 0;

    public Record[] getAll() {
        return items;
    }

    public void add(Record record) {
        items[nextIndex] = record;
        nextIndex++;
    }

    public void update(Record record) {
        for (int i = 0; i < items.length; i++) {
            Record item = items[i];
            if (item != null && item.getId() == record.getId()) {
                items[i] = record;
                return;
            }
        }
    }

    public void removeById(int id) {
        for (int i = 0; i < items.length; i++) {
            Record item = items[i];
            if (item != null && item.getId() == id) {
                items[i] = null;
                return;
            }
        }
    }

    public Record getById(int id) {
        for (Record item : items) {
            if (item != null && item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}
