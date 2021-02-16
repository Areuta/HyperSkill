package carsharing.model;

import java.util.Objects;

// Базовый класс модели, имеющий ключ id
public class BaseModel {
    protected long id;

    public BaseModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BaseModel(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return id == baseModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

