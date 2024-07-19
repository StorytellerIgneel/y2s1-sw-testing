package FileHandling;

import java.time.LocalDate;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType() == LocalDate.class) {
            return (TypeAdapter<T>) new LocalDateTypeAdapter();
        }
        return null;
    }

    private static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {
        @Override
        public void write(JsonWriter out, LocalDate value) throws java.io.IOException {
            out.value(value.toString());
        }

        @Override
        public LocalDate read(JsonReader in) throws java.io.IOException {
            return LocalDate.parse(in.nextString());
        }
    }
}
