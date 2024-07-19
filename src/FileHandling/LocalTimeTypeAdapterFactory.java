package FileHandling;

import java.time.LocalTime;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalTimeTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType() == LocalTime.class) {
            return (TypeAdapter<T>) new LocalTimeTypeAdapter();
        }
        return null;
    }

    private static class LocalTimeTypeAdapter extends TypeAdapter<LocalTime> {
        @Override
        public void write(JsonWriter out, LocalTime value) throws java.io.IOException {
            out.value(value.toString());
        }

        @Override
        public LocalTime read(JsonReader in) throws java.io.IOException {
            return LocalTime.parse(in.nextString());
        }
    }
}

