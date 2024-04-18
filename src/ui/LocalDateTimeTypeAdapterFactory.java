package ui;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTimeTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType() == LocalDateTime.class) {
            return (TypeAdapter<T>) new LocalDateTimeTypeAdapter();
        }
        return null;
    }

    private static class LocalDateTimeTypeAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(JsonWriter out, LocalDateTime value) throws java.io.IOException {
            out.value(value.toString());
        }

        @Override
        public LocalDateTime read(JsonReader in) throws java.io.IOException {
            return LocalDateTime.parse(in.nextString());
        }
    }
}
